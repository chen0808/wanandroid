package com.example.myapplication.base;

import com.example.myapplication.bean.BaseBean;

/**
 * 作者：陈飞
 * 时间：2020/6/3 9:32
 */
public interface BaseView {
    void show();

    void hide();

    void onError(String errMsg);
}
