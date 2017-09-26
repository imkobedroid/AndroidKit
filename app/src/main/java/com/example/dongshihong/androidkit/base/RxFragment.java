package com.example.dongshihong.androidkit.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import com.example.dongshihong.androidkit.app.App;
import com.example.dongshihong.androidkit.base.root.BaseFragment;
import com.example.dongshihong.androidkit.base.root.BasePresenter;
import com.example.dongshihong.androidkit.di.component.DaggerFragmentComponent;
import com.example.dongshihong.androidkit.di.component.FragmentComponent;
import com.example.dongshihong.androidkit.di.module.FragmentModule;
import javax.inject.Inject;

/**
 * Author:SHIHONG DONG
 * Date:2017/9/25 11:37
 * Email:imkobedroid@gmail.com
 */
public abstract class RxFragment<T extends BasePresenter> extends BaseFragment {

  @Inject protected T mPresenter;

  protected FragmentComponent getFragmentComponent() {
    return DaggerFragmentComponent.builder()
        .appComponent(App.getAppComponent())
        .fragmentModule(getFragmentModule())
        .build();
  }

  protected FragmentModule getFragmentModule() {
    return new FragmentModule(this);
  }

  @Override public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
    initInject();
    super.onViewCreated(view, savedInstanceState);
  }

  @Override public void onDestroyView() {
    if (mPresenter != null) mPresenter.detachView();
    super.onDestroyView();
  }

  protected abstract void initInject();
}