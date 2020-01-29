package com.example.wastemanagement;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.RetryPolicy;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class loginActivity extends AppCompatActivity {


    private String url = "http://172.20.10.7:8000/user/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Button login_button = findViewById(R.id.login_button);
        Button signup_button = findViewById(R.id.sign_up);

        login_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
            }
        });

        signup_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                JsonArrayRequest jsonObjectRequest = new JsonArrayRequest(Request.Method.GET, url, null,
                        new Response.Listener<JSONArray>() {
                            @Override
                            public void onResponse(JSONArray response) {
                                Log.d("respone", "onResponse: here1");
                                try {
                                    Log.d("after json", "onResponse: ");
                                    JSONObject object = response.getJSONObject(1);
                                    Log.d("after json", "onResponse: ");

                                    String text = object.getString("user");
                                    Toast.makeText(getApplicationContext(),text,Toast.LENGTH_LONG).show();

                                    Log.d("respone", "onResponse: here");
                                } catch (JSONException e) {
                                    e.printStackTrace();
                                    Log.d("error", "onResponse: here");
                                }



                            }

                        },
                        new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {

                                Log.d("respone", "onResponse: here2");


                            }
                        });
                RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
                requestQueue.add(jsonObjectRequest);
                jsonObjectRequest.setRetryPolicy(new RetryPolicy() {
                    @Override
                    public int getCurrentTimeout() {
                        return 50000;
                    }

                    @Override
                    public int getCurrentRetryCount() {
                        return 50000;
                    }

                    @Override
                    public void retry(VolleyError error) throws VolleyError {

                    }
                });
            }
        });


    }
}
