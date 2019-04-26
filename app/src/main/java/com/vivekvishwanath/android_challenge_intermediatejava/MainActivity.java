package com.vivekvishwanath.android_challenge_intermediatejava;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context = this;

        final DoubleClickView view = findViewById(R.id.button);
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
            }
        });

    }
}
