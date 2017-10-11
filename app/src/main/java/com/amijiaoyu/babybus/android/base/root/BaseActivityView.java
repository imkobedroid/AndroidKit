package com.amijiaoyu.babybus.android.base.root;

import android.support.v7.widget.Toolbar;
import android.widget.TextView;
import com.amijiaoyu.babybus.android.di.component.ActivityComponent;

/**
 * Author:Dsh
 * Date:2017/9/25 11:37
 * Email:imkobedroid@gmail.com
 */
public interface BaseActivityView {
  void initToolBar(Toolbar toolbar, TextView mTvToolbar, String title);

  void InjectActivity();

  ActivityComponent getActivityComponent();
}
