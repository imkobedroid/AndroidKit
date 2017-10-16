package com.amijiaoyu.babybus.android.di.component;

import com.amijiaoyu.babybus.android.app.App;
import com.amijiaoyu.babybus.android.di.helper.LoginHelper;
import com.amijiaoyu.babybus.android.di.module.AppModule;
import com.amijiaoyu.babybus.android.di.module.HttpModule;
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

  /**
   * 把上下文提供出来
   */
  App getContext();

  /**
   * 把帮助类提供出来
   */
  LoginHelper provideLoginHelper();
}
