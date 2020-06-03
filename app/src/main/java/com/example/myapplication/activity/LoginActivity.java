package com.example.myapplication.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.myapplication.R;
import com.example.myapplication.base.BaseActivity;
import com.example.myapplication.bean.BaseBean;
import com.example.myapplication.bean.UserBean;
import com.example.myapplication.contract.LoginContract;
import com.example.myapplication.presenter.LoginPresenter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends BaseActivity implements LoginContract.View {

    @BindView(R.id.et_username)
    EditText etUsername;
    @BindView(R.id.et_password)
    EditText etPassword;
    @BindView(R.id.btn_login)
    Button btnLogin;
    @BindView(R.id.tv_register)
    TextView tvRegister;
    private LoginPresenter presenter;

    @Override
    public int getLayoutId() {
        return R.layout.activity_login;
    }

    @Override
    public void initView() {
        presenter = new LoginPresenter();
        presenter.attachView(this);
    }

    @Override
    public void detachView() {
        presenter.detachView();
    }

    @Override
    public void show() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void onSuccess(BaseBean<UserBean> bean) {
        startActivity(new Intent(this, MainActivity.class));
    }

    @Override
    public void onError(String errMsg) {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @OnClick({R.id.btn_login, R.id.tv_register})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_login:
                presenter.login(getUsername(), getPassword());
                break;
            case R.id.tv_register:
                startActivity(new Intent(this, RegisterActivity.class));
                break;
        }
    }

    private String getUsername() {
        return etUsername.getText().toString().trim();
    }

    private String getPassword() {
        return etPassword.getText().toString().trim();
    }

}
