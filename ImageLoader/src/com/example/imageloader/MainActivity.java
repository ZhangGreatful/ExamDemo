package com.example.imageloader;

import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;

import android.app.Activity;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;

public class MainActivity extends Activity {
	
	private ImageView imageView;
	private String url="https://lh6.googleusercontent.com/-55osAWw3x0Q/URquUtcFr5I/AAAAAAAAAbs/rWlj1RUKrYI/s1024/A%252520Photographer.jpg";
	
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		imageView=(ImageView) findViewById(R.id.iv_image);
		

//		new Thread(){
//			public void run(){
//				显示图片配置
				DisplayImageOptions options=new DisplayImageOptions.Builder()
						.showImageOnLoading(R.mipmap.ic_launcher)
						.showImageOnFail(R.mipmap.ic_launcher)
						.cacheInMemory(true)
						.cacheOnDisc(true)
						.bitmapConfig(Bitmap.Config.RGB_565)
						.build();
				ImageLoader.getInstance().displayImage(url, imageView,options);
//			}
//		};
		
	}

}
