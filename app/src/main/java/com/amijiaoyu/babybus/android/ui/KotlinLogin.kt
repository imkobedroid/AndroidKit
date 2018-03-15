package com.amijiaoyu.babybus.android.ui

import com.amijiaoyu.babybus.android.base.rootKotlin.KotlinRxActivity
import com.amijiaoyu.babybus.android.model.bean.LoginOkBean

/**
 * @author Dsh toushihiroshi on 2018/3/15.
 */
class KotlinLogin: KotlinRxActivity<KotlinPresenter>(),KotlinConstance.View {

    override fun loginSucceed(loginBean: LoginOkBean) {
    }

    override fun loginField(message: String) {
    }

    override fun getLayoutId(): Int {
        return 0
    }

    override fun initInject() {
    }

}