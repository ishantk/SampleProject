package com.auribises.sampleproject.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.auribises.sampleproject.R;
import com.auribises.sampleproject.adapter.UserAdapter;
import com.auribises.sampleproject.adapter.UserRecyclerAdapter;
import com.auribises.sampleproject.model.User;
import com.auribises.sampleproject.model.Util;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

import butterknife.ButterKnife;
import butterknife.InjectView;

// Retrieve the data from Server

public class HomeActivityTwo extends AppCompatActivity {


    RequestQueue requestQueue;
    StringRequest stringRequest;

    ArrayList<User> userList;

    @InjectView(R.id.recyclerView)
    RecyclerView recyclerView;

    UserRecyclerAdapter recyclerAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_two);

        ButterKnife.inject(this);

        requestQueue = Volley.newRequestQueue(this);

        retrieveFromServer();
    }

    void retrieveFromServer(){

        stringRequest = new StringRequest(Request.Method.GET, Util.RETRIEVE_ENDPOINT, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                try{

                    JSONObject jsonObject = new JSONObject(response);
                    int success = jsonObject.getInt("success");
                    String message = jsonObject.getString("message");
                    if(success == 1){
                        Toast.makeText(HomeActivityTwo.this,message,Toast.LENGTH_LONG).show();

                        JSONArray jsonArray = jsonObject.getJSONArray("users");

                        int id = 0;
                        String n="",e="",p="";

                        userList = new ArrayList<>();

                        for(int i=0;i<jsonArray.length();i++){
                            JSONObject jObj = jsonArray.getJSONObject(i);
                            id = jObj.getInt("uid"); // String Inputs are the column names of your table
                            n = jObj.getString("name");
                            p = jObj.getString("email");
                            e = jObj.getString("password");

                            User user = new User(id,n,e,p);
                            userList.add(user);
                        }


                        recyclerAdapter = new UserRecyclerAdapter(HomeActivityTwo.this,R.layout.listitem,userList);

                        LinearLayoutManager manager = new LinearLayoutManager(getApplicationContext());
                        //LinearLayoutManager manager1 = new LinearLayoutManager(getApplicationContext(),LinearLayoutManager.VERTICAL,false);

                        //GridLayoutManager gridLayoutManager = new GridLayoutManager(getApplicationContext(),2);

                        recyclerView.setLayoutManager(manager);
                        recyclerView.setAdapter(recyclerAdapter);


                    }else{
                        Toast.makeText(HomeActivityTwo.this,message,Toast.LENGTH_LONG).show();
                    }

                }catch (Exception e){
                    e.printStackTrace();
                    Toast.makeText(HomeActivityTwo.this,"Some Exception: "+e,Toast.LENGTH_LONG).show();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
                Toast.makeText(HomeActivityTwo.this,"Some VolleyError: "+error,Toast.LENGTH_LONG).show();
            }
        });

        requestQueue.add(stringRequest);

    }
}
