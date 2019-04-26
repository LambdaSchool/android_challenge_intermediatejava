package com.example.israel.sprint6;

import android.view.View;

import java.util.concurrent.atomic.AtomicBoolean;

public class DoubleClickHandler implements DoubleClickInterface {

    public static final int DOUBLE_CLICK_MAX_TIME_DEFAULT = 500;

    private OnDoubleClickListener onDoubleClickListener;
    private AtomicBoolean isDoubleClick = new AtomicBoolean(false);
    private int doubleClickMaxTime = DOUBLE_CLICK_MAX_TIME_DEFAULT;

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

    public int getDoubleClickMaxTime() {
        return this.doubleClickMaxTime;
    }

    public void setDoubleClickMaxTime(int doubleClickMaxTime) {
        this.doubleClickMaxTime = doubleClickMaxTime;
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
            final int doubleClickMaxTimeThread = doubleClickMaxTime;
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(doubleClickMaxTimeThread);
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
