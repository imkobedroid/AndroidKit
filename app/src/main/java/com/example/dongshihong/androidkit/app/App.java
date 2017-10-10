package com.example.dongshihong.androidkit.app;

import android.app.Application;
import android.support.v7.app.AppCompatDelegate;
import com.example.dongshihong.androidkit.di.component.AppComponent;
import com.example.dongshihong.androidkit.di.component.DaggerAppComponent;
import com.example.dongshihong.androidkit.di.module.AppModule;
import com.example.dongshihong.androidkit.di.module.HttpModule;
import com.orhanobut.logger.Logger;

public class App extends Application {

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
