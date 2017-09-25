package com.example.dongshihong.androidkit.model.rx;


/**
 * Created by Dsh on 2017/5/8.
 * Use:
 */
public class ApiException extends BaseException {

  public ApiException(int code, String displayMessage) {
    super(code, displayMessage);
  }
}
