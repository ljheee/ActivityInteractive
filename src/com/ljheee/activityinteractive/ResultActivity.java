package com.ljheee.activityinteractive;

import com.ljheee.entity.Person;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
/**
 * 结果显示Activity
 * @author ljheee
 *
 */
public class ResultActivity extends Activity {

	private TextView result;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_result);//加载布局
		
		result = (TextView) findViewById(R.id.result);

		String str = "";
		// 获得MainActivity传递过来的Intent
		Intent intent = getIntent();
		// 通过Intent获得携带的数据Bundle
		Bundle bundle = intent.getExtras();
		// 从Bundle中获得对应数据
		Person p = (Person) bundle.getSerializable("person");

		if (p != null) {
			str += "用户名" + p.getName() + "\n";
			str += "密码" + p.getPass() + "\n";
			str += "地址" + p.getAddress() + "\n";
		}
		
		// 显示MainActivity传递过来的数据
		result.setText(str);

	}

}
