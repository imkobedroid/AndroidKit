package com.example.dongshihong.androidkit.base.root;

import android.support.v7.widget.Toolbar;
import android.widget.TextView;
import com.example.dongshihong.androidkit.di.component.ActivityComponent;

/**
 * Author:SHIHONG DONG
 * Date:2017/9/25 11:37
 * Email:imkobedroid@gmail.com
 */
public interface BaseActivityView {
  void initToolBar(Toolbar toolbar, TextView mTvToolbar, String title);

  void InjectActivity();

  ActivityComponent getActivityComponent();
}
