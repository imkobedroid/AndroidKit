package com.example.dongshihong.androidkit.model.rx;

/**
 * @author keal
 *         Created  on 2017/05/18 16:06.
 *         Summary:
 */
public class Message {

  /**
   * message : Success
   * status_code : 200
   */

  private String message;
  private int status_code;

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public int getStatus_code() {
    return status_code;
  }

  public void setStatus_code(int status_code) {
    this.status_code = status_code;
  }
}
