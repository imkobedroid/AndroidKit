package com.example.dongshihong.androidkit.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import com.example.dongshihong.androidkit.app.App;
import com.example.dongshihong.androidkit.base.root.BaseFragment;
import com.example.dongshihong.androidkit.base.root.BaseFragmentPresenter;
import com.example.dongshihong.androidkit.base.root.BaseFragmentView;
import com.example.dongshihong.androidkit.di.component.DaggerFragmentComponent;
import com.example.dongshihong.androidkit.di.component.FragmentComponent;
import com.example.dongshihong.androidkit.di.module.FragmentModule;
import javax.inject.Inject;

/**
 * Author:SHIHONG DONG
 * Date:2017/9/25 11:37
 * Email:imkobedroid@gmail.com
 */
public abstract class RxFragment<T extends BaseFragmentPresenter> extends BaseFragment
    implements BaseFragmentView {

  @Inject protected T mPresenter;

  @Override public FragmentComponent getFragmentComponent() {
    return DaggerFragmentComponent.builder()
        .appComponent(App.getAppComponent())
        .fragmentModule(new FragmentModule(this))
        .build();
  }

  @Override public void InjectFragment() {
    initInject();
    if (mPresenter != null) mPresenter.attachView(this);
  }

  @Override public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);
    InjectFragment();
  }

  @Override public void onDestroyView() {
    super.onDestroyView();
    if (mPresenter != null) mPresenter.detachView();
  }

  protected abstract void initInject();
}