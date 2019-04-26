package com.example.israel.sprint6;

import android.content.Context;
import android.os.CountDownTimer;
import android.support.v7.widget.AppCompatTextView;
import android.util.AttributeSet;

public class CountdownView extends AppCompatTextView {
    public CountdownView(Context context) {
        super(context);
    }

    public CountdownView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CountdownView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    private CountDownTimer countDownTimer;

    public void startCountdown(int timeMillis) {
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }

        countDownTimer = new CountDownTimer(timeMillis, 100) {
            @Override
            public void onTick(long millisUntilFinished) {
                setText("Remaining time: " + millisUntilFinished);
            }

            @Override
            public void onFinish() {
                setText("Time is up");
            }
        };
        countDownTimer.start();
    }

    public void cancelCountdown() {
        countDownTimer.cancel();
    }


}
