package com.amijiaoyu.babybus.android.ui

import com.amijiaoyu.babybus.android.base.rootKotlin.KotlinBaseActivityPresenter
import com.amijiaoyu.babybus.android.base.rootKotlin.KotlinBaseActivityView
import com.amijiaoyu.babybus.android.model.bean.LoginOkBean

/**
 * @author Dsh toushihiroshi on 2018/3/15.
 */
interface KotlinConstance {

    interface View : KotlinBaseActivityView {
        fun loginSucceed(loginBean: LoginOkBean)
        fun loginField(message: String)
    }


    interface Presenter : KotlinBaseActivityPresenter<View> {
        fun login(account: String, password: String)
    }

}