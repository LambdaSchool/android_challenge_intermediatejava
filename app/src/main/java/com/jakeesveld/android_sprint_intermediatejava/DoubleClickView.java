package com.jakeesveld.android_sprint_intermediatejava;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;

public class DoubleClickView extends android.support.v7.widget.AppCompatButton implements DoubleClickInterface {



    public DoubleClickView(Context context) {
        super(context);
    }

    public DoubleClickView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public DoubleClickView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    interface DoubleClickListenerCallback{


    }

    @Override
    public void setOnClickListener(View view) {
        DoubleClickHandler handler = new DoubleClickHandler() {
            @Override
            void onSingleClick() {

            }

            @Override
            void onDoubleClick() {

            }
        };
        handler.setOnClickListener(view);
    }
}
