package inn.startXway.eatit;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import inn.startXway.eatit.helper.SharedPrefManager;

public class Askme extends AppCompatActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.intro1);

        if(SharedPrefManager.getInstance(this).checkIntro())
        {
            startActivity(new Intent(getApplicationContext(),BasicPack.class));
        }

    }
    public void next_step_1(View v)
    {
        Intent i = new Intent(Askme.this,Intro_2.class);
        startActivity(i);
    }

    public void onBackPressed() {
        finishAffinity();
        super.onBackPressed();
    }
}

