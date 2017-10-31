package com.amijiaoyu.babybus.android.di.component;

import com.amijiaoyu.babybus.android.app.App;
import com.amijiaoyu.babybus.android.di.helper.LoginHelper;
import com.amijiaoyu.babybus.android.di.module.AppModule;
import com.amijiaoyu.babybus.android.di.module.HttpModule;
import dagger.Component;
import javax.inject.Singleton;

/**
 * Date:2017/9/25 11:37
 * Email:imkobedroid@gmail.com
 * @author dongshihong
 */

@Singleton @Component(modules = { AppModule.class, HttpModule.class })
public interface AppComponent {

  // TODO: 2017/10/10 把帮助类提供出来

  /**
   * 提供一个上下文
   * @return  返回需要的上下文对象
   */
  App getContext();

  /**
   * 得到各种帮助类
   * @return  返回一个包含了retrofit的帮助类
   */
  LoginHelper provideLoginHelper();
}
