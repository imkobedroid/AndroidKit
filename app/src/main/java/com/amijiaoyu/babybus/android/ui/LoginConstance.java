package com.amijiaoyu.babybus.android.ui;

import com.amijiaoyu.babybus.android.base.root.BaseActivityPresenter;
import com.amijiaoyu.babybus.android.base.root.BaseActivityView;

/**
 * Author:SHIHONG DONG
 * Date:2017/10/10 10:08
 * Email:imkobedroid@gmail.com
 */

public interface LoginConstance {

  interface View extends BaseActivityView {

    void loginSucceed(String message);

    void LoginField(String message);
  }

  interface Presenter extends BaseActivityPresenter<View> {

    void login(RequestBean requestBean);
  }
}
