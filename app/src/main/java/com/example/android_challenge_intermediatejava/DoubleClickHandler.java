package com.example.android_challenge_intermediatejava;

import android.app.Activity;
import android.view.View;

import java.util.concurrent.atomic.AtomicBoolean;

public class DoubleClickHandler implements DoubleClickInterface {

    private OnDoubleClickListener listener;
    private View view;

    @Override
    public void setOnClickListener() {
        view.setOnClickListener(listener);
    }

    interface doubleClickHandlerCallback{
        void onSingleClick();
        void onDoubleClick();
    }

    public DoubleClickHandler(final View view, final doubleClickHandlerCallback callback) {
        this.view = view;
        listener = new OnDoubleClickListener() {
            int clickCounter = 0;
            @Override
            public void singleClick() {
                callback.onSingleClick();
            }

            @Override
            public void doubleClick() {
                callback.onDoubleClick();
            }

            @Override
            public void onClick(View v) {
                clickCounter++;
                final AtomicBoolean isSecondClick = new AtomicBoolean();
                switch (clickCounter){
                case 1:
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            try {
                                isSecondClick.set(true);
                                Thread.sleep(300);
                                isSecondClick.set(false);
                                if (clickCounter == 1) {
                                    ((Activity) view.getContext()).runOnUiThread(new Runnable() {
                                        @Override
                                        public void run() {
                                            singleClick();
                                            clickCounter = 0;
                                        }
                                    });
                                }
                            } catch (InterruptedException e) {
                                            e.printStackTrace();
                                        }
                                    }
                                }).start();
                break;
                case 2:
                    ((Activity)view.getContext()).runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            doubleClick();
                            clickCounter = 0;
                        }
                    });
                break;
                }
            }
        };
        this.setOnClickListener();
    }
}
