package com.example.dongshihong.androidkit.base;

import com.example.dongshihong.androidkit.app.App;
import com.example.dongshihong.androidkit.di.component.ActivityComponent;
import com.example.dongshihong.androidkit.di.component.DaggerActivityComponent;
import com.example.dongshihong.androidkit.di.module.ActivityModule;
import javax.inject.Inject;

/**
 * @author keal
 *         Created  on 2017/05/03 11:56.
 *         Summary:
 */
public abstract class BaseActivity<T extends BasePresenter> extends SimpleActivity implements BaseView{

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