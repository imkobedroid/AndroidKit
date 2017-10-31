package com.amijiaoyu.babybus.android.ui

import com.amijiaoyu.babybus.android.R
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder

/**
 *  Author:Dsh
 *  Date:2017/10/19 13:02
 *  Email:imkobedroid@gmail.com
 */
class Adapter(id: Int, data: List<String>) : BaseQuickAdapter<String, BaseViewHolder>(id, data) {
  override fun convert(helper: BaseViewHolder?, item: String?) {
      helper!!.setText(R.id.text_view,item)
  }
}