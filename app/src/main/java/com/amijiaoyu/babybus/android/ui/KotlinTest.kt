package com.amijiaoyu.babybus.android.ui

import android.app.Activity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import com.amijiaoyu.babybus.android.R
import com.amijiaoyu.babybus.android.base.RxActivity
import com.amijiaoyu.babybus.android.di.module.UserBean
import com.amijiaoyu.babybus.android.utils.SnackbarUtil

/**
 *  Author:Dsh
 *  Date:2017/10/17 15:16
 *  Email:imkobedroid@gmail.com
 */

class KotlinTest : Activity() {

  private lateinit var account: EditText
  private lateinit var passWord: EditText
  private lateinit var login: Button
  private lateinit var requestBean: RequestBean
  private lateinit var root: LinearLayout
  private lateinit var userBean: UserBean


  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_login)
    userLogin("", "")
  }


  fun getLayout(): Int {
    return R.layout.activity_login
  }

  fun initInject() {
    //activityComponent.inject(this)
  }

  private fun userLogin(account: String, password: String) {
    requestBean.username = account
    requestBean.password = password
    userBean.phone = "15608073947"
    getUserInfoSucceed(userBean)
    // mPresenter.login(requestBean)
  }


  private fun getUserInfoSucceed(userBean: UserBean?) {
    if (userBean != null) {
      SnackbarUtil.show(root, userBean.phone)
    }
  }


}