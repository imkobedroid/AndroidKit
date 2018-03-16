package com.amijiaoyu.babybus.android.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.amijiaoyu.babybus.android.R;
import com.amijiaoyu.babybus.android.base.RxActivity;
import com.amijiaoyu.babybus.android.di.module.UserBean;

import butterknife.BindView;

/**
 * @author Dsh toushihiroshi on 2018/3/16.
 */

public class LoginActivity extends RxActivity<LoginPresenter> implements LoginConstance.View {

    @BindView(R.id.account)EditText account;
    @BindView(R.id.password)EditText password;
    @BindView(R.id.login)Button login;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        login.setOnClickListener(v -> mPresenter.loginPhone(account.getText().toString(),password.getText().toString()));
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_login;
    }

    @Override
    protected void initInject() {
      getActivityComponent().inject(this);
    }

    @Override
    public void loginSucceed(String message) {
        Toast.makeText(this,message,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void loginField(String message) {
        Toast.makeText(this,message,Toast.LENGTH_SHORT).show();

    }

    @Override
    public void getUserInfoSucceed(UserBean userBean) {

    }
}
