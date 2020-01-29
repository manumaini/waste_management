package com.example.wastemanagement;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class splashActivity extends AppCompatActivity {
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        new Thread(new Runnable() {
            @Override
            public void run() {

                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    intent = new Intent(getApplicationContext(),loginActivity.class);
                    startActivity(intent);
                }


            }
        }).start();


    }

    @Override
    protected void onResume() {
        super.onResume();


        new Thread(new Runnable() {
            @Override
            public void run() {

                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    intent = new Intent(getApplicationContext(),loginActivity.class);
                    startActivity(intent);
                }


            }
        }).start();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}
