package com.example.doubleclick;

import android.content.Context;
import android.util.AttributeSet;
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
	
	@Override
	public void setOnDoubleClickListener() {
	
	}
}
