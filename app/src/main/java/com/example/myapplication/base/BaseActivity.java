package com.example.myapplication.base;

import android.hardware.camera2.CameraManager;
import android.os.Bundle;
import android.text.Layout;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.R;

/**
 * 作者：陈飞
 * 时间：2020/6/3 9:42
 */
public abstract class BaseActivity extends AppCompatActivity {

    public abstract int getLayoutId();

    public abstract void initView();

    public abstract void detachView();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        initView();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        detachView();
    }
}
