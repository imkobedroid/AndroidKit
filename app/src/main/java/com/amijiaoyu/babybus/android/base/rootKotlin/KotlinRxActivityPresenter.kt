package com.amijiaoyu.babybus.android.base.rootKotlin

import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

/**
 * @author Dsh  on 2018/3/15.
 */
open class KotlinRxActivityPresenter<T : KotlinBaseActivityView> : KotlinBaseActivityPresenter<T> {


    var mView: T? = null

    private var compositeDisposable: CompositeDisposable? = null

    private fun unSubscribe() = compositeDisposable?.dispose()


    fun addSubscribe(subscriber: Disposable) {
        if (compositeDisposable == null) {
            compositeDisposable = CompositeDisposable()
        }
        compositeDisposable!!.add(subscriber)
    }


    override fun detachView() {
        if (mView != null) unSubscribe()
    }

    override fun attachView(view: T) {
        mView = view
    }
}