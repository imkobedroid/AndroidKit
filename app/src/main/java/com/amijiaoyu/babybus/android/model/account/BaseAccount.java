package com.amijiaoyu.babybus.android.model.account;

import java.io.Serializable;

/**
 *
 * @author Dsh
 * @date 2017/5/5
 * Use:
 */

public interface BaseAccount extends Serializable {
  /**
   * 用户名
   */
  String name();

  /**
   * 登录的token
   */

  String token();

  /**
   * json转换器
   * @return
   */
  String toJson();

}
