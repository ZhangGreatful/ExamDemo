package com.example.push;

import android.app.Application;
import cn.jpush.android.api.JPushInterface;

public class MyApplication extends Application {

	@Override
	public void onCreate() {
		// TODO Auto-generated method stub
		super.onCreate();
//		设置调试模式
		JPushInterface.setDebugMode(true);
//		初始化SDK
		JPushInterface.init(this);
	}
}
