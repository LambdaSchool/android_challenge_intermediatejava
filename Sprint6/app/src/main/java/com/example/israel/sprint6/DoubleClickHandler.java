package com.example.israel.sprint6;

import android.view.View;

import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.ReentrantLock;

public class DoubleClickHandler implements DoubleClickInterface {

    // TODO make this settable
    public static final long DOUBLE_CLICK_INTERVAL = 500;

    private OnDoubleClickListener onDoubleClickListener;
    private long lastClickTime;
    private AtomicBoolean isDoubleClick = new AtomicBoolean(false);

    public void click(View v) {
        if (onDoubleClickListener == null) {
            return;
        }

        handleDoubleClick(v);

    }

    @Override
    public void SetOnDoubleClickListener(OnDoubleClickListener l) {
        // reset // even if the clock was reset to 0, it will still work
        lastClickTime = -DOUBLE_CLICK_INTERVAL;

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

//    private void handleDoubleClick(View v) {
//        long currentTime = System.currentTimeMillis();
//        long elapsedTimeSinceLastClick = currentTime - lastClickTime;
//        if (elapsedTimeSinceLastClick > DOUBLE_CLICK_INTERVAL) {
//            lastClickTime = currentTime;
//            return;
//        }
//
//        onDoubleClickListener.onDoubleClick(v);
//        lastClickTime = -DOUBLE_CLICK_INTERVAL; // reset
//    }

}
