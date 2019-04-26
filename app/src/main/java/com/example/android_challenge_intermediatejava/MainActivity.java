package com.example.android_challenge_intermediatejava;

import android.content.Context;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Context context;
    DoubleClickHandler handler;
    ConstraintLayout parentLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        parentLayout = findViewById(R.id.parent_layout);
        context = this;
        handler = new DoubleClickHandler(findViewById(R.id.button_double_click), new DoubleClickHandler.doubleClickHandlerCallback() {
            @Override
            public void onSingleClick() {
                Toast.makeText(context, "Single Click", Toast.LENGTH_SHORT).show();
                parentLayout.setBackgroundColor(getResources().getColor(R.color.colorAccent));
            }
            @Override
            public void onDoubleClick() {
                Toast.makeText(context, "Double Click", Toast.LENGTH_LONG).show();
                parentLayout.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDark));

            }
        });
    }
}
