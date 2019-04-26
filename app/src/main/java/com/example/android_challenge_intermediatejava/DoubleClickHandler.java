package com.example.android_challenge_intermediatejava;

import android.app.Activity;
import android.content.Context;
import android.view.View;

public class DoubleClickHandler implements DoubleClickInterface {

    DoubleClickListener listener;
    View view;

    interface doubleClickHandlerCallback{
        void onSingleClick();
        void onDoubleClick();
    }

    @Override
    public void setOnClickListener() {
        view.setOnClickListener(listener);
    }




    public DoubleClickHandler(View view, final Context context, final doubleClickHandlerCallback callback) {
        this.view = view;
        listener = new DoubleClickListener() {
//            int clickCounter = 0;
            boolean isclicked = false;
            boolean isDouble = false;

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
//            clickCounter++;
                isclicked =!isclicked;
                if(isclicked)

                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            Thread.sleep(500);
//                            clickCounter = 0;
                            isclicked = false;
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }).start();

                if(clickCounter == 1){
                    ((Activity)context).runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            singleClick();
                        }
                    });

                }
                if(clickCounter == 2){
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