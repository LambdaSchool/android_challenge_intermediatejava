package com.jakeesveld.android_sprint_intermediatejava;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DoubleClickView doubleClickView = new DoubleClickView(this, new DoubleClickView.DoubleClickCallback() {
            @Override
            public void onSingleClick() {

            }

            @Override
            public void onDoubleClick() {

            }
        });
    }
}
