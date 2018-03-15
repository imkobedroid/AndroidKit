package com.amijiaoyu.babybus.android.base.RxRoot

import android.os.Bundle
import android.support.v7.widget.Toolbar
import android.widget.TextView
import com.amijiaoyu.babybus.android.R
import com.amijiaoyu.babybus.android.app.App
import com.amijiaoyu.babybus.android.base.root.BaseActivityView
import com.amijiaoyu.babybus.android.base.rootKotlin.KotlinBaseActivity
import com.amijiaoyu.babybus.android.base.rootKotlin.KotlinBaseActivityPresenter
import com.amijiaoyu.babybus.android.di.component.ActivityComponent
import com.amijiaoyu.babybus.android.di.component.DaggerActivityComponent
import com.amijiaoyu.babybus.android.di.module.ActivityModule
import javax.inject.Inject

/**
 * @author Dsh on 2018/3/14.
 */


abstract class KotlinRxActivity<T:KotlinBaseActivityPresenter<BaseActivityView>> : KotlinBaseActivity(), BaseActivityView {

    @Inject
    @JvmField
    var mPresenter: T? = null


    companion object {
        private val TITLE = ""
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        injectActivity()
    }

    override fun initToolBar(toolbar: Toolbar?, mTvToolbar: TextView?, title: String?) {
        toolbar?.title = KotlinRxActivity.TITLE
        mTvToolbar?.text = title
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        toolbar?.setNavigationIcon(R.mipmap.ic_arrow_back_white_24dp)
        toolbar?.setNavigationOnClickListener { finish() }
    }


    override fun injectActivity() {
        initInject()
        mPresenter?.attachView(this)
    }


    override fun getActivityComponent(): ActivityComponent {
        return DaggerActivityComponent.builder().activityModule(ActivityModule(this))
            .appComponent(App.getAppComponent()).build()
    }


    override fun onDestroy() {
        mPresenter?.detachView()
        super.onDestroy()
    }


    /**
     * 注册dagger界面
     */
    abstract fun initInject()

}