package com.amijiaoyu.babybus.android.base.root;

import android.support.v7.widget.Toolbar;
import android.widget.TextView;
import com.amijiaoyu.babybus.android.di.component.ActivityComponent;

/**
 * Date:2017/9/25 11:37
 * Email:imkobedroid@gmail.com
 * @author dongshihong
 */
public interface BaseActivityView {
  /**
   * 初始化toolbar
   */
  void initToolBar(Toolbar toolbar, TextView mTvToolbar, String title);

  /**
   * 注册界面的接口
   */
  void InjectActivity();

  /**
   * 提供dagger2的中间连接桥梁
   */
  ActivityComponent getActivityComponent();
}
