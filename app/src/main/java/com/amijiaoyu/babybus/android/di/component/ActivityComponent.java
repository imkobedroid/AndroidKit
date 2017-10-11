package com.amijiaoyu.babybus.android.di.component;

import android.app.Activity;
import com.amijiaoyu.babybus.android.di.assist.ActivityScope;
import com.amijiaoyu.babybus.android.di.module.ActivityModule;
import com.amijiaoyu.babybus.android.ui.LoginActivity;
import dagger.Component;

/**
 * Author:Dsh
 * Date:2017/9/25 11:37
 * Email:imkobedroid@gmail.com
 */

@ActivityScope @Component(dependencies = AppComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {

  // TODO: 2017/10/10 注册界面
  Activity getActivity();

  void inject(LoginActivity loginActivity);

}
