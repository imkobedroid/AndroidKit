package com.amijiaoyu.babybus.android.ui

import android.os.Bundle
import android.support.constraint.ConstraintLayout
import android.widget.Button
import android.widget.EditText
import butterknife.BindView
import com.amijiaoyu.babybus.android.R
import com.amijiaoyu.babybus.android.base.RxActivity
import com.amijiaoyu.babybus.android.base.root.BaseLifecycleListener
import com.amijiaoyu.babybus.android.di.module.UserBean
import com.amijiaoyu.babybus.android.utils.RxUtil
import com.amijiaoyu.babybus.android.utils.SnackbarUtil
import work.wanghao.rxbus2.RxBus
import work.wanghao.rxbus2.Subscribe
import work.wanghao.rxbus2.ThreadMode

/**
 * Date:2017/10/10 10:00
 * Email:imkobedroid@gmail.com
 *
 * @author dongshihong
 */

class LoginActivity : RxActivity<LoginPresenter, LifecycleTest>(), LoginConstance.View {
  @BindView(R.id.account) internal var account: EditText? = null
  @BindView(R.id.password) internal var password: EditText? = null
  @BindView(R.id.login) internal var login: Button? = null
  @BindView(R.id.view_main) internal var viewMain: ConstraintLayout? = null
  @BindView(R.id.user) internal var user: Button? = null


  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    RxBus.get().register(this)
    login()
  }

  override fun onDestroy() {
    super.onDestroy()
    RxBus.get().unRegister(this)
  }

  @Subscribe(threadMode = ThreadMode.MAIN)
  fun noUser(noUser: NoUser) {
    SnackbarUtil.show(viewMain, "没有找到用户信息")
  }


  private fun login() {
    login!!.setOnClickListener { v -> RxUtil.showAlerterDialog(this, "错误", "网络超时") }
    //login.setOnClickListener(view -> mPresenter.login(new RequestBean()));
    user!!.setOnClickListener { view -> mPresenter.getUserInfo() }
  }

  override fun getLayout(): Int {
    return R.layout.activity_login
  }

  override fun initInject() {
    activityComponent.inject(this)
  }

  override fun loginSucceed(message: String) {
    SnackbarUtil.show(viewMain, message)
  }

  override fun loginField(message: String) {

  }

  override fun getUserInfoSucceed(userBean: UserBean) {
    SnackbarUtil.show(viewMain, "获取成功")
  }
}
