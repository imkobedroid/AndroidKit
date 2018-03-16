package com.amijiaoyu.babybus.android.base.rootKotlin

/**
 * @author Dsh toushihiroshi on 2018/3/15.
 */


interface KotlinBaseActivityPresenter<out T : KotlinBaseActivityView> {
    /**
     * 界面与presenter的连接
     * @param view
     */
    fun attachView(view: @UnsafeVariance T)

    /**
     * 断开界面与presenter的连接
     */
    fun detachView()
}