package com.example.miniproject;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ARCustomer extends AppCompatActivity {
    Button bcontactusar, blogoutar;

    @Override
    //Called when the activity is starting.
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer);


        bcontactusar=(Button) findViewById(R.id.b14ar);
        blogoutar=(Button) findViewById(R.id.b15ar);

        bcontactusar.setOnClickListener(new View.OnClickListener() {
            @Override
            //when the button is clicked. the code in the OnClick method will run.
            public void onClick(View view) {
                Intent pressar=new Intent(ARCustomer.this, ARContactUs.class);
                startActivity(pressar);
            }
        });
        blogoutar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent pressar=new Intent(ARCustomer.this, ARLogin.class);
                startActivity(pressar);
            }
        });

    }
}