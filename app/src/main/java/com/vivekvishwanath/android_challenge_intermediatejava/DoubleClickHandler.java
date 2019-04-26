package com.vivekvishwanath.android_challenge_intermediatejava;


import android.view.View;

import java.util.concurrent.atomic.AtomicBoolean;

public class DoubleClickHandler implements DoubleClickInterface {

    private DoubleClickListener doubleClickListener;
    private View view;
    private AtomicBoolean firstClick;
    private AtomicBoolean waitingForSecondClick;

    public DoubleClickHandler (View view) {
        this.view = view;
        firstClick = new AtomicBoolean();
        waitingForSecondClick = new AtomicBoolean();
        firstClick.set(false);
        waitingForSecondClick.set(false);
    }

    @Override
    public void setOnDoubleClickListener(DoubleClickListener l) {
        this.doubleClickListener = l;
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    if (firstClick.get() && waitingForSecondClick.get()) {
                        doubleClickListener.onDoubleClick(handleDoubleClick());
                        return;
                    }
                }
            }
        }).start();

    }

    public View handleDoubleClick() {
        return this.view;
    }

    public AtomicBoolean getFirstClick() {
        return firstClick;
    }

    public void setFirstClick(boolean firstClick) {
        this.firstClick.set(firstClick);
    }

    public AtomicBoolean getWaitingForSecondClick() {
        return waitingForSecondClick;
    }

    public void setWaitingForSecondClick(boolean waitingForSecondClick) {
        this.waitingForSecondClick.set(waitingForSecondClick);
    }
}
