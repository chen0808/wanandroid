package com.example.myapplication.contract;

import com.example.myapplication.base.BaseView;
import com.example.myapplication.bean.BaseBean;
import com.example.myapplication.bean.UserBean;

import io.reactivex.Observable;

/**
 * 作者：陈飞
 * 时间：2020/6/3 9:31
 */
public interface LoginContract {
    interface Model {
        Observable<BaseBean<UserBean>> login(String username, String password);
    }

    interface View extends BaseView {
        void onSuccess(BaseBean<UserBean> bean);
    }

    interface Presenter {
        /**
         * 登录
         * @param username 用户名
         * @param password 密码
         */
        void login(String username,String password);
    }
}
