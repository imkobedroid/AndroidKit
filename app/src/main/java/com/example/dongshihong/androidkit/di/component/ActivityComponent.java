package com.example.dongshihong.androidkit.di.component;

import android.app.Activity;
import com.example.dongshihong.androidkit.di.module.ActivityModule;
import com.example.dongshihong.androidkit.di.assist.ActivityScope;
import dagger.Component;

/**
 * Author:Dsh
 * Date:2017/9/25 11:37
 * Email:imkobedroid@gmail.com
 */

@ActivityScope @Component(dependencies = AppComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {

  Activity getActivity();

}
