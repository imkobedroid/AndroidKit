package com.example.dongshihong.androidkit.ui;

import android.app.Activity;
import com.example.dongshihong.androidkit.base.RxActivityPresenter;
import com.example.dongshihong.androidkit.di.helper.LoginHelper;
import com.example.dongshihong.androidkit.model.rx.ProgressDialogSubscriber;
import com.example.dongshihong.androidkit.utils.RxUtil;
import javax.inject.Inject;

/**
 * Author:SHIHONG DONG
 * Date:2017/10/10 10:07
 * Email:imkobedroid@gmail.com
 */

public class LoginPresenter extends RxActivityPresenter<LoginConstance.View>
    implements LoginConstance.Presenter {

  public LoginHelper loginHelper;

  @Inject public LoginPresenter(LoginHelper loginHelper) {
    this.loginHelper = loginHelper;
  }

  @Override public void login(RequestBean requestBean) {
    addSubscribe(
        loginHelper.loginApi.getPayData(requestBean)
            .compose(RxUtil.rxSchedulerHelper())
            .subscribeWith(new ProgressDialogSubscriber<LoginBean>((Activity) mView) {
              @Override public void onNext(LoginBean loginBean) {
                  if (loginBean!=null){
                    mView.loginSucceed("登录成功");
                  }
              }
            }));
  }
}
