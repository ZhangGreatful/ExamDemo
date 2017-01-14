package com.example.imageloader;

import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

import android.app.Application;

public class MyApplication extends Application{
	
	@Override
	public void onCreate() {
		// TODO Auto-generated method stub
		super.onCreate();
		
//		创建默认的ImageLoader配置参数
		ImageLoaderConfiguration configuration=new ImageLoaderConfiguration.Builder(this)
				.writeDebugLogs()//打印Log信息
				.build();
		
//		初始化ImageLoader配置
		ImageLoader.getInstance().init(configuration);
	}
}
