package com.amijiaoyu.babybus.android.ui

import android.app.Activity
import com.amijiaoyu.babybus.android.base.rootKotlin.KotlinRxActivityPresenter
import com.amijiaoyu.babybus.android.di.helper.LoginHelper
import com.amijiaoyu.babybus.android.model.bean.LoginOkBean
import com.amijiaoyu.babybus.android.model.rx.ProgressDialogSubscriber
import com.amijiaoyu.babybus.android.utils.RxUtil
import javax.inject.Inject

/**
 * @author Dsh  on 2018/3/15.
 */
class KotlinPresenter @Inject constructor(private val loginHelper: LoginHelper?) : KotlinRxActivityPresenter<KotlinConstance.View>(), KotlinConstance.Presenter {

    override fun login(account: String, password: String) {
        addSubscribe(loginHelper!!.loginApi.Login(account, password)
            .compose(RxUtil.rxSchedulerHelper())
            .subscribeWith(object : ProgressDialogSubscriber<LoginOkBean>(mView as Activity) {
                override fun onNext(t: LoginOkBean?) {
                    mView?.loginSucceed(t!!)
                }

                override fun onError(e: Throwable?) {
                    super.onError(e)
                    mView?.loginField("失败了")
                }

            })
        )
    }
}