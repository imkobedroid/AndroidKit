package com.amijiaoyu.babybus.android.ui;

import android.app.Activity;
import com.amijiaoyu.babybus.android.base.RxActivityPresenter;
import com.amijiaoyu.babybus.android.di.helper.LoginHelper;
import com.amijiaoyu.babybus.android.model.account.AccountManager;
import com.amijiaoyu.babybus.android.model.rx.ProgressDialogSubscriber;
import com.amijiaoyu.babybus.android.utils.RxUtil;
import com.google.common.base.Strings;
import javax.inject.Inject;

/**
 * Author:Dsh
 * Date:2017/10/10 10:07
 * Email:imkobedroid@gmail.com
 */

public class LoginPresenter extends RxActivityPresenter<LoginConstance.View>
    implements LoginConstance.Presenter {
  private LoginHelper loginHelper;

  @Inject public LoginPresenter(LoginHelper loginHelper) {
    this.loginHelper = loginHelper;
  }

  @Override public void login(RequestBean requestBean) {
    addSubscribe(loginHelper.loginApi.getPayData(requestBean)
        .compose(RxUtil.rxSchedulerHelper())
        .subscribeWith(new ProgressDialogSubscriber<LoginBean>((Activity) mView) {
          @Override public void onNext(LoginBean loginBean) {
            if (loginBean != null) {
              AccountManager.getInstance((Activity) mView).storeAccount(loginBean);
              mView.loginSucceed("登录成功");
            }
          }
        }));
  }

  @Override public void getUserInfo() {
    addSubscribe(loginHelper.loginApi.getUser()
        .compose(RxUtil.rxSchedulerHelper())
        .subscribeWith(new ProgressDialogSubscriber<UserInfoBean>((Activity) mView) {
          @Override public void onNext(UserInfoBean loginBean) {
            if (loginBean != null && !Strings.isNullOrEmpty(loginBean.getMessage())) {
              mView.loginSucceed(loginBean.getMessage());
            } else {
              if (loginBean != null &&!Strings.isNullOrEmpty(loginBean.getMessage())) {
                mView.loginSucceed(loginBean.getMessage());
              }
            }
          }
        }));
  }
}
