package com.example.israel.sprint6;

import android.view.View;

import java.util.concurrent.atomic.AtomicBoolean;

public class DoubleClickHandler implements DoubleClickInterface {

    public static final long DOUBLE_CLICK_INTERVAL = 500;

    private OnDoubleClickListener onDoubleClickListener;
    private AtomicBoolean isDoubleClick = new AtomicBoolean(false);

    public void click(View v) {
        if (onDoubleClickListener == null) {
            return;
        }

        handleDoubleClick(v);

    }

    @Override
    public void SetOnDoubleClickListener(OnDoubleClickListener l) {
        onDoubleClickListener = l;
    }

    private void handleDoubleClick(View v) {

        if (isDoubleClick.get()) {
            if (isDoubleClick.get()) {
                onDoubleClickListener.onDoubleClick(v);
            }

            isDoubleClick = new AtomicBoolean(false); // disregard the old thread
        } else {
            // spin up a new thread with its own isDoubleClick
            final AtomicBoolean isDoubleClickThread = new AtomicBoolean(true);
            isDoubleClick = isDoubleClickThread;
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(DOUBLE_CLICK_INTERVAL);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    // time is up

                    isDoubleClickThread.set(false);
                }
            }).start();
        }


    }

}
