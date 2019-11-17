package inn.startXway.eatit;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import inn.startXway.eatit.helper.SharedPrefManager;

public class Intro_4 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.intro4);
    }


    public void next_step_4(View v)
    {  String Icheck ="into is set";
        SharedPrefManager.getInstance(getApplicationContext()).setAppData(Icheck);
        Intent i = new Intent(Intro_4.this,LoginAct.class);
        startActivity(i);
    }
    public void onBackPressed() {
        finishAffinity();
        super.onBackPressed();
    }
}
