package inn.startXway.eatit;

        import android.content.Intent;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.view.View;

        import inn.startXway.eatit.helper.SharedPrefManager;

public class Intro_3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.intro3);

        if(SharedPrefManager.getInstance(this).checkIntro())
        {
            startActivity(new Intent(getApplicationContext(),ActivityTest.class));
        }
    }
    public void next_step_3(View v)
    {
        Intent i = new Intent(Intro_3.this,Intro_4.class);
        startActivity(i);
    }
    public void onBackPressed() {
        finishAffinity();
        super.onBackPressed();
    }
}
