package com.example.filelistdemo;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends Activity {
	
	 private List<File> mFileList;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		mFileList=new ArrayList<File>();
    	File f=new File("/mnt/extsd1/CarDVR/pic");
    	List<File>fileList=getFile(f);
    	for(int i=0;i<fileList.size();i++){
    		File file=fileList.get(i);
    	}
	}

	private List<File> getFile(File file) {
		// TODO Auto-generated method stub
		
		File[] fileArray = file.listFiles();
		for (File f : fileArray) {
		if (f.isFile()) {
		mFileList.add(f);
		} else {
		getFile(f);
		}
		}
		System.out.println(mFileList.toString());
		return mFileList;
		}
	
	}


