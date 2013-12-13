package com.matsuhiro.android.TestForTYPE_SYSTEM_OVERLAY;





import android.os.Bundle;
import android.preference.PreferenceManager;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.graphics.drawable.Drawable;

import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.AdapterView.OnItemClickListener;


public class MainActivity extends Activity implements 
OnClickListener,OnLongClickListener,OnItemClickListener{


	String pkname;
	String pkname2;
	String pkname3;
	String pkname4;
	String pkname5;
	String pkname6;
	String pkname7;//インテントの初期値を入れる為の変数
	


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.button);


		// プリファレンスを生成
		SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(this);
		//設定の読み込み処理
		pkname = pref.getString("pkname","");
		pkname2 = pref.getString("pkname2","");
		pkname3 = pref.getString("pkname3","");
		pkname4 = pref.getString("pkname4","");
		pkname5 = pref.getString("pkname5","");
		pkname6 = pref.getString("pkname6","");
		pkname7 = pref.getString("pkname7","");





		ImageButton iconImg = (ImageButton)findViewById(R.id.imageButton1);
		iconImg.setOnClickListener(this);
		iconImg.setOnLongClickListener(this);

		ImageButton iconImg2 = (ImageButton)findViewById(R.id.imageButton2);
		iconImg2.setOnClickListener(this);
		iconImg2.setOnLongClickListener(this);

		ImageButton iconImg3 = (ImageButton)findViewById(R.id.imageButton3);
		iconImg3.setOnClickListener(this);
		iconImg3.setOnLongClickListener(this);

		ImageButton iconImg4 = (ImageButton)findViewById(R.id.imageButton4);
		iconImg4.setOnClickListener(this);
		iconImg4.setOnLongClickListener(this);

		ImageButton iconImg5 = (ImageButton)findViewById(R.id.imageButton5);
		iconImg5.setOnClickListener(this);
		iconImg5.setOnLongClickListener(this);

		ImageButton iconImg6 = (ImageButton)findViewById(R.id.imageButton6);
		iconImg6.setOnClickListener(this);
		iconImg6.setOnLongClickListener(this);

		View layout = findViewById(R.id.RelativeLayout1);
		layout.setOnClickListener(this);
		layout.setOnLongClickListener(this);
		
		//既存のボタン背景をなくす
		iconImg.setBackgroundDrawable(null);
		iconImg2.setBackgroundDrawable(null);
		iconImg3.setBackgroundDrawable(null);
		iconImg4.setBackgroundDrawable(null);
		iconImg5.setBackgroundDrawable(null);
		iconImg6.setBackgroundDrawable(null);

		//変数の値が初期値ならデフォルトアイコン、そうでなければ保存された値をセット
		if(pkname!=pkname7){
			seticon(pkname);

		}if(pkname2!=pkname7){	
			seticon2(pkname2);

		}if(pkname3!=pkname7){
			seticon3(pkname3);

		}if(pkname4!=pkname7){
			seticon4(pkname4);

		}if(pkname5!=pkname7){
			seticon5(pkname5);

		}if(pkname6!=pkname7){
			seticon6(pkname6);
		}
	}
	@Override
	public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
		// TODO 自動生成されたメソッド・スタブ

	}

	@Override
	public boolean onLongClick(View v) {
		// TODO 自動生成されたメソッド・スタブ

		switch (v.getId()){

		case R.id.imageButton1:

			Intent intent =new Intent(MainActivity.this, Itiran.class);
			startActivity(intent);

			break;
		case R.id.imageButton2:

			Intent intent2 =new Intent(MainActivity.this, Itiran2.class);
			startActivity(intent2);

			break;
		case R.id.imageButton3:

			Intent intent3 =new Intent(MainActivity.this, Itiran3.class);
			startActivity(intent3);

			break;
		case R.id.imageButton4:

			Intent intent4 =new Intent(MainActivity.this, Itiran4.class);
			startActivity(intent4);

			break;
		case R.id.imageButton5:

			Intent intent5 =new Intent(MainActivity.this, Itiran5.class);
			startActivity(intent5);

			break;
		case R.id.imageButton6:

			Intent intent6 =new Intent(MainActivity.this, Itiran6.class);
			startActivity(intent6);

			break;

		}
		this.finish();
		return true;
	}

	@Override
	public void onClick(View v) {
		// TODO 自動生成されたメソッド・スタブ

		PackageManager pm = getPackageManager();
		switch (v.getId()){


		case R.id.imageButton1:

			startActivity(pm.getLaunchIntentForPackage(pkname));
			break;

		case R.id.imageButton2:

			startActivity(pm.getLaunchIntentForPackage(pkname2));
			break;

		case R.id.imageButton3:

			startActivity(pm.getLaunchIntentForPackage(pkname3));
			break;

		case R.id.imageButton4:

			startActivity(pm.getLaunchIntentForPackage(pkname4));
			break;

		case R.id.imageButton5:

			startActivity(pm.getLaunchIntentForPackage(pkname5));
			break;

		case R.id.imageButton6:

			startActivity(pm.getLaunchIntentForPackage(pkname6));
			break;

		case R.id.RelativeLayout1:

			break;

		}
		this.finish();
		return;
	}
	//イメージボタンに指定したパッケージのアイコンをセット
	public void seticon(String pkname){


		PackageManager pm = getPackageManager();
		ImageButton iconImg = (ImageButton)findViewById(R.id.imageButton1);
		Drawable icon = null;
		try {
			//アプリのアイコン取得

			icon = pm.getApplicationIcon(pkname);
		} catch (NameNotFoundException e) {
			e.printStackTrace();
		}
		//取得したアプリのアイコンを、ImageButtonにセット

		iconImg.setImageDrawable(icon);
	}
	//イメージボタンに指定したパッケージのアイコンをセット
	public void seticon2(String pkname2){
		PackageManager pm = getPackageManager();
		ImageButton iconImg2 = (ImageButton)findViewById(R.id.imageButton2);
		Drawable icon2 = null;
		try {
			//アプリのアイコン取得

			icon2 = pm.getApplicationIcon(pkname2);
		} catch (NameNotFoundException e) {
			e.printStackTrace();
		}
		//取得したアプリのアイコンを、ImageButtonにセット

		iconImg2.setImageDrawable(icon2);
	}
	//イメージボタンに指定したパッケージのアイコンをセット
	public void seticon3(String pkname3){
		PackageManager pm = getPackageManager();
		ImageButton iconImg3 = (ImageButton)findViewById(R.id.imageButton3);
		Drawable icon3 = null;
		try {
			//アプリのアイコン取得

			icon3= pm.getApplicationIcon(pkname3);
		} catch (NameNotFoundException e) {
			e.printStackTrace();
		}
		//取得したアプリのアイコンを、ImageButtonにセット

		iconImg3.setImageDrawable(icon3);

	}
	//イメージボタンに指定したパッケージのアイコンをセット
	public void seticon4(String pkname4){
		PackageManager pm = getPackageManager();
		ImageButton iconImg4 = (ImageButton)findViewById(R.id.imageButton4);
		Drawable icon4 = null;
		try {
			//アプリのアイコン取得

			icon4= pm.getApplicationIcon(pkname4);
		} catch (NameNotFoundException e) {
			e.printStackTrace();
		}
		//取得したアプリのアイコンを、ImageButtonにセット

		iconImg4.setImageDrawable(icon4);

	}
	//イメージボタンに指定したパッケージのアイコンをセット
	public void seticon5(String pkname5){
		PackageManager pm = getPackageManager();
		ImageButton iconImg5 = (ImageButton)findViewById(R.id.imageButton5);
		Drawable icon5 = null;
		try {
			//アプリのアイコン取得

			icon5= pm.getApplicationIcon(pkname5);
		} catch (NameNotFoundException e) {
			e.printStackTrace();
		}
		//取得したアプリのアイコンを、ImageButtonにセット

		iconImg5.setImageDrawable(icon5);

	}
	//イメージボタンに指定したパッケージのアイコンをセット
	public void seticon6(String pkname6){
		PackageManager pm = getPackageManager();
		ImageButton iconImg6 = (ImageButton)findViewById(R.id.imageButton6);
		Drawable icon6 = null;
		try {
			//アプリのアイコン取得

			icon6= pm.getApplicationIcon(pkname6);
		} catch (NameNotFoundException e) {
			e.printStackTrace();
		}
		//取得したアプリのアイコンを、ImageButtonにセット

		iconImg6.setImageDrawable(icon6);

	}

	@Override
	protected void onResume() {


		super.onResume();
		SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(this);
		//設定の読み込み処理

		Editor e = pref.edit();
		Intent intent = getIntent();

		//"packagename"というキーを受け取っているかの判定
		if(intent.hasExtra("pkname")){

			//設定の書き込み処理
			pkname =intent.getStringExtra("pkname");

			e.putString("pkname", pkname);
			e.commit();
			
			//設定の読み込み処置
			pkname = pref.getString("pkname","");
			seticon(pkname);


		}else if(intent.hasExtra("pkname2")){


			pkname2 =intent.getStringExtra("pkname2");
			e.putString("pkname2", pkname2);
			e.commit();


			pkname2 = pref.getString("pkname2","");
			seticon2(pkname2);

		}else if(intent.hasExtra("pkname3")){


			pkname3 =intent.getStringExtra("pkname3");
			e.putString("pkname3", pkname3);
			e.commit();

			pkname3 = pref.getString("pkname3","");
			seticon3(pkname3);

		}else if(intent.hasExtra("pkname4")){


			pkname4 =intent.getStringExtra("pkname4");
			e.putString("pkname4", pkname4);
			e.commit();

			pkname4 = pref.getString("pkname4","");
			seticon4(pkname4);

		}else if(intent.hasExtra("pkname5")){


			pkname5 =intent.getStringExtra("pkname5");
			e.putString("pkname5", pkname5);
			e.commit();

			pkname5 = pref.getString("pkname5","");
			seticon5(pkname5);

		}else if(intent.hasExtra("pkname6")){


			pkname6 =intent.getStringExtra("pkname6");
			e.putString("pkname6", pkname6);
			e.commit();

			pkname6 = pref.getString("pkname6","");
			seticon6(pkname6);


		}else if(intent.hasExtra("pkname7")){
			

			pkname7 =intent.getStringExtra("pkname7");
			e.putString("pkname7", pkname7);
			e.commit();
		}
	}
}
