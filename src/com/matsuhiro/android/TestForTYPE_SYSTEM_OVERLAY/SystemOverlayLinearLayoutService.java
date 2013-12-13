package com.matsuhiro.android.TestForTYPE_SYSTEM_OVERLAY;


import com.matsuhiro.android.widget.SystemOverlayLinearLayout;

import android.app.Notification;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.Vibrator;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;


public class SystemOverlayLinearLayoutService extends Service {
	
	private LinearLayout mLinearLayout;
	private SystemOverlayLinearLayout mLayout;
	private int mTouchCount = 0;
	
	@Override
	public IBinder onBind(Intent intent) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void onStart(Intent intent, int startId) {
				
		LayoutInflater inflater = (LayoutInflater)this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		mLinearLayout = (LinearLayout)inflater.inflate(R.layout.systemoverlayout, null);
		
		mLayout = (SystemOverlayLinearLayout)mLinearLayout.findViewById(R.id.overlay);
		
		ImageButton btn = (ImageButton)mLayout.findViewById(R.id.overbutton);
		btn.setBackgroundDrawable(null);
		
		Notification lNotification = new Notification(0, "ticker", System.currentTimeMillis());
		startForeground(1, lNotification);
		
		btn.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Log.v("onClic","down"+mTouchCount);
				Vibrator vibrator = (Vibrator)getSystemService(VIBRATOR_SERVICE);
				vibrator.vibrate(80);
				Intent intent = new Intent(SystemOverlayLinearLayoutService.this, MainActivity.class);
				intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
				startActivity(intent);

			}
		});
		btn.setOnTouchListener(new View.OnTouchListener() {
			
			@Override
			public boolean onTouch(View v, MotionEvent event) {

				return false;
			}
		});
		
		mLayout.addWindow();
	}
	
	@Override
	public void onDestroy() {
		mLayout.removeAllViews();
		mLayout.removeWindow();
		mLayout = null;
	}
}
