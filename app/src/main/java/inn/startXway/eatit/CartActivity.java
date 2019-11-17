package inn.startXway.eatit;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.squareup.picasso.Picasso;
import java.util.List;
import inn.startXway.eatit.Api.ApiServices;
import inn.startXway.eatit.Api.ApiURL;
import inn.startXway.eatit.helper.SharedPrefManager;
import inn.startXway.eatit.models.UserResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class CartActivity extends AppCompatActivity {

    TextView itemName,itemPrice,itemTotal,toPay,descriptionTextBox,priceInLabel;
    ImageView itemImage;
    Button ProceedtoPayBtn,quantity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        Intent intent = getIntent();
       final String name =intent.getStringExtra("name");
       final String price =intent.getStringExtra("price");
        final String description =intent.getStringExtra("description");
        final String mealId = intent.getStringExtra("mealId");



        itemImage = findViewById(R.id.cart_item_image);
        itemName = findViewById(R.id.fill_item_name);
        itemPrice = findViewById(R.id.fill_price_in_description);
        itemTotal = findViewById(R.id.fill_item_total);
        toPay = findViewById(R.id.fill_to_pay);
        descriptionTextBox = findViewById(R.id.fill_item_description);
        ProceedtoPayBtn = findViewById(R.id.btn_to_pay);
        priceInLabel = findViewById(R.id.price_in_lable);

        // for testing
        quantity = findViewById(R.id.btn_qnt);

        quantity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPrefManager.getInstance(getApplicationContext()).userLogout();
                Toast.makeText(getApplicationContext(),"you are logout",Toast.LENGTH_LONG).show();
                Intent In = new Intent(getApplicationContext(),LoginAct.class);
                startActivity(In);
            }
        });

        // please delete after testing

        Picasso.get().load(getIntent().getStringExtra("mealImage")).into(itemImage);
        itemName.setText(name);
        itemTotal.setText("\u20B9"+price);
        itemPrice.setText("\u20B9"+price);
        toPay.setText("\u20B9"+price);
        priceInLabel.setText("\u20B9"+price);
        descriptionTextBox.setText(description);


        ProceedtoPayBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String userId = "1";

                ApiURL apiURL = new ApiURL();
                Retrofit retrofit = apiURL.getRetrofitObject();
                ApiServices apiServices = retrofit.create(ApiServices.class);
                Call<List<UserResponse>> call = apiServices.placeOrder(mealId,userId);
                call.enqueue(new Callback<List<UserResponse>>() {
                    @Override
                    public void onResponse(Call<List<UserResponse>> call, Response<List<UserResponse>> response) {
                            String success=response.body().get(0).getSuccess();

                        if(success.compareToIgnoreCase("Yes")==0){

                            Toast.makeText(getApplicationContext(),"your order is placed",Toast.LENGTH_LONG).show();

                            Intent i = new Intent(getApplicationContext(),PayGway.class);
                            i.putExtra("mealName",""+name);
                            i.putExtra("mealPrice",""+price);
                            i.putExtra("mealId",""+mealId);
                            startActivity(i);
                        }
                        else {
                            Toast.makeText(getApplicationContext(),"I Am an Error that occurred to your order",Toast.LENGTH_LONG).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<List<UserResponse>> call, Throwable t) {
                        Toast.makeText(getApplicationContext(),"Network Error",Toast.LENGTH_LONG).show();
                        Log.d("cartActivity retrofit",t.getMessage());
                    }
                });




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
            Intent intent = new Intent(getApplicationContext(),BasicPack.class);
            startActivity(intent);
            finish();



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
