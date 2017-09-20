package com.auribises.sampleproject.adapter;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.auribises.sampleproject.R;
import com.auribises.sampleproject.model.User;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ishantkumar on 20/09/17.
 */

public class UserAdapter extends ArrayAdapter<User>{

    Context context;
    int resource;
    ArrayList<User> list;

    public UserAdapter(Context context, int resource, ArrayList<User> objects) {
        super(context, resource, objects);

        this.context = context;
        this.resource = resource;
        list = objects;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = null;

        view = LayoutInflater.from(context).inflate(resource,parent,false);
        TextView txtName = (TextView)view.findViewById(R.id.textViewName);
        TextView txtEmail = (TextView)view.findViewById(R.id.textViewEmail);

        User user = list.get(position);

        txtName.setText(user.getName());
        txtEmail.setText(user.getEmail());

        return  view;
    }
}
