package com.amijiaoyu.babybus.android.ui;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.MenuItem;
import butterknife.BindView;
import com.amijiaoyu.babybus.android.R;
import com.amijiaoyu.babybus.android.base.RxActivity;
import java.util.ArrayList;
import java.util.List;

/**
 * Date:2017/10/16 14:00
 * Email:imkobedroid@gmail.com
 *
 * @author dongshihong
 */

public class HomeActivity extends RxActivity
    implements BottomNavigationView.OnNavigationItemSelectedListener {
  @BindView(R.id.view_pager) ViewPager viewPager;
  @BindView(R.id.navigation) BottomNavigationView navigationView;
  private HomeFragmentAdapter pagerAdapter;
  private List<Fragment> fragmentList;

  @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    initView();
  }

  private void initView() {
    navigationView.setOnNavigationItemSelectedListener(this);
    fragmentList = new ArrayList<>();
    fragmentList.add(new HomeFragment());
    fragmentList.add(new HomeTestFragment());
    fragmentList.add(new HomeFragment());
    fragmentList.add(new HomeTestFragment());
    BottomNavigationViewHelper.disableShiftMode(navigationView);
    pagerAdapter = new HomeFragmentAdapter(getSupportFragmentManager(), fragmentList);
    viewPager.setAdapter(pagerAdapter);
  }

  @Override protected int getLayout() {
    return R.layout.activity_home;
  }

  @Override protected void initInject() {
  }

  @Override public boolean onNavigationItemSelected(@NonNull MenuItem item) {
    switch (item.getItemId()) {

    }
    return true;
  }
}
