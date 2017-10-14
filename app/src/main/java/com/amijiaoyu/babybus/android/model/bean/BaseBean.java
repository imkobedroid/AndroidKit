package com.amijiaoyu.babybus.android.model.bean;

/**
 * Author:Dsh
 * Date:2017/10/13 16:56
 * Email:imkobedroid@gmail.com
 */

public class BaseBean<T> {

  private String message;
  private int code;
  private T data;

  public T getData() {
    return data;
  }

  public void setData(T data) {
    this.data = data;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public int getCode() {
    return code;
  }

  public void setCode(int code) {
    this.code = code;
  }
}
