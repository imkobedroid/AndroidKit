package com.amijiaoyu.babybus.android.di.component;

import android.app.Activity;
import com.amijiaoyu.babybus.android.di.assist.ActivityScope;
import com.amijiaoyu.babybus.android.di.module.ActivityModule;

import dagger.Component;

/**
 * Date:2017/9/25 11:37
 * Email:imkobedroid@gmail.com
 *
 * @author dongshihong
 */

@ActivityScope @Component(dependencies = AppComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {

  // TODO: 2017/10/10 注册界面

  /**
   * 注册的登录界面接口
   */
  Activity getActivity();

  /**
   * 注册的登录界面接口
   */

}
