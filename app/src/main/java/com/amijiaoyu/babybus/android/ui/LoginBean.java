package com.amijiaoyu.babybus.android.ui;

import com.amijiaoyu.babybus.android.model.account.BaseAccount;
import com.google.common.base.Strings;

/**
 * Author:SHIHONG DONG
 * Date:2017/10/10 10:40
 * Email:imkobedroid@gmail.com
 */

public class LoginBean implements BaseAccount {
  private String access_token;
  private String refresh_token;
  private String expires_in;
  private Object data;

  public String getAccess_token() {
    return access_token;
  }

  public void setAccess_token(String access_token) {
    this.access_token = access_token;
  }

  public String getRefresh_token() {
    return refresh_token;
  }

  public void setRefresh_token(String refresh_token) {
    this.refresh_token = refresh_token;
  }

  public String getExpires_in() {
    return expires_in;
  }

  public void setExpires_in(String expires_in) {
    this.expires_in = expires_in;
  }

  public Object getData() {
    return data;
  }

  public void setData(Object data) {
    this.data = data;
  }

  @Override public String name() {
    return null;
  }

  @Override public String token() {
    if (!Strings.isNullOrEmpty(access_token)) {
      return access_token;
    }
    return "";
  }

  @Override public String toJson() {
    return null;
  }
}
