package com.android.yangjw.httpdemo;

import android.app.Application;

import org.xutils.x;

/**
 * Created by yangjw on 2016/2/23.
 */
public class MyApplication extends Application{

    @Override
    public void onCreate() {
        super.onCreate();
        x.Ext.init(this);
        x.Ext.setDebug(true);
    }
}
