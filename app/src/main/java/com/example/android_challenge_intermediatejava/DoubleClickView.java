package com.example.android_challenge_intermediatejava;

import android.content.Context;
import android.util.AttributeSet;


public class DoubleClickView extends android.support.v7.widget.AppCompatButton implements DoubleClickInterface {

    private DoubleClickHandler handler;
    Context context;

    @Override
    public void setOnClickListener() {
        handler.setOnClickListener();
    }
    public DoubleClickView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
    }

    public DoubleClickView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.context = context;
    }

}
