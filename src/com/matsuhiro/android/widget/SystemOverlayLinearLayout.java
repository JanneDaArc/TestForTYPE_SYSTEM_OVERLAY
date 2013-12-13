package com.matsuhiro.android.widget;

import android.content.Context;
import android.graphics.PixelFormat;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.WindowManager;
import android.widget.LinearLayout;


public class SystemOverlayLinearLayout extends LinearLayout {

	private Context mContext;
	
	public SystemOverlayLinearLayout(Context context) {
		super(context);
		mContext = context;
	}
	public SystemOverlayLinearLayout(Context context, AttributeSet attrs) {
		super(context, attrs);
		mContext = context;
	}

	public void addWindow() {
		
		WindowManager.LayoutParams params = new WindowManager.LayoutParams ();	
		params.gravity = Gravity.BOTTOM | Gravity.LEFT;	//下：Gravity.BOTTOM,上：Gravity.TOP,左:Gravity.LEFT,右：Gravity.RIGHT,上下中央:Gravity.CENTER_VERTICAL,左右中央:Gravity.CENTER_HORIZONTAL
		params.x       = 0; // 表示位置 x
		params.y       = 130; // 表示位置 y
		params.width   = 25;//ボタンの横幅
		params.height  = 100;//ボタンの長さ
		params.type = WindowManager.LayoutParams.TYPE_SYSTEM_ALERT;
		params.flags   = WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE | WindowManager.LayoutParams.FLAG_FULLSCREEN | WindowManager.LayoutParams.FLAG_NOT_TOUCH_MODAL;  
		params.format  = PixelFormat.TRANSLUCENT; // 透明を有効化
		WindowManager wm = (WindowManager) mContext.getSystemService(Context.WINDOW_SERVICE);
		wm.addView(getRootView(), params);
	}

	public void removeWindow() {
		WindowManager wm = (WindowManager) mContext.getSystemService(Context.WINDOW_SERVICE);
		wm.removeView(getRootView());
	}

	@Override
	public boolean dispatchTouchEvent (MotionEvent ev) {
		return super.dispatchTouchEvent(ev);
	}



}