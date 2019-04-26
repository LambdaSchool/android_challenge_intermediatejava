package com.example.android_challenge_intermediatejava;

import android.view.View;

public abstract class DoubleClickHandler implements DoubleClickInterface {
long lastClickTime = 0;
private static final long DOUBLE_CLICK_TIME = 300;
DoubleClickListener listener;


    public abstract void onSingleClick(View v);
    public abstract void onDoubleClick(View v);
}
