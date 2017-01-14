package com.example.speakdemo;

import com.iflytek.speech.SynthesizerPlayer;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends Activity {
	
	 private static final String APPID = "appid=57c8ec3c";


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		speak("hello 你好");
	}

	public void speak(String str){
		// 这是后台朗读，实例化一个SynthesizerPlayer
		SynthesizerPlayer player = SynthesizerPlayer.createSynthesizerPlayer(this, APPID);
		// 设置语音朗读者，可以根据需要设置男女朗读，具体请看api文档和官方论坛
		player.setVoiceName("vivixiaoyan");// 在此设置语音播报的人选例如：vivixiaoyan、vivixiaomei、vivixiaoqi
		player.playText(str, "ent=vivi21,bft=5", null);
		
//		  RecognizerDialog isrDialog = new RecognizerDialog(SplashActivity.this, APPID);  
//		  
//          /* 
//           * 设置引擎目前支持五种 ”sms”：普通文本转写 “poi”：地名搜索 ”vsearch”：热词搜索 
//           * ”video”：视频音乐搜索 ”asr”：命令词识别 
//           */  
//          isrDialog.setEngine("sms", null, null);  
//          isrDialog.setListener(recoListener);  
//          isrDialog.show();  
		
	}
}
