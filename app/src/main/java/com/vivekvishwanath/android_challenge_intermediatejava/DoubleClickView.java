package com.vivekvishwanath.android_challenge_intermediatejava;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import java.util.concurrent.atomic.AtomicBoolean;

public class DoubleClickView extends android.support.v7.widget.AppCompatButton implements DoubleClickInterface {
    private DoubleClickHandler doubleClickHandler;

    AtomicBoolean performSingleClick = new AtomicBoolean(false);

    public DoubleClickView(Context context) {
        super(context);
        doubleClickHandler = new DoubleClickHandler(this);
    }

    public DoubleClickView(Context context, AttributeSet attrs) {
        super(context, attrs);
        doubleClickHandler = new DoubleClickHandler(this);
    }

    public DoubleClickView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        doubleClickHandler = new DoubleClickHandler(this);
    }

    @Override
    public boolean performClick() {

        if (performSingleClick.get()) {
            ((Activity)getContext()).runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    DoubleClickView.super.performClick();
                }
            });
        }  else {
            performAClick();
        }
        return false;
    }

    @Override
    public void setOnDoubleClickListener(DoubleClickListener listener) {
        doubleClickHandler.setOnDoubleClickListener(listener);
    }

     public void performAClick() {
         new Thread(new Runnable() {
             @Override
             public void run() {
                 if (doubleClickHandler.getFirstClick()) {
                     if (doubleClickHandler.getWaitingForSecondClick()) {
                         doubleClickHandler.setWaitingForSecondClick(false);
                         doubleClickHandler.setSecondClick(true);
                     }
                 } else {
                     doubleClickHandler.setFirstClick(true);
                     doubleClickHandler.setWaitingForSecondClick(true);
                 }
                 try {
                     Thread.sleep(500);
                 } catch (InterruptedException e) {
                     e.printStackTrace();
                 }
                 if (doubleClickHandler.getFirstClick() && doubleClickHandler.getWaitingForSecondClick()) {
                     performSingleClick.set(true);
                     performClick();
                     performSingleClick.set(false);
                 } else {
                     performSingleClick.set(false);
                 }
                 doubleClickHandler.setWaitingForSecondClick(false);
                 doubleClickHandler.setSecondClick(false);
                 doubleClickHandler.setFirstClick(false);
             }
         }).start();
    }
}