package com.amijiaoyu.babybus.android.blank;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import com.amijiaoyu.babybus.android.R;

/**
 * Author:SHIHONG DONG
 * Date:2017/9/25 11:44
 * Email:imkobedroid@gmail.com
 */

public class DefaultLoadView extends FrameLayout {

  public DefaultLoadView(Context context) {
    super(context);
    initialize(context);
  }

  private void initialize(Context context) {
    View view = LayoutInflater.from(context).inflate(R.layout.support_ui_content_load, this, false);
    addView(view);
  }
}
