package com.amijiaoyu.babybus.android.base.root;

import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleObserver;
import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.OnLifecycleEvent;
import android.util.Log;
import javax.inject.Inject;

/**
 * Date:2017/10/20 10:10
 * Email:imkobedroid@gmail.com
 *
 * @author dongshihong
 */

public class BaseLifecycleListener implements LifecycleObserver {
  @Inject public BaseLifecycleListener(){
  }

  @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
  public void resume(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
    Log.v("测试","1");
  }



  @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE) public void pause(LifecycleOwner lifecycleOwner) {
    Log.v("测试","2");

  }



  @OnLifecycleEvent(Lifecycle.Event.ON_CREATE) public void create(LifecycleOwner lifecycleOwner) {
    Log.v("测试","3");

  }



  @OnLifecycleEvent(Lifecycle.Event.ON_STOP) public void stop(LifecycleOwner lifecycleOwner) {
    Log.v("测试","4");

  }



  @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY) public void destroy(LifecycleOwner lifecycleOwner) {
    Log.v("测试","5");

  }



  @OnLifecycleEvent(Lifecycle.Event.ON_START) public void start(LifecycleOwner lifecycleOwner) {
    Log.v("测试","6");

  }


}

