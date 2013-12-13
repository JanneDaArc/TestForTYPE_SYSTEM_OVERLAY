package com.matsuhiro.android.TestForTYPE_SYSTEM_OVERLAY;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class BootReceiver extends BroadcastReceiver {
	//端末が起動された時インテントを受け取るメソッド
	@Override
	public void onReceive(Context context, Intent intent) {
		// TODO Auto-generated method stub
		if(Intent.ACTION_BOOT_COMPLETED.equals(intent.getAction())) {
			// サービスの起動
			Intent service = new Intent(context, SystemOverlayLinearLayoutService.class); 
			context.startService(service);
		}
	}
}