package com.amijiaoyu.babybus.android.di.module;

import android.app.Activity;
import com.amijiaoyu.babybus.android.di.assist.ActivityScope;
import dagger.Module;
import dagger.Provides;

/**
 * Author:Dsh
 * Date:2017/9/25 11:37
 * Email:imkobedroid@gmail.com
 * @author moerlong
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
