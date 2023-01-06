package com.example.miniproject;
import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.FirebaseDatabase;
import com.orhanobut.dialogplus.DialogPlus;
import com.orhanobut.dialogplus.ViewHolder;
import java.util.HashMap;
import java.util.Map;
import de.hdodenhof.circleimageview.CircleImageView;
public class to extends FirebaseRecyclerAdapter<ARMainModel,to.myViewHolder> {
    /**
     * Initialize a {@link RecyclerView.Adapter} that listens to a Firebase query. See
     * {@link FirebaseRecyclerOptions} for configuration options.
     *
     * @param options
     */
    public to(@NonNull FirebaseRecyclerOptions<ARMainModel> options) {
        super(options);
    }
    @Override
    // to update the ViewHolder contents
    protected void onBindViewHolder(@NonNull myViewHolder holder, @SuppressLint("RecyclerView") final int position, @NonNull ARMainModel model) {
        holder.inamear.setText(model.getName());
        holder.ipricear.setText(model.getPrice());
        holder.iavailablear.setText(model.getAvailable());
        Glide.with(holder.iimageViewar.getContext())
                .load(model.getUrl())
                .placeholder(com.firebase.ui.database.R.drawable.notify_panel_notification_icon_bg)
                .circleCrop()
                .error(com.firebase.ui.database.R.drawable.notify_panel_notification_icon_bg)
                .into(holder.iimageViewar);
        holder.bchangear.setOnClickListener(new View.OnClickListener() {
            @Override
            //when the button is clicked. the code in the OnClick method will run.
            public void onClick(View v) {

                final DialogPlus dialogPlus=DialogPlus.newDialog(holder.iimageViewar.getContext())
                        .setContentHolder(new ViewHolder(R.layout.popup))
                        .setExpanded(true,1200)
                        .create();

                View view=dialogPlus.getHolderView();
                EditText name=view.findViewById(R.id.txtname);
                EditText price=view.findViewById(R.id.txtprice);
                EditText available=view.findViewById(R.id.txtavailable);
                EditText url=view.findViewById(R.id.txturl);
                Button update=view.findViewById(R.id.b21ar);

                name.setText(model.getName());
                price.setText(model.getPrice());
                available.setText(model.getAvailable());
                url.setText(model.getUrl());

                dialogPlus.show();

                update.setOnClickListener(new View.OnClickListener() {
                    @Override
                    //when the button is clicked. the code in the OnClick method will run.
                    public void onClick(View v) {
                        Map<String, Object> map= new HashMap<>();
                        map.put("name", name.getText().toString());
                        map.put("Price",price.getText().toString());
                        map.put("Available",available.getText().toString());
                        map.put("url",url.getText().toString());

                        FirebaseDatabase.getInstance().getReference().child("stationery")
                                .child(getRef(position).getKey()).updateChildren(map)
                                .addOnSuccessListener(new OnSuccessListener<Void>() {

                                    @Override
                                    //when the action run success
                                    public void onSuccess(Void unused) {
                                        Toast.makeText(holder.inamear.getContext(), "Data Is Updated", Toast.LENGTH_SHORT).show();
                                        dialogPlus.dismiss();
                                    }
                                })
                                .addOnFailureListener(new OnFailureListener() {
                                    @Override
                                    //ehn the action fail
                                    public void onFailure(Exception e) {
                                        Toast.makeText(holder.inamear.getContext(), "something went wrong", Toast.LENGTH_SHORT).show();
                                        dialogPlus.dismiss();
                                    }
                                });
                    }
                });
            }
        });
        holder.bremovear.setOnClickListener(new View.OnClickListener() {
            @Override
            //when the button is clicked. the code in the OnClick method will run.
            public void onClick(View v) {
                AlertDialog.Builder builder=new AlertDialog.Builder(holder.inamear.getContext());
                builder.setTitle("Are you sure?");

                builder.setPositiveButton("Delete", new DialogInterface.OnClickListener() {
                    @Override
                    //when the button is clicked. the code in the OnClick method will run.
                    public void onClick(DialogInterface dialogInterface, int i) {
                        FirebaseDatabase.getInstance().getReference().child("stationery")
                                .child(getRef(position).getKey()).removeValue();
                    }
                });
                builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    //when the button is clicked. the code in the OnClick method will run.
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(holder.inamear.getContext(), "Cancelled", Toast.LENGTH_SHORT).show();
                    }
                });
                builder.show();
            }
        });
    }
    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.stationery,parent,false);
        return new myViewHolder(view);
    }
    class myViewHolder extends RecyclerView.ViewHolder{

        CircleImageView iimageViewar;
        TextView inamear, ipricear, iavailablear;
        Button bchangear, bremovear;

        public myViewHolder(@NonNull View itemView) {
            super(itemView);

            iimageViewar=(CircleImageView) itemView.findViewById(R.id.iimg1);
            inamear =(TextView) itemView.findViewById(R.id.itemname);
            ipricear =(TextView) itemView.findViewById(R.id.itemprice);
            iavailablear=(TextView) itemView.findViewById(R.id.itemavailable);
            bchangear=(Button) itemView.findViewById(R.id.b19ar);
            bremovear=(Button) itemView.findViewById(R.id.b20ar);
        }}}
