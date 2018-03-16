package com.amijiaoyu.babybus.android.app;

import android.support.multidex.MultiDexApplication;
import android.support.v7.app.AppCompatDelegate;
import com.amijiaoyu.babybus.android.di.component.AppComponent;
import com.amijiaoyu.babybus.android.di.component.DaggerAppComponent;
import com.amijiaoyu.babybus.android.di.module.AppModule;
import com.amijiaoyu.babybus.android.di.module.HttpModule;
import com.orhanobut.logger.Logger;

/**
 * @author toushihiroshi
 */
public class App extends MultiDexApplication {

  public static App instance;
  public static AppComponent appComponent;

  static {
    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
  }

  @Override public void onCreate() {
    super.onCreate();
    instance = this;
    Logger.init(getPackageName()).hideThreadInfo();
  }

  public static AppComponent getAppComponent() {
    if (appComponent == null) {
      appComponent = DaggerAppComponent.builder()
          .appModule(new AppModule(instance))
          .httpModule(new HttpModule())
          .build();
    }
    return appComponent;
  }
}
