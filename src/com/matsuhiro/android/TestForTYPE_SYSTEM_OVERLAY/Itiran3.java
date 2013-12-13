package com.matsuhiro.android.TestForTYPE_SYSTEM_OVERLAY;

import java.util.ArrayList;
import java.util.List;



import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.AdapterView.OnItemClickListener;

public class Itiran3 extends Activity implements 
OnClickListener,OnLongClickListener,OnItemClickListener{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		final PackageManager pm = getPackageManager();


		// 端末にインストール済のアプリケーション一覧情報を取得
		final List<ApplicationInfo> installedAppList = pm.getInstalledApplications(0);

		// リストに一覧データを格納する
		final List<AppData> dataList = new ArrayList<AppData>();
		for (ApplicationInfo app : installedAppList) {
			AppData data = new AppData();
			data.label = app.loadLabel(pm).toString();
			data.icon = app.loadIcon(pm);
			dataList.add(data);
		}

		// リストビューにアプリケーションの一覧を表示する
		final ListView listView = new ListView(this);
		listView.setAdapter(new AppListAdapter(this, dataList));
		setContentView(listView);
		listView.setOnItemClickListener(new ClickEvent());
	}

	// アプリケーションデータ格納クラス
	private static class AppData {
		String label;
		Drawable icon;
	}

	// アプリケーションのラベルとアイコンを表示するためのアダプタークラス
	private static class AppListAdapter extends ArrayAdapter<AppData> {

		private final LayoutInflater mInflater;

		public AppListAdapter(Context context, List<AppData> dataList) {
			super(context, R.layout.applist);
			mInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			// addAll(dataList);　←これが使えないためfor文で代用
			for(AppData h :dataList){  
				add(h);  
			}  
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {

			ViewHolder holder = new ViewHolder();

			if (convertView == null) {
				convertView = mInflater
						.inflate(R.layout.applist, parent, false);
				holder.textLabel = (TextView) convertView.findViewById(R.id.label);
				holder.imageIcon = (ImageView) convertView.findViewById(R.id.icon);
				convertView.setTag(holder);
			} else {
				holder = (ViewHolder) convertView.getTag();
			}

			// 表示データを取得
			final AppData data = getItem(position);
			// ラベルとアイコンをリストビューに設定
			holder.textLabel.setText(data.label);
			holder.imageIcon.setImageDrawable(data.icon);

			return convertView;
		}
	}

	// ビューホルダー
	private static class ViewHolder {
		TextView textLabel;
		ImageView imageIcon;
	}
	// イベントクラスの定義
	class ClickEvent implements OnItemClickListener {
		@Override
		public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
			// TODO 自動生成されたメソッド・スタブ
			final PackageManager pm = getPackageManager();
			final List<?> appInfoList = pm.getInstalledApplications(BIND_AUTO_CREATE);
			ApplicationInfo ai = (ApplicationInfo) appInfoList.get(position);

			mes(ai);
		}
	};

	//キーをつけてパッケージ名を渡す処理
	public void mes(ApplicationInfo ai){

		Intent intent =new Intent(Itiran3.this, MainActivity.class);
		intent.putExtra("pkname3",ai.packageName.toString());


		startActivity(intent);
		this.finish();
	}
	@Override
	public boolean onLongClick(View v) {
		// TODO 自動生成されたメソッド・スタブ
		return false;
	}


	@Override
	public void onClick(View v) {
		// TODO 自動生成されたメソッド・スタブ

	}


	@Override
	public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
		// TODO 自動生成されたメソッド・スタブ

	}


}



