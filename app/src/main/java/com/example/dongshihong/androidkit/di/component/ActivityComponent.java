package com.example.dongshihong.androidkit.di.component;

import android.app.Activity;
import com.example.dongshihong.androidkit.di.module.ActivityModule;
import com.example.dongshihong.androidkit.di.assist.ActivityScope;
import com.example.dongshihong.androidkit.ui.LoginActivity;
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
