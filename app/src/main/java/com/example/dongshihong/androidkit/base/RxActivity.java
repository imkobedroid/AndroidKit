package com.example.dongshihong.androidkit.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;
import com.example.dongshihong.androidkit.R;
import com.example.dongshihong.androidkit.app.App;
import com.example.dongshihong.androidkit.base.root.BaseActivity;
import com.example.dongshihong.androidkit.base.root.BaseActivityPresenter;
import com.example.dongshihong.androidkit.base.root.BaseActivityView;
import com.example.dongshihong.androidkit.di.component.ActivityComponent;
import com.example.dongshihong.androidkit.di.component.DaggerActivityComponent;
import com.example.dongshihong.androidkit.di.module.ActivityModule;
import javax.inject.Inject;

/**
 * Author:Dsh
 * Date:2017/9/25 11:37
 * Email:imkobedroid@gmail.com
 */
public abstract class RxActivity<T extends BaseActivityPresenter> extends BaseActivity
    implements BaseActivityView {

  @Inject protected T mPresenter;

  @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    InjectActivity();
  }

  @Override public ActivityComponent getActivityComponent() {
    return DaggerActivityComponent.builder()
        .appComponent(App.getAppComponent())
        .activityModule(new ActivityModule(this))
        .build();
  }

  @SuppressWarnings("unchecked") @Override public void InjectActivity() {
    initInject();
    if (mPresenter != null) mPresenter.attachView(this);
  }

  @Override public void initToolBar(Toolbar toolbar, TextView mTvToolbar, String title) {
    toolbar.setTitle("");
    mTvToolbar.setText(title);
    setSupportActionBar(toolbar);
    if (getSupportActionBar() != null) {
      getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
    getSupportActionBar().setDisplayShowHomeEnabled(true);
    toolbar.setNavigationIcon(R.mipmap.ic_arrow_back_white_24dp);
    toolbar.setNavigationOnClickListener(view -> finish());
  }

  @Override protected void onDestroy() {
    if (mPresenter != null) mPresenter.detachView();
    super.onDestroy();
  }

  protected abstract void initInject();
}