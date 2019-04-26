package com.jakeesveld.android_sprint_intermediatejava;

import android.content.Context;
import android.util.AttributeSet;


public class DoubleClickView extends android.support.v7.widget.AppCompatButton implements DoubleClickInterface {

    private DoubleClickHandler handler;
    Context context;

        @Override
    public void setOnClickListener() {
            handler.setOnClickListener();
    }


    interface DoubleClickCallback{
        void onSingleClick();
        void onDoubleClick();
    }

    public DoubleClickView(Context context, final DoubleClickCallback callback) {
        super(context);
        this.context = context;
        this.handler = new DoubleClickHandler(this, new DoubleClickHandler.doubleClickHandlerCallback() {
            @Override
            public void onSingleClick() {
                callback.onSingleClick();
            }

            @Override
            public void onDoubleClick() {
                callback.onDoubleClick();
            }
        });
        this.setOnClickListener();
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
