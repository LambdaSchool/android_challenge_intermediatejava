package com.jakeesveld.android_sprint_intermediatejava;


import android.app.Activity;
import android.view.View;

import java.util.concurrent.atomic.AtomicBoolean;

public class DoubleClickHandler implements DoubleClickInterface {

    DoubleClickListener listener;
    View view;

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
        listener = new DoubleClickListener() {
            int i = 0;
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
                i++;
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            AtomicBoolean waiting = new AtomicBoolean();
                            if(i == 1){
                                waiting.set(true);
                                Thread.sleep(500);
                                waiting.set(false);
                                if(i == 1) {
                                    ((Activity) view.getContext()).runOnUiThread(new Runnable() {
                                        @Override
                                        public void run() {
                                            singleClick();
                                            i = 0;
                                        }
                                    });
                                }

                            }
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }).start();

                if(i == 2){
                    ((Activity)view.getContext()).runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            doubleClick();
                            i = 0;
                        }
                    });

                }
            }
        };
        this.setOnClickListener();
    }





}
