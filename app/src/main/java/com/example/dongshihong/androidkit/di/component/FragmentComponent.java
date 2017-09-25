package com.example.dongshihong.androidkit.di.component;

import android.app.Activity;
import com.example.dongshihong.androidkit.di.module.FragmentModule;
import com.example.dongshihong.androidkit.di.scope.FragmentScope;
import dagger.Component;

/**
 * @author keal
 *         Created  on 2017/05/03 11:56.
 *         Summary:
 */

@FragmentScope @Component(dependencies = AppComponent.class, modules = FragmentModule.class)
public interface FragmentComponent {
  Activity getActivity();

}
