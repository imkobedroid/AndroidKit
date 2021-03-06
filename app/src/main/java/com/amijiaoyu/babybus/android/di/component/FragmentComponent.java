package com.amijiaoyu.babybus.android.di.component;

import android.app.Activity;
import com.amijiaoyu.babybus.android.di.assist.FragmentScope;
import com.amijiaoyu.babybus.android.di.module.FragmentModule;
import dagger.Component;

/**
 * Author:Dsh
 * Date:2017/9/25 11:37
 * Email:imkobedroid@gmail.com
 */

@FragmentScope @Component(dependencies = AppComponent.class, modules = FragmentModule.class)
public interface FragmentComponent {
  /**
   * 获得内上下文对象
   */
  Activity getActivity();

}
