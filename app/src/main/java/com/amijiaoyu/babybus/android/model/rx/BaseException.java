package com.amijiaoyu.babybus.android.model.rx;

public class BaseException extends Exception {

  /*API错误*/
  public static final int API_ERROR = 0x0;

  /*http_错误*/
  public static final int HTTP_ERROR = 0x2;

  /*json错误*/
  public static final int JSON_ERROR = 0x3;

  /*未知错误*/
  public static final int UNKNOWN_ERROR = 0x4;

  /*无法解析该域名*/
  public static final int UNKOWNHOST_ERROR = 0x6;

  /*连接网络超时*/
  public static final int SOCKET_TIMEOUT_ERROR = 0x7;

  /*无网络连接*/
  public static final int SOCKET_ERROR = 0x8;

  // 服务器错误
  public static final int ERROR_API_SYSTEM = 10000;

  // 解析错误
  public static final int ERROR_TRANSFORMER = 10001;

  // http
  public static final int ERROR_HTTP_400 = 400;

  public static final int ERROR_HTTP_404 = 404;

  public static final int ERROR_HTTP_405 = 402;

  public static final int ERROR_HTTP_500 = 500;

  public int code;

  public String displayMessage;

  public BaseException() {
  }

  public BaseException(int code, String displayMessage) {
    this.code = code;
    this.displayMessage = displayMessage;
  }

  public BaseException(String message, int code, String displayMessage) {
    super(message);
    this.code = code;
    this.displayMessage = displayMessage;
  }

  public int getCode() {
    return code;
  }

  public void setCode(int code) {
    this.code = code;
  }

  public String getDisplayMessage() {
    return displayMessage;
  }

  public void setDisplayMessage(String displayMessage) {
    this.displayMessage = displayMessage;
  }
}
