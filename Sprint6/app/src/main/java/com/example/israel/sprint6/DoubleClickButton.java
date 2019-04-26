package com.example.israel.sprint6;

import android.content.Context;
import android.support.v7.widget.AppCompatButton;
import android.util.AttributeSet;
import android.view.View;

public class DoubleClickButton extends AppCompatButton implements DoubleClickInterface {

    public DoubleClickButton(Context context) {
        super(context);

        init();
    }

    public DoubleClickButton(Context context, AttributeSet attrs) {
        super(context, attrs);

        init();
    }

    public DoubleClickButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        init();
    }

    private DoubleClickHandler doubleClickHandler;

    private void init() {
        setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (doubleClickHandler != null) {
                    doubleClickHandler.click(v);
                }
            }
        });
    }

    @Override
    public void SetOnDoubleClickListener(OnDoubleClickListener l) {
        doubleClickHandler = new DoubleClickHandler();
        doubleClickHandler.SetOnDoubleClickListener(l);
    }

    // @TODO implement
    @Override
    public boolean performClick() {
        return super.performClick();
    }
}
