package com.example.dongshihong.androidkit.di.module;

import android.app.Activity;
import com.example.dongshihong.androidkit.di.assist.ActivityScope;
import dagger.Module;
import dagger.Provides;

/**
 * Author:SHIHONG DONG
 * Date:2017/9/25 11:37
 * Email:imkobedroid@gmail.com
 */

@Module public class ActivityModule {
  private Activity mActivity;

  public ActivityModule(Activity activity) {
    this.mActivity = activity;
  }

  @Provides @ActivityScope public Activity provideActivity() {
    return mActivity;
  }
}
