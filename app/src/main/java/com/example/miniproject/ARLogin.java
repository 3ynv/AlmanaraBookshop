package com.example.miniproject;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;
public class ARLogin extends AppCompatActivity {
    Button bloginar;
    EditText eusernamear, epasswordar;
    RadioGroup RadioGar;
    RadioButton Userar, Adminar;
    @Override
    //Called when the activity is starting.
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        bloginar=(Button) findViewById(R.id.b5ar);
        eusernamear=(EditText) findViewById(R.id.e4ar);
        epasswordar=(EditText) findViewById(R.id.e5ar);
        RadioGar = (RadioGroup) findViewById(R.id.rg1ar);
        Userar=(RadioButton) findViewById(R.id.ru1ar);
        Adminar=(RadioButton) findViewById(R.id.ra1ar);
        bloginar.setOnClickListener(new View.OnClickListener() {
            @Override
            //when the button is clicked. the code in the OnClick method will run.
            public void onClick(View view) {
                String username =eusernamear.getText().toString();
                String Pass = epasswordar.getText().toString();
                //if conditional
                if (username.equals("") && Pass.equals(""))
                    Toast.makeText(ARLogin.this, "Inter Details", Toast.LENGTH_SHORT).show();
                else {
                    if (username.equals("mec") && Pass.equals("mec123")){
                        if(Userar.isChecked()){
                            Intent pressar=new Intent(ARLogin.this, ARCustomer.class);
                            startActivity(pressar);
                        }else if (Adminar.isChecked()){
                            Intent pressar=new Intent(ARLogin.this, ARMainActivity.class);
                            startActivity(pressar);
                        }else {
                            Toast.makeText(ARLogin.this, "Enter detail", Toast.LENGTH_SHORT).show();
                        }
                    }
                    else {
                        Toast.makeText(ARLogin.this, "Wrong Username/Pass", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}