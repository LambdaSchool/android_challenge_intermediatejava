package com.example.doubleclick;

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
				Log.i("test23", "single click");
			}
		});
		
		doubleClickView.setOnDoubleClickListener(new DoubleClickListener() {
			@Override
			public void onDoubleClick(View view) {
			
				Log.i("test23", "double click");
			}
		});
	
	}
}
