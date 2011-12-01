package com.cabbiemagnet.android;

import com.phonegap.DroidGap;
import android.os.Bundle;

public class MainActivity extends DroidGap {

	private static final String TAG = "MainActivity";
	private AndroidFunctions af;

	 @Override
	    public void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);

	        
	        super.init(); 
			
			af = new AndroidFunctions(this, appView);
			appView.addJavascriptInterface(af, "MyCls");

			super.loadUrl("file:///android_asset/www/index.html");
	        
	 }
}
