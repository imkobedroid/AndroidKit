package com.amijiaoyu.babybus.android.di.module;

import android.content.Context;
import com.amijiaoyu.babybus.android.app.App;
import com.amijiaoyu.babybus.android.di.helper.LoginHelper;
import dagger.Module;
import dagger.Provides;
import javax.inject.Singleton;

/**
 * Author:Dsh
 * Date:2017/9/25 11:37
 * Email:imkobedroid@gmail.com
 */

@Module public class AppModule {
  private final App application;

  public AppModule(App application) {
    this.application = application;
  }

  @Provides @Singleton App provideApplicationContext() {
    return application;
  }

  @Provides @Singleton Context getContext(App app) {
    return app.getApplicationContext();
  }

  // TODO: 2017/10/10 下面是提供模块的retrofit的帮助类

  @Provides @Singleton LoginHelper provideLoginHelper(LoginApi loginApi) {
    return new LoginHelper(loginApi);
  }

}
