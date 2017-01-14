package com.example.networkdemo;

import android.app.Activity;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

/**
 * 判断网络链接是否成功
 * @author Administrator
 *
 */
public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		networkStatusOK(this);
	}
	public static boolean networkStatusOK(Context mContext) {
		  boolean netStatus = false;
		  try{
		   ConnectivityManager connectManager =(ConnectivityManager) mContext.getSystemService(Context.CONNECTIVITY_SERVICE);
		   NetworkInfo activeNetworkInfo = connectManager.getActiveNetworkInfo();
		   if (activeNetworkInfo != null) {
		    if (activeNetworkInfo.isAvailable() && activeNetworkInfo.isConnected()) {
		     netStatus = true;
		     System.out.println("网络连接成功");
		    }else{
		    	System.out.println("网络连接失败");
		    }
		    
		   }
		  } catch (Exception e) {e.printStackTrace();
		  }
		 
		  return netStatus;
		 }
}
