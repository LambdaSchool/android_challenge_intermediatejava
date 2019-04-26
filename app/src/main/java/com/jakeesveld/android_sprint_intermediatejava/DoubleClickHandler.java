package com.jakeesveld.android_sprint_intermediatejava;


import android.app.Activity;
import android.content.Context;
import android.view.View;

public class DoubleClickHandler implements DoubleClickInterface {

    DoubleClickListener listener;
    View view;


    public DoubleClickListener getListener() {
        return listener;
    }

    @Override
    public void setOnClickListener() {
        view.setOnClickListener(listener);
    }


    interface doubleClickHandlerCallback{
        void onSingleClick();
        void onDoubleClick();
    }

    public DoubleClickHandler(View view, final Context context, final doubleClickHandlerCallback callback) {
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
                            Thread.sleep(500);
                            i = 0;
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }).start();

                if(i == 1){
                    ((Activity)context).runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            singleClick();
                        }
                    });

                }
                if(i == 2){
                    ((Activity)context).runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            doubleClick();
                        }
                    });

                }
            }
        };
        this.setOnClickListener();
    }





}
