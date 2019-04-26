package com.lambdaschool.intermediatejavasprintchallenge;

import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.AppCompatButton;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.concurrent.atomic.AtomicBoolean;

/**
 * This will extend the "Button" view
 */
public class DoubleClickView extends AppCompatButton implements DoubleClickInterface {
    private Context context;

    public DoubleClickView(Context context) {
        super(context);
        this.context = context;
    }

    public DoubleClickView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
    }

    public DoubleClickView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.context = context;
    }

    @Override
    public void setOnClickListener(View view) {

    }

    private AtomicBoolean firstClick = new AtomicBoolean(true);

    @Override
    public boolean performClick() {
        //Toast.makeText(context, "performClick() intercepted!", Toast.LENGTH_SHORT).show();
        //TextView multiTextView =findViewById(R.id.multi_text_view);
        MainActivity.multiTextView.setText("PerformClick() Intercepted\n"+ MainActivity.multiTextView.getText());

        return super.performClick();
    }
}
