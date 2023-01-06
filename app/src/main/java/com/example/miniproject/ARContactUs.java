package com.example.miniproject;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ARContactUs extends AppCompatActivity {
    TextView tphoneNoar, tinstaar;
    Button blogoutar;

    @Override
    //Called when the activity is starting.
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_us);

        tphoneNoar=(TextView) findViewById(R.id.t1ar);
        tinstaar=(TextView) findViewById(R.id.t2ar);

        blogoutar=(Button) findViewById(R.id.b18ar);

        blogoutar.setOnClickListener(new View.OnClickListener() {
            @Override
            //when the button is clicked. the code in the OnClick method will run.
            public void onClick(View view) {
                Intent pressar=new Intent(ARContactUs.this, ARCustomer.class);
                startActivity(pressar);
            }
        });
    }
}