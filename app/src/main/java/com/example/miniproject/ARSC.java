package com.example.miniproject;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class ARSC extends AppCompatActivity {
    Handler SC;
    @Override
    //Called when the activity is starting.
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sc);
        SC = new Handler();
        SC.postDelayed(new Runnable() {
            @Override
            //use for method from the current thread
            public void run() {
                Intent IntAct_52=new Intent(ARSC.this, ARLogin.class);
                startActivity(IntAct_52);
                finish();}
        },1869);
    }
}