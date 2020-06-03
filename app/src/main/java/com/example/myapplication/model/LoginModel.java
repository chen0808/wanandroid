package com.example.myapplication.model;

import com.example.myapplication.bean.BaseBean;
import com.example.myapplication.bean.UserBean;
import com.example.myapplication.contract.LoginContract;
import com.example.myapplication.net.RetrofitHelper;

import io.reactivex.Observable;


/**
 * 作者：陈飞
 * 时间：2020/6/3 9:38
 */
public class LoginModel implements LoginContract.Model {
    @Override
    public Observable<BaseBean<UserBean>> login(String username, String password) {
        return RetrofitHelper.getRequest().login(username, password);
    }
}
