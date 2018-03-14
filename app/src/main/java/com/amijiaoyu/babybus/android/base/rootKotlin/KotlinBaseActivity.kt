package com.amijiaoyu.babybus.android.base.rootKotlin

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import butterknife.ButterKnife
import butterknife.Unbinder
import javax.inject.Inject

/**
 * @author Dsh on 2018/3/14.
 */


abstract class KotlinBaseActivity : AppCompatActivity() {

    private var unbinds: Unbinder? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayoutId())
        unbinds = ButterKnife.bind(this)
    }


    override fun onDestroy() {
        super.onDestroy()
        unbinds?.unbind()
    }

    /**
     * 获取布局文件
     */
    abstract fun getLayoutId(): Int
}