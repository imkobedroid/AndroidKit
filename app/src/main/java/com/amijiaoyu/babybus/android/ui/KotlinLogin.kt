package com.amijiaoyu.babybus.android.ui

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Toast
import com.amijiaoyu.babybus.android.R
import com.amijiaoyu.babybus.android.base.rootKotlin.KotlinRxActivity
import com.amijiaoyu.babybus.android.model.bean.LoginOkBean
import kotlinx.android.synthetic.main.activity_login.*

@SuppressLint("Registered")
/**
 * @author Dsh on 2018/3/15.
 */
class KotlinLogin : KotlinRxActivity<KotlinPresenter>(), KotlinConstance.View {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        login()
    }


    private fun login() {
        login.setOnClickListener {
            mPresenter?.login(account.text.toString(), password.text.toString())
        }
    }

    override fun loginSucceed(loginBean: LoginOkBean) {
        Toast.makeText(this, loginBean.nickname, Toast.LENGTH_SHORT).show()

    }

    override fun loginField(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    override fun getLayoutId(): Int {
        return R.layout.activity_login
    }

    override fun initInject() {
        getActivityComponent().inject(this)
    }

}