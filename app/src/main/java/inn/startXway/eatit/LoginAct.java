package inn.startXway.eatit;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.Toast;
import java.util.List;
import inn.startXway.eatit.Api.ApiServices;
import inn.startXway.eatit.Api.ApiURL;
import inn.startXway.eatit.helper.SharedPrefManager;
import inn.startXway.eatit.models.UserResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;


public class LoginAct extends AppCompatActivity {

    Button butRegi,facebook;
    AutoCompleteTextView phone,pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        if(SharedPrefManager.getInstance(this).checkLogin())
        {
            startActivity(new Intent(getApplicationContext(),BasicPack.class));
        }

        butRegi = findViewById(R.id.take_me_there_btn);
        phone = findViewById(R.id.username);
        pass = findViewById(R.id.password);
        facebook = findViewById(R.id.facebook_btn);

        facebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPrefManager.getInstance(getApplicationContext()).userLogout();
            }
        });


        butRegi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String upass,uphone;

                upass = pass.getText().toString();
                uphone =phone.getText().toString();

                boolean invalid = false;

                if(upass.equals("")){
                    invalid = true;
                    Toast.makeText(getApplicationContext(),"Please enter your Password",Toast.LENGTH_LONG).show();
                }else if(uphone.equals("")){
                        invalid = true;
                        Toast.makeText(getApplicationContext(),"Please enter registered Phone number",Toast.LENGTH_LONG).show();
                    }else if(uphone.length()!=10){
                    invalid = true;
                    Toast.makeText(getApplicationContext(),
                            "Please enter your 10 digits phone number", Toast.LENGTH_SHORT).show();
                }else if (pass.length() < 8) {
                    invalid = true;
                    Toast.makeText(getApplicationContext(),
                            "Please enter atleast 6 digits password", Toast.LENGTH_SHORT).show();
                }
                else if(invalid == false)
                {
                    Toast.makeText(getApplicationContext(),"seee this"+" "+upass+" "+uphone+" ", Toast.LENGTH_LONG).show();
                    ApiURL apiURL = new ApiURL();
                    Retrofit retrofit = apiURL.getRetrofitObject();
                    ApiServices apiServices = retrofit.create(ApiServices.class);
                    Call<List<UserResponse>> call = apiServices.login(upass,uphone);
                    call.enqueue(new Callback<List<UserResponse>>() {
                        @Override
                        public void onResponse(Call<List<UserResponse>> call, Response<List<UserResponse>> response) {
                            String mySuccess,myUname,myUphone;
                            mySuccess = response.body().get(0).getSuccess();
                            myUname = response.body().get(0).getName();
                            myUphone = response.body().get(0).getPhone();
                            if(mySuccess.compareToIgnoreCase("yes")==0)
                            {
                                SharedPrefManager.getInstance(getApplicationContext()).setSharedData(myUname,myUphone);
                                startActivity(new Intent(getApplicationContext(),BasicPack.class));
                            }
                            else
                            {
                                Toast.makeText(getApplicationContext(),"Invalid login credentials",Toast.LENGTH_LONG).show();
                            }
                        }

                        @Override
                        public void onFailure(Call<List<UserResponse>> call, Throwable t) {
                            Log.d("retERROR:",t.getMessage());
                        }
                    });


                }

            }
        });



    }
    public void register_open(View v)
    {
        Intent i = new Intent(getApplicationContext(),Register.class);
        startActivity(i);
    }



    private int count = 0;
    @Override
    public void onBackPressed() {
        count++;
        if (count >=1) {

            Toast.makeText(getApplicationContext(), "Exiting Eatit!", Toast.LENGTH_SHORT).show();


            finishAffinity();
        } else {
            Toast.makeText(this, "Press back again to Leave!", Toast.LENGTH_SHORT).show();

            // resetting the counter in 2s
            Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    count = 0;
                }
            }, 2000);
        }
        super.onBackPressed();
    }
}
