package com.vivekvishwanath.android_challenge_intermediatejava;


import android.view.View;

import java.util.concurrent.Semaphore;

public class DoubleClickHandler implements DoubleClickInterface {

    private DoubleClickListener doubleClickListener;
    private View view;
    private Semaphore lock;

    public DoubleClickHandler (View view) {
        this.view = view;
        lock = new Semaphore(2);
    }

    @Override
    public void setOnDoubleClickListener(DoubleClickListener l) {
        this.doubleClickListener = l;
        doubleClickListener.onDoubleClick(checkForDoubleClick());
    }

    public View checkForDoubleClick() {
        try {
            lock.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return this.view;
    }

    public void requestPermit() {
        try {
            lock.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}
