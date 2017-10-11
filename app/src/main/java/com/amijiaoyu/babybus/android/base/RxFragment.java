package com.amijiaoyu.babybus.android.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import com.amijiaoyu.babybus.android.app.App;
import com.amijiaoyu.babybus.android.base.root.BaseFragment;
import com.amijiaoyu.babybus.android.base.root.BaseFragmentPresenter;
import com.amijiaoyu.babybus.android.base.root.BaseFragmentView;
import com.amijiaoyu.babybus.android.di.component.DaggerFragmentComponent;
import com.amijiaoyu.babybus.android.di.component.FragmentComponent;
import com.amijiaoyu.babybus.android.di.module.FragmentModule;
import javax.inject.Inject;

/**
 * Author:Dsh
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
  @SuppressWarnings("unchecked")
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