package com.example.miniproject;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.SearchView;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.FirebaseDatabase;
public class ARMainActivity extends AppCompatActivity {

    FloatingActionButton FABtnar;
    RecyclerView rrecyclerViewar;
    to to;

    @Override
    //Called when the activity is starting.
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rrecyclerViewar=(RecyclerView) findViewById(R.id.rv);
        rrecyclerViewar.setLayoutManager(new LinearLayoutManager(this));

        FirebaseRecyclerOptions<ARMainModel> options =
                new FirebaseRecyclerOptions.Builder<ARMainModel>()
                        .setQuery(FirebaseDatabase.getInstance().getReference().child("stationery"), ARMainModel.class)
                        .build();

        to = new to(options);
        rrecyclerViewar.setAdapter(to);

        FABtnar=(FloatingActionButton) findViewById(R.id.FABtnar);
        FABtnar.setOnClickListener(new View.OnClickListener() {
            @Override
            //when the button is clicked. the code in the OnClick method will run.
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), ARPlus.class));
            }
        });
    }
    @Override
    //use when the activity becomes visible for the user and is called after onCreate.
    protected void onStart() {
        super.onStart();
        to.startListening();
    }
    @Override
    //use for the activity is not visible to the user.
    protected void onStop() {
        super.onStop();
        to.startListening();
    }
    @Override
    //Android runtime when it need to create the option menu
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.fint,menu);
        MenuItem item=menu.findItem(R.id.listfind);
        SearchView searchView=(SearchView)item.getActionView();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            //Called when the user submits the query.
            public boolean onQueryTextSubmit(String query) {
                textFind(query);
                return false;
            }
            @Override
            //Called when the user submits the query.
            public boolean onQueryTextChange(String query) {
                textFind(query);
                return false;
            }
        });
        return super.onCreateOptionsMenu(menu);
    }       //to search for something like the database
    private void textFind(String str){
        FirebaseRecyclerOptions<ARMainModel> options =
                new FirebaseRecyclerOptions.Builder<ARMainModel>()
                        .setQuery(FirebaseDatabase.getInstance().getReference().child("stationery").orderByChild("name").startAt(str).endAt(str+"~"), ARMainModel.class)
                        .build();
        to = new to(options);
        to.startListening();
        rrecyclerViewar.setAdapter(to);
    }}