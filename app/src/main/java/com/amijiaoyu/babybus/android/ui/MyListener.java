package com.amijiaoyu.babybus.android.ui;

import android.app.Activity;
import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.OnLifecycleEvent;
import android.content.Context;
import android.widget.Toast;
import com.amijiaoyu.babybus.android.base.root.BaseLifecycleListener;
import javax.inject.Inject;

/**
 * Author:SHIHONG DONG
 * Date:2017/10/31 11:38
 * Email:imkobedroid@gmail.com
 */

public class MyListener extends BaseLifecycleListener {
  private Activity context;
  @Inject public  MyListener(Activity context){
    this.context=context;
  }
  @OnLifecycleEvent(Lifecycle.Event.ON_START) void start() {
  }

  @OnLifecycleEvent(Lifecycle.Event.ON_RESUME) void resume() {
    Toast.makeText(context, "resume", Toast.LENGTH_SHORT).show();
  }

  @OnLifecycleEvent(Lifecycle.Event.ON_STOP) void stop() {
  }
}
