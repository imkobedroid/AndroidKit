package com.amijiaoyu.babybus.android.ui

import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import android.support.v4.view.ViewPager
import android.view.MenuItem
import com.amijiaoyu.babybus.android.R
import com.amijiaoyu.babybus.android.base.RxActivity
import com.amijiaoyu.babybus.android.utils.BottomNavigationViewHelper

/**
 *  Author:Dsh
 *  Date:2017/10/19 17:27
 *  Email:imkobedroid@gmail.com
 */
class KotlinHomeActivity : RxActivity<LoginPresenter, LifecycleTest>(), BottomNavigationView.OnNavigationItemSelectedListener {
  private lateinit var viewpager: ViewPager
  private lateinit var navigation: BottomNavigationView
  private lateinit var fragmentList: List<Fragment>


  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    viewpager = findViewById(R.id.view_pager)
    navigation = findViewById(R.id.navigation)
    initView()
  }

  override fun getLayout(): Int {
    return R.layout.activity_home
  }

  override fun initInject() {
    activityComponent.inject(this)
  }

  override fun onNavigationItemSelected(item: MenuItem): Boolean {
    when (item.itemId) {
      R.id.add -> viewpager.currentItem = 0
      R.id.delete -> viewpager.currentItem = 1
      R.id.setting -> viewpager.currentItem = 2
      R.id.me -> viewpager.currentItem = 3
    }
    return true
  }

  private fun initView() {
    navigation.setOnNavigationItemSelectedListener(this)

   /* navigation.setOnNavigationItemSelectedListener {
      when (it.itemId) {
        R.id.add -> viewpager.currentItem = 0
        R.id.delete -> viewpager.currentItem = 1
        R.id.setting -> viewpager.currentItem = 2
        R.id.me -> viewpager.currentItem = 3
      }
      true
    }*/


    BottomNavigationViewHelper.disableShiftMode(navigation)
    fragmentList = listOf(HomeFragment(),
        HomeTestFragment(), HomeFragment(), HomeTestFragment())
    viewpager.adapter = PagerAdapter(supportFragmentManager, fragmentList)
  }


  class PagerAdapter(manager: FragmentManager,
      private var fragmentList: List<Fragment>) : FragmentPagerAdapter(manager) {
    override fun getItem(position: Int): Fragment {
      return fragmentList[position]
    }

    override fun getCount(): Int {
      return fragmentList.size
    }
  }
}
