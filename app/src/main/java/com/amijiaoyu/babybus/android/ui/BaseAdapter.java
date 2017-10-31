package com.amijiaoyu.babybus.android.ui;

import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import java.util.List;

/**
 * Author:SHIHONG DONG
 * Date:2017/10/19 13:21
 * Email:imkobedroid@gmail.com
 */

public class BaseAdapter extends BaseQuickAdapter<String,BaseViewHolder> {
  public BaseAdapter(@LayoutRes int layoutResId, @Nullable List<String> data) {
    super(layoutResId, data);
  }

  @Override protected void convert(BaseViewHolder helper, String item) {

  }
}
