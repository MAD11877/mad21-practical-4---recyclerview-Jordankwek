package sg.edu.np.mad.madpractical;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Random;

public class SimpleAdapter extends RecyclerView.Adapter<SimpleViewHolder> {

    ArrayList<User> data ;

    public SimpleAdapter(ArrayList<User> input){
        data = input;
    }

    public SimpleViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View item = LayoutInflater.from(parent.getContext()).inflate(
                R.layout.simplerecyclerview,
                parent,
                false);
        return new SimpleViewHolder(item);
    }

    public void onBindViewHolder(SimpleViewHolder holder, int position){
        User listUsers = data.get(position);
        holder.txt.setText(listUsers.getName());
        holder.txt1.setText(listUsers.getDescription());
        if (listUsers.getName().endsWith("7"))
        {
            holder.bigimage.setImageResource(R.mipmap.ic_launcher_round);
            holder.bigimage.setVisibility(View.VISIBLE);
        }
        else{
            holder.bigimage.setVisibility(View.GONE);
        }

        holder.image.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                new AlertDialog.Builder(holder.image.getContext())
                        .setTitle("Profile")
                        .setMessage(listUsers.getName())
                        .setPositiveButton("View", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Bundle extras = new Bundle();
                                extras.putInt("id", listUsers.getId());
                                extras.putString("name", listUsers.getName());
                                extras.putString("description", listUsers.getDescription());
                                extras.putBoolean("value", listUsers.isFollowed());
                                Intent viewact = new Intent(holder.image.getContext(), MainActivity.class);
                                viewact.putExtras(extras);
                                holder.image.getContext().startActivity(viewact);
                            }
                        })
                        .setNegativeButton("Close", null)
                        .show();

            }
        });
    }

    public int getItemCount(){ return data.size();}

}
