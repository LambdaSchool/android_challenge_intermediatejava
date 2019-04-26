package com.jakeesveld.android_sprint_intermediatejava;

import android.content.Context;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Context context;
    ConstraintLayout container;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context = this;

        new DoubleClickHandler(findViewById(R.id.button_double_click), new DoubleClickHandler.doubleClickHandlerCallback() {
            @Override
            public void onSingleClick() {
                Toast.makeText(context, "Single Click", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onDoubleClick() {
                Toast.makeText(context, "Double Click", Toast.LENGTH_LONG).show();
            }
        });



        DoubleClickView doubleClickView = new DoubleClickView(context, new DoubleClickView.DoubleClickCallback() {
            @Override
            public void onSingleClick() {
                Toast.makeText(context, "Programatic Single Click", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onDoubleClick() {
                Toast.makeText(context, "Programatic Double Click", Toast.LENGTH_LONG).show();
            }
        });
        doubleClickView.setText("Programatic Button");
        container = findViewById(R.id.container);
        container.addView(doubleClickView);


    }
}
