package inn.startXway.eatit;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.intro1);

    }
    public void next_step_1(View v)
    {
        Intent i = new Intent(MainActivity.this,LoginAct.class);
        startActivity(i);
    }

}
