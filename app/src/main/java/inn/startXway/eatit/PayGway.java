package inn.startXway.eatit;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import java.util.List;

import inn.startXway.eatit.Api.ApiServices;
import inn.startXway.eatit.Api.ApiURL;
import inn.startXway.eatit.models.UserResponse;
import retrofit2.Call;
import retrofit2.Retrofit;

public class PayGway extends AppCompatActivity {

    ImageButton phoneWallet,paytmWallet,addCard,googlePayUpi,bhimUpi,cash,arrow_btn;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pay_gway);
        phoneWallet = findViewById(R.id.phonepe_wallet_label);
        paytmWallet = findViewById(R.id.paytm_wallet_label);
        addCard = findViewById(R.id.add_a_card);
        googlePayUpi = findViewById(R.id.google_pay_btn);
        bhimUpi = findViewById(R.id.bhim_btn);
        cash = findViewById(R.id.pay_on_delivery_btn);
        arrow_btn = findViewById(R.id.top_bar_payment_arrow);

        Intent intent = getIntent();
        final String mealName = intent.getStringExtra("mealName");
        final  String mealPrice = intent.getStringExtra("mealPrice");
        final  String mealId = intent.getStringExtra("mealId");

        arrow_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),CartActivity.class);
                startActivity(i);
            }
        });
        phoneWallet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"phone pay wallet",Toast.LENGTH_LONG).show();
            }
        });
        paytmWallet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"payTM wallet",Toast.LENGTH_LONG).show();
            }
        });
        addCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"Add a card",Toast.LENGTH_LONG).show();
            }
        });
        googlePayUpi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"Google pay UPI",Toast.LENGTH_LONG).show();
            }
        });
        bhimUpi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"Bhim UPI",Toast.LENGTH_LONG).show();
            }
        });
        cash.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Toast.makeText(getApplicationContext(),"Please keep exact charge handy to help us serve you bettter",Toast.LENGTH_LONG).show();

            }
        });
    }
}
