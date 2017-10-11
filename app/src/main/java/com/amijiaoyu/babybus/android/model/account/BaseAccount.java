package com.amijiaoyu.babybus.android.model.account;

import java.io.Serializable;

/**
 * Created by Dsh on 2017/5/5.
 * Use:
 */

public interface BaseAccount extends Serializable {
  String name();

  String token();

  String toJson();

}
