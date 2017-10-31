package com.amijiaoyu.babybus.android.base.root;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import butterknife.ButterKnife;
import butterknife.Unbinder;

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

  /**
   * 得到布局文件
   * @return 返回布局文件
   */
  protected abstract int getLayout();

}
