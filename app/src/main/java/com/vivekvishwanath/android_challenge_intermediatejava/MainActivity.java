package com.vivekvishwanath.android_challenge_intermediatejava;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    Context context;
    DoubleClickView view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context = this;

        view = findViewById(R.id.button);

    }

    @Override
    protected void onResume() {
        super.onResume();
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                view.setOnDoubleClickListener(new DoubleClickListener() {
                    @Override
                    public void onDoubleClick(View v) {
                        Intent intent = new Intent(context, TestActivity.class);
                        startActivity(intent);
                    }
                });

                view.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(context, Test2Activity.class);
                        startActivity(intent);
                    }
                });
            }
        });
    }
}
