package com.lambdaschool.intermediatejavasprintchallenge;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        DoubleClickView doubleClickView = findViewById(R.id.double_click_view);
        doubleClickView.setOnClickListener(new DoubleClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(),"DoubleClick button clicked",Toast.LENGTH_SHORT).show();
            }
        });

    }
}
