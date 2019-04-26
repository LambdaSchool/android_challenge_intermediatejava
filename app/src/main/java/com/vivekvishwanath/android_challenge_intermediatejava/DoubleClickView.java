package com.vivekvishwanath.android_challenge_intermediatejava;

import android.content.Context;
import android.util.AttributeSet;

public class DoubleClickView extends android.support.v7.widget.AppCompatButton implements DoubleClickInterface

{
    private DoubleClickHandler doubleClickHandler;

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

        return super.performClick();
    }

    @Override
    public void setOnDoubleClickListener(DoubleClickListener listener) {
        doubleClickHandler.setOnDoubleClickListener(listener);
    }
}
