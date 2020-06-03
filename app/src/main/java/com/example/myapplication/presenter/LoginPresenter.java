package com.example.myapplication.presenter;

import android.annotation.SuppressLint;

import com.example.myapplication.base.BasePresenter;
import com.example.myapplication.contract.LoginContract;
import com.example.myapplication.model.LoginModel;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * 作者：陈飞
 * 时间：2020/6/3 9:37
 */
public class LoginPresenter extends BasePresenter<LoginContract.View> implements LoginContract.Presenter {

    private final LoginModel loginModel;

    public LoginPresenter() {
        loginModel = new LoginModel();
    }

    @SuppressLint("CheckResult")
    @Override
    public void login(String username, String password) {
        if (!isViewAttached()) {
            return;
        }
        mView.show();
        loginModel.login(username, password)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe((bean) -> {
                    mView.hide();
                    mView.onSuccess(bean);
                }, (throwable) -> {
                    mView.hide();
                    mView.onError(throwable.getMessage());

                });
    }
}
