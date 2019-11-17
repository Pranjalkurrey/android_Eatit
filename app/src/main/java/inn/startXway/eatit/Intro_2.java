package inn.startXway.eatit;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import inn.startXway.eatit.helper.SharedPrefManager;

public class Intro_2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.intro2);

        if(SharedPrefManager.getInstance(this).checkIntro())
        {
            startActivity(new Intent(getApplicationContext(),ActivityTest.class));
        }
    }

    public void next_step_2(View v)
    {
        Intent i = new Intent(Intro_2.this,Intro_3.class);
        startActivity(i);
    }
    public void onBackPressed() {
        finishAffinity();
        super.onBackPressed();
    }
}
