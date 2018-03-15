package com.amijiaoyu.babybus.android.base.rootKotlin

import com.amijiaoyu.babybus.android.base.root.BaseActivityView

/**
 * @author Dsh toushihiroshi on 2018/3/15.
 */


interface KotlinBaseActivityPresenter< in T:BaseActivityView>{
    /**
     * 界面与presenter的连接
     * @param view
     */
     fun attachView(view: T)

    /**
     * 断开界面与presenter的连接
     */
    fun detachView()
}