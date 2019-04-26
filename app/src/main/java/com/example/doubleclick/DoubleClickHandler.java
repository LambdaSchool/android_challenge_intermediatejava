package com.example.doubleclick;

import android.app.Activity;
import android.util.Log;
import android.view.View;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

public class DoubleClickHandler implements DoubleClickInterface {
	private View view;
	Timer timer;
	TimerTask timerTask;
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
	
	public boolean performClick(final View v) {
		if(!isWaiting.get()) {
			
			isWaiting.set(true);
			
			numOfClicks++;
			final Activity a = (Activity)v.getContext();
			
			final ScheduledThreadPoolExecutor executor = new ScheduledThreadPoolExecutor(1);
			executor.schedule(new Runnable() {
				@Override
				public void run() {
					a.runOnUiThread(new Runnable() {
						@Override
						public void run() {
							if (numOfClicks >= 2) {
								doubleClickListener.onDoubleClick(v);
								isSingleClick.set(false);
							} else {
								isSingleClick.set(true);
							}
							numOfClicks = 0;
						}
					});
				}
			}, 500, TimeUnit.MILLISECONDS);
			
			isWaiting.set(false);
		}
		return isSingleClick.get();
	}
	
	
	@Override
	public void setOnDoubleClickListener(DoubleClickListener doubleClickListener) {
		this.doubleClickListener = doubleClickListener;
	}
}
