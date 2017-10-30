package com.amijiaoyu.babybus.android.ui;

import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleOwner;
import android.util.Log;
import com.amijiaoyu.babybus.android.base.root.BaseLifecycleListener;
import javax.inject.Inject;

/**
 * Date:2017/10/20 11:24
 * Email:imkobedroid@gmail.com
 * @author dongshihong
 */


public class LifecycleTest extends BaseLifecycleListener {

  @Inject public LifecycleTest(){

  }

  @Override public void resume(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
    Log.v("测试","resume");
  }

  @Override public void pause(LifecycleOwner lifecycleOwner) {
    Log.v("测试","pause");

  }

  @Override public void create(LifecycleOwner lifecycleOwner) {
    Log.v("测试","create");

  }

  @Override public void stop(LifecycleOwner lifecycleOwner) {
    Log.v("测试","stop");

  }

  @Override public void destroy(LifecycleOwner lifecycleOwner) {
    Log.v("测试","destroy");

  }

  @Override public void start(LifecycleOwner lifecycleOwner) {
    Log.v("测试","start");

  }
}
