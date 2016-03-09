package com.android.yangjw.gewalademo;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;

import org.xutils.x;

/**
 *
 * Xutils的使用
 * Created by yangjw on 2016/2/22.
 *
 */
public class BaseActivity  extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        x.view().inject(this);
    }
}
