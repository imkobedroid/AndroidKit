package com.example.dongshihong.androidkit.di.component;

import android.app.Activity;
import com.example.dongshihong.androidkit.di.module.ActivityModule;
import com.example.dongshihong.androidkit.di.scope.ActivityScope;
import dagger.Component;

/**
 * @author keal
 *         Created  on 2017/05/03 11:56.
 *         Summary:
 */

@ActivityScope @Component(dependencies = AppComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {

  Activity getActivity();

}
