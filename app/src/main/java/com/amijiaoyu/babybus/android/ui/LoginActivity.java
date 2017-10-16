package com.amijiaoyu.babybus.android.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import butterknife.BindView;
import com.amijiaoyu.babybus.android.R;
import com.amijiaoyu.babybus.android.base.RxActivity;
import com.amijiaoyu.babybus.android.di.module.UserBean;
import com.amijiaoyu.babybus.android.utils.SnackbarUtil;
import work.wanghao.rxbus2.RxBus;
import work.wanghao.rxbus2.Subscribe;
import work.wanghao.rxbus2.ThreadMode;

/**
 * Date:2017/10/10 10:00
 * Email:imkobedroid@gmail.com
 *
 * @author dongshihong
 */

public class LoginActivity extends RxActivity<LoginPresenter> implements LoginConstance.View {
  @BindView(R.id.account) EditText account;
  @BindView(R.id.password) EditText password;
  @BindView(R.id.login) Button login;
  @BindView(R.id.view_main) LinearLayout viewMain;
  @BindView(R.id.user) Button user;
  @BindView(R.id.user) Button use;

  @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    RxBus.Companion.get().register(this);
    login();
  }

  @Subscribe(threadMode = ThreadMode.MAIN) public void noUser(NoUser noUser) {
    SnackbarUtil.show(viewMain, "没有找到用户信息");
  }

  @Override protected void onDestroy() {
    super.onDestroy();
    RxBus.Companion.get().unRegister(this);
  }

  private void login() {
    login.setOnClickListener(view -> mPresenter.login(new RequestBean()));
    user.setOnClickListener(view -> mPresenter.getUserInfo());
  }

  @Override protected int getLayout() {
    return R.layout.activity_login;
  }

  @Override protected void initInject() {
    getActivityComponent().inject(this);
  }

  @Override public void loginSucceed(String message) {
    SnackbarUtil.show(viewMain, message);
  }

  @Override public void loginField(String message) {

  }

  @Override public void getUserInfoSucceed(UserBean userBean) {
    SnackbarUtil.show(viewMain, "获取成功");
  }
}
