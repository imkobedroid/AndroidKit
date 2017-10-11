package com.amijiaoyu.babybus.android.ui;

/**
 * Author:SHIHONG DONG
 * Date:2017/9/28 14:23
 * Email:imkobedroid@gmail.com
 */

public class RequestBean {

  private String grant_type = "password";
  private String client_id = "2";
  private String client_secret = "XKnfmouiJLXfcEr93KKsSMg1XXz8p0qu1ZRKfEVU";
  private String username = "test";
  private String password = "123456";

  public String getGrant_type() {
    return grant_type;
  }

  public void setGrant_type(String grant_type) {
    this.grant_type = grant_type;
  }

  public String getClient_id() {
    return client_id;
  }

  public void setClient_id(String client_id) {
    this.client_id = client_id;
  }

  public String getClient_secret() {
    return client_secret;
  }

  public void setClient_secret(String client_secret) {
    this.client_secret = client_secret;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }
}
