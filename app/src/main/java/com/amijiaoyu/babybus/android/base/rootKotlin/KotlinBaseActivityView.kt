package com.amijiaoyu.babybus.android.base.rootKotlin

import android.support.v7.widget.Toolbar
import android.widget.TextView
import com.amijiaoyu.babybus.android.di.component.ActivityComponent

/**
 * @author Dsh toushihiroshi on 2018/3/15.
 */

interface KotlinBaseActivityView{


    fun initToolbar(toolBar:Toolbar?,content:TextView?,title: String?)


    /**
     * 注册界面的接口
     */

    fun injectActivity()

    /**
     * 提供dagger2的中间连接桥梁
     */

    fun getActivityComponent():ActivityComponent
}