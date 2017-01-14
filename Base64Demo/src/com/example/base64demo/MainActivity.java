package com.example.base64demo;

import android.app.Activity;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends Activity {
	
	private String str="张彬";
	private TextView text;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		text=(TextView) findViewById(R.id.text);
		
		/*
		// 在这里使用的是encode方式，返回的是byte类型加密数据，可使用new String转为String类型
		String strBase64=new String(Base64.encode(str.getBytes(),Base64.DEFAULT));
		text.setText(strBase64);
		System.out.println(strBase64);
		Log.d("加密后信息--------", strBase64);
		
		
		// 这里 encodeToString 则直接将返回String类型的加密数据
		String enToStr = Base64.encodeToString(str.getBytes(), Base64.DEFAULT);
		Log.i("Test", "encodeToString >>> " + enToStr);
		
		
		*/
		
		try {
			text.setText(new String(Base64Util.decode(str)));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


}
