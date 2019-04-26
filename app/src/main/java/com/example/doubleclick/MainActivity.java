package com.example.doubleclick;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {
	DoubleClickView doubleClickView;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		doubleClickView = findViewById(R.id.double_click_button);
		
		doubleClickView.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Log.i("test342", "single cliker");
				doubleClickView.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
			}
		});
		
		doubleClickView.setOnDoubleClickListener(new DoubleClickListener() {
			@Override
			public void onDoubleClick(View view) {
				
				Log.i("test342", "doubleclickkkerr");
				doubleClickView.setBackgroundColor(getResources().getColor(R.color.colorAccent));
			}
		});
	
	}
}
