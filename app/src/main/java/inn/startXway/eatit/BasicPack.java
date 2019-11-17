package inn.startXway.eatit;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
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

public class BasicPack extends AppCompatActivity {
    List<UserResponse> userResponseList;

    RecyclerView reBasicPack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basic_pack);

        if(SharedPrefManager.getInstance(this).checkLogin())
        {
            startActivity(new Intent(getApplicationContext(),BasicPack.class));
        }

        reBasicPack = findViewById(R.id.BasicPackRV);
        reBasicPack.setLayoutManager(new LinearLayoutManager(getApplicationContext()));

        ApiURL apiURL = new ApiURL();
        Retrofit retrofit = apiURL.getRetrofitObject();
        ApiServices apiServices = retrofit.create(ApiServices.class);
        Call<List<UserResponse>> call= apiServices.basicPackGet();
        call.enqueue(new Callback<List<UserResponse>>() {
            @Override
            public void onResponse(Call<List<UserResponse>> call, Response<List<UserResponse>> response) {
                userResponseList = response.body();
                BasicPackAdapter adapter = new BasicPackAdapter(getApplicationContext(),userResponseList);
                reBasicPack.setAdapter(adapter);

            }

            @Override
            public void onFailure(Call<List<UserResponse>> call, Throwable t) {
                Log.d("retERROR:",t.getMessage());
                }
        });
    }
    private int count = 0;
    @Override
    public void onBackPressed() {
        count++;
        if (count >=1) {
        /* If count is greater than 1 ,you can either move to the next
        activity or just quit. */
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
