package com.amijiaoyu.babybus.android.ui;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import java.util.ArrayList;
import java.util.List;

/**
 * Date:2017/10/16 14:56
 * Email:imkobedroid@gmail.com
 *
 * @author dongshihong
 */

public class HomeFragmentAdapter extends FragmentPagerAdapter {
  private List<Fragment> fragmentList;

  public HomeFragmentAdapter(FragmentManager fm, List<Fragment> fragmentList) {
    super(fm);
    this.fragmentList = new ArrayList<>();
    this.fragmentList.addAll(fragmentList);
  }

  @Override public Fragment getItem(int position) {
    return fragmentList.get(position);
  }

  @Override public int getCount() {
    return fragmentList.size();
  }
}
