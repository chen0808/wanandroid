package com.example.myapplication;

import android.app.Application;

/**
 * 作者：陈飞
 * 时间：2019/11/06 14:06
 */
public class MyApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        RetrofitHelper.init();
    }
}
