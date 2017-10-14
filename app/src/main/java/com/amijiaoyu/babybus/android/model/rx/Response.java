package com.amijiaoyu.babybus.android.model.rx;

import com.amijiaoyu.babybus.android.model.bean.BaseBean;
import io.reactivex.Flowable;
import org.reactivestreams.Subscriber;

/**
 * Author:SHIHONG DONG
 * Date:2017/10/14 10:16
 * Email:imkobedroid@gmail.com
 */

public class Response<T extends BaseBean>  extends Flowable<T> {
  @Override protected void subscribeActual(Subscriber s) {

  }
}
