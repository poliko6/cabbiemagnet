package com.cabbiemagnet.android;

import android.content.Context;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.webkit.WebView;

import com.phonegap.DroidGap;

public class AndroidFunctions {
	
    private WebView mAppView;
    private DroidGap mGap;

    public AndroidFunctions(DroidGap gap, WebView view)
    {
        mAppView = view;
        mGap = gap;
    }

    public String getTelephoneNumber(){
        TelephonyManager tm = (TelephonyManager) mGap.getSystemService(Context.TELEPHONY_SERVICE);
        String number = tm.getLine1Number();
        Log.v("proba", "phonenum: " + tm.getDeviceId());
        return number;
    }
}