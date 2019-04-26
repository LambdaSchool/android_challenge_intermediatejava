package com.jakeesveld.android_sprint_intermediatejava;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;

public class DoubleClickView extends android.support.v7.widget.AppCompatButton implements DoubleClickInterface {

    private DoubleClickHandler handler;

    interface DoubleClickCallback{
        void onSingleClick();
        void onDoubleClick();
    }

    public DoubleClickView(Context context, final DoubleClickCallback callback) {
        super(context);
        this.handler = new DoubleClickHandler(context, new DoubleClickHandler.doubleClickHandlerCallback() {
            @Override
            public void onSingleClick() {
                callback.onSingleClick();
            }

            @Override
            public void onDoubleClick() {
                callback.onDoubleClick();
            }
        });

    }

    public DoubleClickView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public DoubleClickView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public void setOnClickListener(View view) {
        view.setOnClickListener(handler.getListener());
    }





}
