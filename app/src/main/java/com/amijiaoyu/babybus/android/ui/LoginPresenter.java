package com.amijiaoyu.babybus.android.ui;

import android.app.Activity;
import com.amijiaoyu.babybus.android.base.RxActivityPresenter;
import com.amijiaoyu.babybus.android.di.helper.LoginHelper;
import com.amijiaoyu.babybus.android.model.bean.LoginOkBean;
import com.amijiaoyu.babybus.android.model.rx.ErrorHandlerSubscriber;
import com.amijiaoyu.babybus.android.model.rx.ProgressDialogSubscriber;
import com.amijiaoyu.babybus.android.utils.RxUtil;
import javax.inject.Inject;

/**
 * Date:2017/10/10 10:07
 * Email:imkobedroid@gmail.com
 *
 * @author dongshihong
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
        .compose(RxUtil.handleResult())
        .subscribeWith(new ProgressDialogSubscriber<LoginBean>((Activity) mView) {
          @Override public void onNext(LoginBean loginBean) {
            if (loginBean != null) {
              //AccountManager.getInstance((Activity) mView).storeAccount(loginBean);
              mView.loginSucceed("登录成功");
            }
          }
        }));
  }

  @Override public void getUserInfo() {
    addSubscribe(loginHelper.loginApi.getUser()
        .compose(RxUtil.rxSchedulerHelper())
        .compose(RxUtil.handleResult())
        .subscribeWith(new ProgressDialogSubscriber<UserInfoBean>((Activity) mView) {
          @Override public void onNext(UserInfoBean loginBean) {
            if (loginBean != null) {
              mView.loginSucceed("获取成功");
            }
          }
        }));
  }

    @Override
    public void loginPhone(String phone, String password) {
        addSubscribe(loginHelper.loginApi.login(phone,password)
            .compose(RxUtil.rxSchedulerHelper())
            .subscribeWith(new ErrorHandlerSubscriber<LoginOkBean>((Activity) mView) {
                @Override public void onNext(LoginOkBean loginBean) {
                    if (loginBean != null) {
                        mView.loginSucceed(loginBean.getName());
                    }
                }

                @Override
                public void onError(Throwable e) {
                    super.onError(e);
                    mView.loginField(e.toString());
                }
            }));
    }
}
