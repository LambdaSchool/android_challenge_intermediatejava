package com.example.israel.sprint6;

import android.content.Context;
import android.support.v7.widget.AppCompatButton;
import android.util.AttributeSet;
import android.view.View;

public class DoubleClickButton extends AppCompatButton implements DoubleClickInterface {

    public DoubleClickButton(Context context) {
        super(context);
    }

    public DoubleClickButton(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public DoubleClickButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    private DoubleClickHandler doubleClickHandler;

    @Override
    public void SetOnDoubleClickListener(OnDoubleClickListener l) {
        doubleClickHandler = new DoubleClickHandler();
        doubleClickHandler.SetOnDoubleClickListener(l);
    }

    @Override
    public boolean performClick() {
        if (doubleClickHandler != null) {
            doubleClickHandler.click(this);
        }

        return super.performClick();
    }
}
