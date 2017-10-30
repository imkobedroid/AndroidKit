package com.amijiaoyu.babybus.android.base.root;

import android.arch.lifecycle.LifecycleActivity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import javax.inject.Inject;

/**
 * Date:2017/9/25 11:37
 * Email:imkobedroid@gmail.com
 *
 * @author dongshihong
 */
public abstract class BaseActivity extends AppCompatActivity{

  private Unbinder mUnBinder;

  @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(getLayout());
    mUnBinder = ButterKnife.bind(this);
  }

  @Override protected void onDestroy() {
    super.onDestroy();
    mUnBinder.unbind();
  }
  protected abstract int getLayout();

}
