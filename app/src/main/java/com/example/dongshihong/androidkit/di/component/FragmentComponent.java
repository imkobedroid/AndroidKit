package com.example.dongshihong.androidkit.di.component;

import android.app.Activity;
import com.example.dongshihong.androidkit.di.module.FragmentModule;
import com.example.dongshihong.androidkit.di.assist.FragmentScope;
import dagger.Component;

/**
 * Author:SHIHONG DONG
 * Date:2017/9/25 11:37
 * Email:imkobedroid@gmail.com
 */

@FragmentScope @Component(dependencies = AppComponent.class, modules = FragmentModule.class)
public interface FragmentComponent {
  Activity getActivity();

}
