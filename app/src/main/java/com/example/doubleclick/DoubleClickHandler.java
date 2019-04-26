package com.example.doubleclick;

import android.view.View;

import java.util.concurrent.atomic.AtomicBoolean;

public class DoubleClickHandler implements DoubleClickInterface{
	private View view;
	AtomicBoolean isSingleClick;
	AtomicBoolean isWaiting;
	long timeBetweenClicks;
	int numOfClicks;
	public static DoubleClickListener doubleClickListener;
	
	public DoubleClickHandler(){
		
		//this.view = view;
		isSingleClick.set(false);
		isWaiting.set(false);
		timeBetweenClicks = 500; //in milliseconds
		numOfClicks = 0;
	}
	
	@Override
	public void setOnDoubleClickListener(View view) {
		doubleClickListener = new DoubleClickListener() {
			@Override
			public void onDoubleClick(View view) {
			
			}
		};
	}
	
	public void performClick() {
		if (!isWaiting.get()) {
			isWaiting.set(true);
			
			numOfClicks++;
			
			numOfClicks = 0;
			
			isWaiting.set(false);
		}
	}
	
	
	
	private void startWait() {
	}
	
}
