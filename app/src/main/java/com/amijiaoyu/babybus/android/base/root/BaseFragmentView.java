package com.amijiaoyu.babybus.android.base.root;

import com.amijiaoyu.babybus.android.di.component.FragmentComponent;

/**
 * Date:2017/9/26 10:16
 * Email:imkobedroid@gmail.com
 * @author dongshihong
 */

public interface BaseFragmentView {

  /**
   * 注册界面
   */
  void injectFragment();

  /**
   * 得到dagger2的中间连接桥梁
   */
  FragmentComponent getFragmentComponent();
}
