package inn.startXway.eatit;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.Toast;
import inn.startXway.eatit.Api.ApiServices;
import inn.startXway.eatit.Api.ApiURL;
import inn.startXway.eatit.models.ResponseModel;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Register extends AppCompatActivity {
    Button butRegi;
    AutoCompleteTextView name,phone,pass;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);



        butRegi = findViewById(R.id.register_btn);
        name = findViewById(R.id.username);
        phone = findViewById(R.id.telephone);
        pass = findViewById(R.id.password);


        butRegi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String uname, upass, uphone;
                uname = name.getText().toString();
                upass = pass.getText().toString();
                uphone = phone.getText().toString();

                boolean invalid = false;

                if (upass.equals("")) {
                    invalid = true;
                    Toast.makeText(getApplicationContext(), "Please enter your Password", Toast.LENGTH_LONG).show();
                } else if (uphone.equals("")) {
                    invalid = true;
                    Toast.makeText(getApplicationContext(), "Please enter registered Phone number", Toast.LENGTH_LONG).show();
                } else if (uphone.length() != 10) {
                    invalid = true;
                    Toast.makeText(getApplicationContext(),
                            "Please enter your 10 digits phone number", Toast.LENGTH_SHORT).show();
                } else if (pass.length() < 8) {
                    invalid = true;
                    Toast.makeText(getApplicationContext(),
                            "Please enter atleast 6 digits password", Toast.LENGTH_SHORT).show();
                } else if (invalid == false){


                    Toast.makeText(getApplicationContext(), "seee this" + uname + " " + upass + " " + uphone + " ", Toast.LENGTH_LONG).show();
                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl(ApiURL.BASE_URL)
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
                ApiServices service = retrofit.create(ApiServices.class);
                Call<ResponseModel> call = service.register(uname, upass, uphone);
                call.enqueue(new Callback<ResponseModel>() {
                    @Override
                    public void onResponse(Call<ResponseModel> call, Response<ResponseModel> response) {
                        Toast.makeText(getApplicationContext(), "Registration successful enjoy the service", Toast.LENGTH_LONG).show();


                        Intent i = new Intent(getApplicationContext(),BasicPack.class);
                        startActivity(i);
                    }

                    @Override
                    public void onFailure(Call<ResponseModel> call, Throwable t) {
                        Toast.makeText(getApplicationContext(), "Error" + t.getMessage(), Toast.LENGTH_LONG).show();
                        Log.d("Error hai:", t.getMessage());
                    }
                });
               }
            }
        });
    }

}
