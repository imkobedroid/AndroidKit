package com.example.dongshihong.androidkit.di.module;

import android.app.Activity;
import com.example.dongshihong.androidkit.di.scope.ActivityScope;
import dagger.Module;
import dagger.Provides;

/**
 * @author keal
 *         Created  on 2017/05/03 11:56.
 *         Summary:
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
