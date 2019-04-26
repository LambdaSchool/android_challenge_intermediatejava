package com.lambdaschool.intermediatejavasprintchallenge;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    static TextView multiTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        multiTextView = findViewById(R.id.multi_text_view);

        DoubleClickView doubleClickView = findViewById(R.id.double_click_view);
        doubleClickView.setOnClickListener(new DoubleClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(v.getContext(), "DoubleClick button clicked", Toast.LENGTH_SHORT).show();
                multiTextView.setText("View Clicked\n" + multiTextView.getText());
                DoubleClickHandler doubleClickHandler = new DoubleClickHandler(v);
                doubleClickHandler.setOnClickListener(v);
            }
        });
    }
}
