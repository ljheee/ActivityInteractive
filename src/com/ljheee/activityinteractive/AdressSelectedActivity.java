package com.ljheee.activityinteractive;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class AdressSelectedActivity extends ListActivity {
	
	private static String[] addresses = new String[]{"湖南","湖北","广东"};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, addresses);
		setListAdapter(adapter);
	}

	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		super.onListItemClick(l, v, position, id);
		
		
		//获得intent，并通过intent携带数据返回
		Intent intent = getIntent();
		Bundle data = new Bundle();
		data.putString("province", addresses[position]);
		intent.putExtras(data);
		this.setResult(Activity.RESULT_OK,intent);//设置返回码为Activity.RESULT_OK，返回intent
		
		//本Activity结束，退出该Activity
		AdressSelectedActivity.this.finish();
	}
}
