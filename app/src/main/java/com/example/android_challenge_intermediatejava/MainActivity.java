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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context = this;

        new DoubleClickHandler(findViewById(R.id.button_double_click),context, new DoubleClickHandler.doubleClickHandlerCallback() {
            @Override
            public void onSingleClick() {
                Toast.makeText(context, "Single Click", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onDoubleClick() {

                Toast.makeText(context, "Double Click", Toast.LENGTH_LONG).show();
            }
        });



    }
}
