package com.example.wastemanagement;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.AuthFailureError;
import com.android.volley.ClientError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.RetryPolicy;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    private ArrayList<String> ind_name = new ArrayList<>();
    private ArrayList<String> need_list = new ArrayList<>();
    private ArrayList<Integer> ind_logo = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ind_name.add("Tata Industry");
        need_list.add("plastic waste , electronic waste");
        ind_logo.add(R.drawable.tata_logo);

        ind_name.add("Rajesh Exports");
        need_list.add("metal waste , electronic waste");
        ind_logo.add(R.drawable.rajesh_export);

        ind_name.add("Apex Precision");
        need_list.add("plastic waste , paper waste");
        ind_logo.add(R.drawable.apex);


        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        RecyclerViewAdapter recyclerViewAdapter = new RecyclerViewAdapter(ind_name,need_list,ind_logo,this);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(recyclerViewAdapter);










    }
}
