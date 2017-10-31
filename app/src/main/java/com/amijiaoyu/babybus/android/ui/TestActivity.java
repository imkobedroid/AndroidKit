package com.amijiaoyu.babybus.android.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import com.amijiaoyu.babybus.android.R;

/**
 * Author:SHIHONG DONG
 * Date:2017/10/31 11:57
 * Email:imkobedroid@gmail.com
 */

public class TestActivity extends AppCompatActivity {
  @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_login);
    getLifecycle().addObserver(new MyListener(this));
  }
}
