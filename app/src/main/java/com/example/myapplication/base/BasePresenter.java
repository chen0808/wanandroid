package com.example.myapplication.base;

/**
 * 作者：陈飞
 * 时间：2020/6/3 9:32
 */
public class BasePresenter<V extends BaseView> {
    protected V mView;

    /**
     * 绑定View，一般在初始化中调用该方法
     * @param view view
     */
    public void attachView(V view) {
        this.mView = view;
    }

    /**
     * 解除绑定，一般在onDestory()中调用
     */
    public void detachView() {
        this.mView = null;
    }

    /**
     * 是否绑定
     */
    protected boolean isViewAttached() {
        return mView != null;
    }
}
