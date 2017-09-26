package com.example.dongshihong.androidkit.base;

import com.example.dongshihong.androidkit.app.App;
import com.example.dongshihong.androidkit.base.root.BaseActivity;
import com.example.dongshihong.androidkit.base.root.BasePresenter;
import com.example.dongshihong.androidkit.base.root.BaseView;
import com.example.dongshihong.androidkit.di.component.ActivityComponent;
import com.example.dongshihong.androidkit.di.component.DaggerActivityComponent;
import com.example.dongshihong.androidkit.di.module.ActivityModule;
import javax.inject.Inject;

/**
 * Author:SHIHONG DONG
 * Date:2017/9/25 11:37
 * Email:imkobedroid@gmail.com
 */
public abstract class RxActivity<T extends BasePresenter> extends BaseActivity
    implements BaseView {

  @Inject protected T mPresenter;

  protected ActivityComponent getActivityComponent() {
    return DaggerActivityComponent.builder()
        .appComponent(App.getAppComponent())
        .activityModule(getActivityModule())
        .build();
  }

  protected ActivityModule getActivityModule() {
    return new ActivityModule(this);
  }

  @Override protected void onViewCreated() {
    super.onViewCreated();
    initInject();
    if (mPresenter != null) mPresenter.attachView(this);
  }

  @Override protected void onDestroy() {
    if (mPresenter != null) mPresenter.detachView();
    super.onDestroy();
  }

  protected abstract void initInject();
}