package com.example.doubleclick;

import android.util.Log;
import android.view.View;

import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicBoolean;

public class DoubleClickHandler implements DoubleClickInterface {
	private View view;
	AtomicBoolean isSingleClick;
	AtomicBoolean isWaiting;
	private Semaphore clickLock;
	public long timeBetweenClicks;
	int numOfClicks;
	float startTime, currentTime;
	public static DoubleClickListener doubleClickListener;
	
	public DoubleClickHandler() {
		clickLock = new Semaphore(1);
		isSingleClick = new AtomicBoolean();
		isWaiting = new AtomicBoolean();
		timeBetweenClicks = 500; //in milliseconds
		numOfClicks = 0;
	}
	
	public boolean performClick(View v) {
		doubleClickListener.onDoubleClick(v);
		return false;
	}
	
	
	@Override
	public void setOnDoubleClickListener(DoubleClickListener doubleClickListener) {
		this.doubleClickListener = doubleClickListener;
	}
}
