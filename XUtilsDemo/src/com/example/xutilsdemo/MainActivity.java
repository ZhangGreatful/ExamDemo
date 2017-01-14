package com.example.xutilsdemo;

import com.lidroid.xutils.HttpUtils;
import com.lidroid.xutils.exception.HttpException;
import com.lidroid.xutils.http.RequestParams;
import com.lidroid.xutils.http.ResponseInfo;
import com.lidroid.xutils.http.callback.RequestCallBack;
import com.lidroid.xutils.http.client.HttpRequest;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

@SuppressLint("ShowToast")
public class MainActivity extends Activity {
	
	private TextView textView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		textView=(TextView) findViewById(R.id.tv_text);
		new Thread(){
			public void run(){
				RequestParams params = new RequestParams();
				params.addHeader("name", "value");
				params.addQueryStringParameter("name", "value");
				// 只包含字符串参数时默认使用BodyParamsEntity，
				// 类似于UrlEncodedFormEntity（"application/x-www-form-urlencoded"）。
				params.addBodyParameter("name", "value");
				// 加入文件参数后默认使用MultipartEntity（"multipart/form-data"），
				// 如需"multipart/related"，xUtils中提供的MultipartEntity支持设置subType为"related"。
				// 使用params.setBodyEntity(httpEntity)可设置更多类型的HttpEntity（如：
				// MultipartEntity,BodyParamsEntity,FileUploadEntity,InputStreamUploadEntity,StringEntity）。
				// 例如发送json参数：params.setBodyEntity(new StringEntity(jsonStr,charset));
//				params.addBodyParameter("file", new File("path"));
//				...
				HttpUtils http = new HttpUtils();
				http.send(HttpRequest.HttpMethod.POST,
				    "uploadUrl....",
				    params,
				    new RequestCallBack<String>() {
				        @Override
				        public void onStart() {
				            textView.setText("conn...");
				        }
				        @Override
				        public void onLoading(long total, long current, boolean isUploading) {
				            if (isUploading) {
				            	textView.setText("upload: " + current + "/" + total);
				            } else {
				            	textView.setText("reply: " + current + "/" + total);
				            }
				        }
				        @Override
				        public void onSuccess(ResponseInfo<String> responseInfo) {
				        	textView.setText("reply: " + responseInfo.result);
				        	Log.d("服务器返回信息--------------", responseInfo.result);
				        }
				        @Override
				        public void onFailure(HttpException error, String msg) {
				        	textView.setText(error.getExceptionCode() + ":" + msg);
				        }
						
				});
			}
		};
	}

	
}
