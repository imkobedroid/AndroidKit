package com.amijiaoyu.babybus.android.base.root;

import com.amijiaoyu.babybus.android.di.component.FragmentComponent;

/**
 * Author:Dsh
 * Date:2017/9/26 10:16
 * Email:imkobedroid@gmail.com
 */

public interface BaseFragmentView {
  void InjectFragment();

  FragmentComponent getFragmentComponent();
}
