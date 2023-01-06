package com.example.miniproject;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.FirebaseDatabase;
import java.util.HashMap;
import java.util.Map;
public class ARPlus extends AppCompatActivity {

    EditText enamear, epricear, eavailablear, eurlar;
    Button plusar, backar;

    @Override
    //Called when the activity is starting.
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plus);

        enamear=(EditText) findViewById(R.id.txtname);
        epricear=(EditText) findViewById(R.id.txtprice);
        eavailablear=(EditText) findViewById(R.id.txtavailable);
        eurlar=(EditText) findViewById(R.id.txturl);
        plusar=(Button) findViewById(R.id.b21ar);
        backar=(Button) findViewById(R.id.b23ar);

        backar.setOnClickListener(new View.OnClickListener() {
            @Override
            //when the button is clicked. the code in the OnClick method will run.
            public void onClick(View view) {
                Intent pressar=new Intent(ARPlus.this, ARMainActivity.class);
                startActivity(pressar);
            }
        });
        plusar.setOnClickListener(new View.OnClickListener() {
            @Override
            //when the button is clicked. the code in the OnClick method will run.
            public void onClick(View view) {
                insDatar(); //call the method
                Call();     //call the method
            }
        });
    }
    private void insDatar() {
        Map<String, Object> map = new HashMap<>();
        map.put("name", enamear.getText().toString());
        map.put("Price", epricear.getText().toString());
        map.put("Available", eavailablear.getText().toString());
        map.put("url", eurlar.getText().toString());

        FirebaseDatabase.getInstance().getReference().child("stationery").push()
                .setValue(map)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void unused) {
                        Toast.makeText(ARPlus.this, "Detail Added", Toast.LENGTH_SHORT).show();
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(Exception e) {
                        Toast.makeText(ARPlus.this, "something went wrong", Toast.LENGTH_SHORT).show();
                    }
                });
    }
    //method use to clear the data
    private void Call()
    {
        enamear.setText("");
        epricear.setText("");
        eavailablear.setText("");
        eurlar.setText("");
    }}