package com.jakeesveld.android_sprint_intermediatejava;

import android.view.View;

public abstract class DoubleClickHandler implements DoubleClickInterface {


    DoubleClickListener clickListener = new DoubleClickListener() {
        int i = 0;

        @Override
        public void singleClick() {
            onSingleClick();
        }

        @Override
        public void doubleClick() {
            onDoubleClick();
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
                singleClick();
            }else if (i == 2){
                doubleClick();
            }
        }
    };

    abstract void onSingleClick();
    abstract void onDoubleClick();

    @Override
    public void setOnClickListener(View view) {
        view.setOnClickListener(clickListener);
    }
}
