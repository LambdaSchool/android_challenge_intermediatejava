package com.example.israel.sprint6;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final CountdownView remainingTimeCountdownView = findViewById(R.id.countdown_view_remaining_time);
        final DoubleClickButton doubleClickButton = findViewById(R.id.double_click_button_test);
        doubleClickButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                remainingTimeCountdownView.startCountdown(doubleClickButton.getDoubleClickMaxTime());
            }
        });

        doubleClickButton.SetOnDoubleClickListener(new OnDoubleClickListener() {
            @Override
            public void onDoubleClick(View v) {
                Toast toast = Toast.makeText(MainActivity.this, "Double clicked!!!", Toast.LENGTH_SHORT);
                toast.show();
                remainingTimeCountdownView.cancelCountdown();
                remainingTimeCountdownView.setText("Double clicked!!");
            }
        });

        final TextView maxTimeTextView = findViewById(R.id.text_view_max_time);
        maxTimeTextView.setText("Current double click max time: " + doubleClickButton.getDoubleClickMaxTime() + "ms");

        final EditText maxTimeEditText = findViewById(R.id.edit_text_max_time);
        maxTimeEditText.setText(Integer.toString(doubleClickButton.getDoubleClickMaxTime()));

        Button maxTimeButton = findViewById(R.id.button_set_max_time);
        maxTimeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String newMaxTimeStr = maxTimeEditText.getText().toString();
                if (newMaxTimeStr.length() == 0) {
                    return;
                }

                doubleClickButton.setDoubleClickMaxTime(Integer.parseInt(newMaxTimeStr));
                maxTimeTextView.setText("Current double click max time: " + newMaxTimeStr + "ms");
            }
        });
    }
}
