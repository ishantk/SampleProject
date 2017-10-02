package com.auribises.sampleproject.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.auribises.sampleproject.R;
import com.auribises.sampleproject.model.User;

import java.util.ArrayList;

/**
 * Created by ishantkumar on 02/10/17.
 */

public class UserRecyclerAdapter extends RecyclerView.Adapter<UserRecyclerAdapter.ViewHolder> {


    Context context;
    int resource;
    ArrayList<User> list;

    public UserRecyclerAdapter(Context context, int resource, ArrayList<User> objects) {
        this.context = context;
        this.resource = resource;
        list = objects;
    }

    // Create a ViewHolder Object
    @Override
    public UserRecyclerAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(resource,parent,false);

        ViewHolder holder = new ViewHolder(view);

        return holder;
    }

    // Set the data on Views
    @Override
    public void onBindViewHolder(UserRecyclerAdapter.ViewHolder holder, int position) {

        User user = list.get(position);
        holder.txtName.setText(user.getName());
        holder.txtEmail.setText(user.getEmail());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    // Used to Initialize Views of your list item
    class ViewHolder extends RecyclerView.ViewHolder{

        TextView txtName;
        TextView txtEmail;

        public ViewHolder(View itemView) {
            super(itemView);
            txtName = itemView.findViewById(R.id.textViewName);
            txtEmail = itemView.findViewById(R.id.textViewEmail);
        }
    }
}
