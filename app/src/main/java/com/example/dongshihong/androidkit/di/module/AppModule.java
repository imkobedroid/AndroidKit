package com.example.dongshihong.androidkit.di.module;

import android.content.Context;
import com.example.dongshihong.androidkit.app.App;
import dagger.Module;
import dagger.Provides;
import javax.inject.Singleton;

/**
 * Author:SHIHONG DONG
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

  /**
   * 下面是提供模块的retrofit的帮助类
   */

   /* @Provides
    @Singleton
    RetrofitHelper provideHttpHelper(LoginApi loginApi, ZhihuApis zhihuApis,
                                     SiteApi mSiteApi, WithdrawApi withdrawApi,DataStatisticsApi dataStatisticsApi) {
        return new RetrofitHelper(zhihuApis, loginApi, mSiteApi,withdrawApi,dataStatisticsApi);
    }*/
}
