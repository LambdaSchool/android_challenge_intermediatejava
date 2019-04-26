package com.lambdaschool.intermediatejavasprintchallenge;

import android.content.Context;
import android.support.v7.widget.AppCompatButton;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;

/**
 * This will extend the "Button" view
 */
public class DoubleClickView extends AppCompatButton implements DoubleClickInterface {

    public DoubleClickView(Context context) {
        super(context);
    }

    public DoubleClickView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public DoubleClickView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public void setOnClickListener(View view) {

    }
}
