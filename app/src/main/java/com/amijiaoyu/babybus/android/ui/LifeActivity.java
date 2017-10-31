package com.amijiaoyu.babybus.android.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import com.amijiaoyu.babybus.android.R;
import com.amijiaoyu.babybus.android.base.root.BaseLifecycleListener;
import javax.inject.Inject;

/**
 * Date:2017/10/20 15:51
 * Email:imkobedroid@gmail.com
 * @author dongshihong
 */

public class LifeActivity extends AppCompatActivity {

  @Inject BaseLifecycleListener baseLifecycleListener;
  @Override
  protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_login);
    DaggerLifeComponent.create().inject(this);
    Log.v("dagger",baseLifecycleListener.toString());
  }

}
