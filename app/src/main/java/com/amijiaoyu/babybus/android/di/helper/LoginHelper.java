package com.amijiaoyu.babybus.android.di.helper;

import com.amijiaoyu.babybus.android.di.module.LoginApi;
import javax.inject.Inject;

/**
 * Author:Dsh
 * Date:2017/10/10 09:48
 * Email:imkobedroid@gmail.com
 */

public class LoginHelper {
  public LoginApi loginApi;

  @Inject public LoginHelper(LoginApi loginApi) {
    this.loginApi = loginApi;
  }
}
