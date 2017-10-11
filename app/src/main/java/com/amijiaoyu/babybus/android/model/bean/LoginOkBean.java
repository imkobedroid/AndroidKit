package com.amijiaoyu.babybus.android.model.bean;

import com.amijiaoyu.babybus.android.model.account.BaseAccount;
import com.google.common.base.Strings;

/**
 * Created by Dsh on 2017/5/17.
 * Use:
 */

public class LoginOkBean implements BaseAccount {
  private int id;
  private String mobile;
  private String nickname;
  private String email;
  private String avatar;
  private String city;
  private long birthday;
  private String name;
  private String im_token;
  private String registration_id;
  private int gender;
  private String remark;
  private double balance;
  private int credits;
  private String token;
  private String wechat_id;
  private String alipay_id;
  private boolean has_pay_password;
  private boolean has_password;


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getIm_token() {
    return im_token;
  }

  public void setIm_token(String im_token) {
    this.im_token = im_token;
  }

  public String getRegistration_id() {
    return registration_id;
  }

  public void setRegistration_id(String registration_id) {
    this.registration_id = registration_id;
  }

  public boolean isHas_password() {
    return has_password;
  }

  public void setHas_password(boolean has_password) {
    this.has_password = has_password;
  }


  public String getWechat_id() {
    return wechat_id;
  }

  public void setWechat_id(String wechat_id) {
    this.wechat_id = wechat_id;
  }

  public String getAlipay_id() {
    return alipay_id;
  }

  public void setAlipay_id(String alipay_id) {
    this.alipay_id = alipay_id;
  }

  public boolean isHas_pay_password() {
    return has_pay_password;
  }

  public void setHas_pay_password(boolean has_pay_password) {
    this.has_pay_password = has_pay_password;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getMobile() {
    return mobile;
  }

  public void setMobile(String mobile) {
    this.mobile = mobile;
  }

  public String getNickname() {
    return nickname;
  }

  public void setNickname(String nickname) {
    this.nickname = nickname;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getAvatar() {
    return avatar;
  }

  public void setAvatar(String avatar) {
    this.avatar = avatar;
  }

  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }

  public long getBirthday() {
    return birthday;
  }

  public void setBirthday(long birthday) {
    this.birthday = birthday;
  }

  public int getGender() {
    return gender;
  }

  public void setGender(int gender) {
    this.gender = gender;
  }

  public String getRemark() {
    return remark;
  }

  public void setRemark(String remark) {
    this.remark = remark;
  }

  public double getBalance() {
    return balance;
  }

  public void setBalance(double balance) {
    this.balance = balance;
  }

  public int getCredits() {
    return credits;
  }

  public void setCredits(int credits) {
    this.credits = credits;
  }

  public String getToken() {
    return token;
  }

  public void setToken(String token) {
    this.token = token;
  }


  @Override public String name() {
    if (!Strings.isNullOrEmpty(nickname)) {
      return nickname;
    }
    return "";
  }

  @Override public String token() {
    if (!Strings.isNullOrEmpty(token)) {
      return token;
    }
    return "";
  }

  @Override public String toJson() {
    return null;
  }


}
