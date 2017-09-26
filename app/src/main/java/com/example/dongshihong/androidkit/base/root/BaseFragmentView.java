package com.example.dongshihong.androidkit.base.root;

import com.example.dongshihong.androidkit.di.component.FragmentComponent;

/**
 * Author:SHIHONG DONG
 * Date:2017/9/26 10:16
 * Email:imkobedroid@gmail.com
 */

public interface BaseFragmentView {
  void InjectFragment();

  FragmentComponent getFragmentComponent();
}
