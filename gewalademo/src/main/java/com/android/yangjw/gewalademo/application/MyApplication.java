package com.android.yangjw.gewalademo.application;

import android.app.Application;
import android.util.Log;

import org.xutils.x;

/**
 * Created by yangjw on 2016/2/22.
 */
public class MyApplication extends Application{

    public static final String TAG = MyApplication.class.toString();

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(TAG,"MyApplciation INIT");
        x.Ext.init(this);
        x.Ext.setDebug(false);

    }
}
