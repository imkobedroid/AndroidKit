package com.example.dongshihong.androidkit.base.root;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import com.example.dongshihong.androidkit.app.App;

/**
 * Author:Dsh
 * Date:2017/9/25 11:37
 * Email:imkobedroid@gmail.com
 */
public abstract class BaseActivity extends AppCompatActivity {

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
