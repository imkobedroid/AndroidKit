package com.amijiaoyu.babybus.android.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import butterknife.BindView;
import com.amijiaoyu.babybus.android.base.RxActivity;
import com.amijiaoyu.babybus.android.R;
import com.amijiaoyu.babybus.android.utils.SnackbarUtil;
import work.wanghao.rxbus2.Subscribe;

/**
 * Author:SHIHONG DONG
 * Date:2017/10/10 10:00
 * Email:imkobedroid@gmail.com
 */

public class LoginActivity extends RxActivity<LoginPresenter> implements LoginConstance.View {
  @BindView(R.id.account) EditText account;
  @BindView(R.id.password) EditText password;
  @BindView(R.id.login) Button login;
  @BindView(R.id.view_main) LinearLayout view_main;

  @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    login();
  }

  private void login() {
    login.setOnClickListener(view -> mPresenter.login(new RequestBean()));
  }

  @Override protected int getLayout() {
    return R.layout.activity_login;
  }

  @Override protected void initInject() {
    getActivityComponent().inject(this);
  }

  @Override public void loginSucceed(String message) {
    SnackbarUtil.show(view_main, message);
  }

  @Override public void LoginField(String message) {

  }
}
