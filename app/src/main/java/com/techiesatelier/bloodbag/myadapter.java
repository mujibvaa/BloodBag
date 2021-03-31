package com.techiesatelier.bloodbag;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

public class myadapter extends FirebaseRecyclerAdapter<User, myadapter.myviewholder>
{

    public myadapter(@NonNull FirebaseRecyclerOptions<User> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull myviewholder holder, int position, @NonNull final User model) {
      holder.nametext.setText(model.getName());
      holder.ratetext.setText(model.getGroup());
      holder.detailstext.setText(model.getCity());
      holder.phonetext.setText(model.getPhone());

    }

    @NonNull
    @Override
    public myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.singlerowdesign,parent,false);
        return new myviewholder(view);
    }

    public class myviewholder extends RecyclerView.ViewHolder
    {
        ImageView img1;
        TextView nametext,ratetext,detailstext,phonetext;

        public myviewholder(@NonNull View itemView) {
            super(itemView);


            nametext=itemView.findViewById(R.id.nametext);
            ratetext=itemView.findViewById(R.id.coursetext);
            detailstext=itemView.findViewById(R.id.emailtext);
            phonetext=itemView.findViewById(R.id.phonetext);
        }
    }

}
