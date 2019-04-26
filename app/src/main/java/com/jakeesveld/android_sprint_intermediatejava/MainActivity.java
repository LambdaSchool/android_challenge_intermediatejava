package com.jakeesveld.android_sprint_intermediatejava;

import android.content.Context;
import android.content.Intent;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Context context;
    LinearLayout container;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context = this;

        new DoubleClickHandler(findViewById(R.id.button_double_click), new DoubleClickHandler.doubleClickHandlerCallback() {
            @Override
            public void onSingleClick() {
                Toast.makeText(context, "Single Click", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(context, SingleClick.class));
            }

            @Override
            public void onDoubleClick() {
                Toast.makeText(context, "Double Click", Toast.LENGTH_LONG).show();
                startActivity(new Intent(context, DoubleClick.class));
            }
        });



        DoubleClickView doubleClickView = new DoubleClickView(context, new DoubleClickView.DoubleClickCallback() {
            @Override
            public void onSingleClick() {
                Toast.makeText(context, "Programatic Single Click", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(context, SingleClick.class));
            }

            @Override
            public void onDoubleClick() {
                Toast.makeText(context, "Programatic Double Click", Toast.LENGTH_LONG).show();
                startActivity(new Intent(context, DoubleClick.class));
            }
        });
        doubleClickView.setText("Programatic Button");
        doubleClickView.setGravity(Gravity.CENTER);
        container = findViewById(R.id.container);
        container.addView(doubleClickView);


    }
}
