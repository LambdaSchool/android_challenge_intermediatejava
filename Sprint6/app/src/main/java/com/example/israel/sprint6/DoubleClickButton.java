package com.example.israel.sprint6;

import android.content.Context;
import android.support.v7.widget.AppCompatButton;
import android.view.View;

public class DoubleClickButton extends AppCompatButton implements DoubleClickInterface {

    public DoubleClickButton(Context context) {
        super(context);

        setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (doubleClickHandler != null) {
                    doubleClickHandler.click();
                }
            }
        });
    }

    private DoubleClickHandler doubleClickHandler;

    @Override
    public void SetOnDoubleClickListener(OnDoubleClickListener l) {
        doubleClickHandler = new DoubleClickHandler();
        doubleClickHandler.SetOnDoubleClickListener(l);
    }


}
