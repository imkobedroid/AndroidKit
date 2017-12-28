package com.amijiaoyu.babybus.android.ui

import com.amijiaoyu.babybus.android.R
import com.amijiaoyu.babybus.android.base.RxActivity

/**
 *  Author:SHIHONG DONG
 *  Date:2017/10/31 11:33
 *  Email:imkobedroid@gmail.com
 */
class LifecyActivityTest : RxActivity<LoginPresenter, MyListener>() {
  override fun addLifeActivity() {
    lifecycle.addObserver(baseLifecycleListener)
  }

  override fun getLayout(): Int {
    return R.layout.activity_login
  }

  override fun initInject() {
    activityComponent.inject(this)
  }



}