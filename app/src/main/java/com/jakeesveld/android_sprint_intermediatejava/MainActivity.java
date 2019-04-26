package com.jakeesveld.android_sprint_intermediatejava;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    DoubleClickView xmlDoubleClickView;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context = this;

        xmlDoubleClickView = findViewById(R.id.button_double_click);
        DoubleClickHandler handler = new DoubleClickHandler(xmlDoubleClickView, this, new DoubleClickHandler.doubleClickHandlerCallback() {
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
