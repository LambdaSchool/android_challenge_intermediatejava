package com.example.doubleclick;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

public class DoubleClickView extends View implements DoubleClickInterface {
	DoubleClickHandler doubleClickHandler = new DoubleClickHandler();
	
	public DoubleClickView(Context context) {
		super(context);
	}
	
	public DoubleClickView(Context context, @Nullable AttributeSet attrs) {
		super(context, attrs);
	}
	
	public DoubleClickView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);
	}
	
	
	@Override
	public boolean performClick() {
		if(doubleClickHandler.performClick(this) == true) {
			return super.performClick();
		}
		return false;
	}
	
	@Override
	public void setOnDoubleClickListener(DoubleClickListener doubleClickListener) {
	   doubleClickHandler.setOnDoubleClickListener(doubleClickListener);
	}
}
