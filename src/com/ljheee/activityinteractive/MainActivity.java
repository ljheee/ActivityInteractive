package com.ljheee.activityinteractive;

import com.ljheee.entity.Person;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

	public static final int ADDR_CODE = 0;
	public static final int ReslutActivity_CODE = 1;
	
	private EditText userName;
	private EditText userPass;
	private TextView show;
	
	private Button addrSelect;
	private Button cancle;
	private Button next;
	
	private String address;
	
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        initView();
        
    }

    /**
     * 加载控件
     */
	private void initView() {
		userName = (EditText) findViewById(R.id.username);
        userPass = (EditText) findViewById(R.id.userpass);
        show = (TextView) findViewById(R.id.show);
        
        addrSelect = (Button) findViewById(R.id.btn_address);
        cancle = (Button) findViewById(R.id.btn_cancle);
        next = (Button) findViewById(R.id.btn_next);
        
        BtnHandler handler = new BtnHandler();
        
        addrSelect.setOnClickListener(handler);
        cancle.setOnClickListener(handler);
        next.setOnClickListener(handler);
	}

	/**
	 * 接受开启子Activity的返回值，并处理
	 */
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent intent) {
    	super.onActivityResult(requestCode, resultCode, intent);
    	
    	switch (requestCode) {
		case ADDR_CODE:
			if(resultCode == Activity.RESULT_OK){
				Bundle data = intent.getExtras();
				address = data.getString("province");
				show.setText(address);
			}
			break;

		default:
			break;
		}
    	
    }
    
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
    
    /**
     * 选项菜单--点击事件处理
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
    	
    	switch (item.getItemId()) {
		case R.id.action_exit:
			finish();
			break;
		case R.id.action_settings:
			Toast.makeText(this, "settings", Toast.LENGTH_SHORT).show();
			break;

		default:
			break;
		}
    	return super.onOptionsItemSelected(item);
    }
    
    /**
     * 按钮事件
     * @author ljheee
     *
     */
    class BtnHandler implements OnClickListener{

		@Override
		public void onClick(View v) {
			switch (v.getId()) {
			case R.id.btn_address:
				Intent addrIntent = new Intent(MainActivity.this, AdressSelectedActivity.class);
				//如果有值返回，
				//则使用startActivityForResult方法启动其它Activity
				//第二个参数为请求码，一个Activity可开启多种请求
				startActivityForResult(addrIntent, ADDR_CODE);

				break;
			case R.id.btn_cancle:
				userName.setText("");
				userPass.setText("");
				show.setText("");
				break;
			case R.id.btn_next://下一步
				
				String name = userName.getText().toString();
				String pass = userPass.getText().toString();
				Person p = new Person(name, pass, address);
				
				Intent intent = new Intent(MainActivity.this, ResultActivity.class);
				//创建Bundle
				Bundle data = new Bundle();
				data.putSerializable("person", p);
				//intent携带Bundle
				intent.putExtras(data);
				//启动对应的Activity
				startActivity(intent);
				
				break;

			default:
				break;
			}
		}
    }
    
    
    
    
}
