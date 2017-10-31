package com.amijiaoyu.babybus.android.ui

import android.os.Bundle
import com.amijiaoyu.babybus.android.R.layout.mylayout
import com.amijiaoyu.babybus.android.base.RxActivity
import kotlinx.android.synthetic.main.mylayout.*

/**
 *  Author:Dsh
 *  Date:2017/10/25 10:19
 *  Email:imkobedroid@gmail.com
 */


class MyActivity : RxActivity<LoginPresenter, LifecycleTest>() {
  override fun addLifeActivity() {
  }

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    initView()
  }

  private fun initView() {
    name.text = "dongshihong"
    age.text = "20"
  }

  override fun getLayout(): Int {
    return mylayout
  }

  override fun initInject() {
    activityComponent.inject(this)
  }

}