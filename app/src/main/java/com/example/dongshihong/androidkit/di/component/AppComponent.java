package com.example.dongshihong.androidkit.di.component;

import com.example.dongshihong.androidkit.app.App;
import com.example.dongshihong.androidkit.di.helper.LoginHelper;
import com.example.dongshihong.androidkit.di.module.AppModule;
import com.example.dongshihong.androidkit.di.module.HttpModule;
import dagger.Component;
import javax.inject.Singleton;

/**
 * Author:Dsh
 * Date:2017/9/25 11:37
 * Email:imkobedroid@gmail.com
 */

@Singleton @Component(modules = { AppModule.class, HttpModule.class })
public interface AppComponent {

  // TODO: 2017/10/10 把帮助类提供出来
  App getContext();

  LoginHelper provideLoginHelper();
}
