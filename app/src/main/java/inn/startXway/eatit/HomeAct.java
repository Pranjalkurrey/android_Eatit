package inn.startXway.eatit;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;


public class HomeAct extends AppCompatActivity {
    TextView txtId;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        Intent intent = getIntent();
        String id =intent.getStringExtra("id");
        Toast.makeText(getApplicationContext(),"id is "+id,Toast.LENGTH_LONG).show();
        txtId =findViewById(R.id.txtId);


    }


}
