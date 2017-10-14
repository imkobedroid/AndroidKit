package com.amijiaoyu.babybus.android.ui;

import com.amijiaoyu.babybus.android.model.bean.BaseBean;

/**
 * Author:SHIHONG DONG
 * Date:2017/10/12 14:14
 * Email:imkobedroid@gmail.com
 */

public class UserInfoBean  {

  /**
   * id : 1
   * username : test
   * email : omueller@example.com
   * sex : 0
   * phone :
   * address :
   * real_name :
   * id_card :
   * point : 0
   * cno : 0
   * ano : 0
   * message_read_at : 2017-10-12 09:36:48
   * avatar : null
   */

  private DataBean data;

  public DataBean getData() {
    return data;
  }

  public void setData(DataBean data) {
    this.data = data;
  }

  public static class DataBean {
    private int id;
    private String username;
    private String email;
    private int sex;
    private String phone;
    private String address;
    private String real_name;
    private String id_card;
    private int point;
    private int cno;
    private int ano;
    private String message_read_at;
    private Object avatar;

    public int getId() {
      return id;
    }

    public void setId(int id) {
      this.id = id;
    }

    public String getUsername() {
      return username;
    }

    public void setUsername(String username) {
      this.username = username;
    }

    public String getEmail() {
      return email;
    }

    public void setEmail(String email) {
      this.email = email;
    }

    public int getSex() {
      return sex;
    }

    public void setSex(int sex) {
      this.sex = sex;
    }

    public String getPhone() {
      return phone;
    }

    public void setPhone(String phone) {
      this.phone = phone;
    }

    public String getAddress() {
      return address;
    }

    public void setAddress(String address) {
      this.address = address;
    }

    public String getReal_name() {
      return real_name;
    }

    public void setReal_name(String real_name) {
      this.real_name = real_name;
    }

    public String getId_card() {
      return id_card;
    }

    public void setId_card(String id_card) {
      this.id_card = id_card;
    }

    public int getPoint() {
      return point;
    }

    public void setPoint(int point) {
      this.point = point;
    }

    public int getCno() {
      return cno;
    }

    public void setCno(int cno) {
      this.cno = cno;
    }

    public int getAno() {
      return ano;
    }

    public void setAno(int ano) {
      this.ano = ano;
    }

    public String getMessage_read_at() {
      return message_read_at;
    }

    public void setMessage_read_at(String message_read_at) {
      this.message_read_at = message_read_at;
    }

    public Object getAvatar() {
      return avatar;
    }

    public void setAvatar(Object avatar) {
      this.avatar = avatar;
    }
  }
}
