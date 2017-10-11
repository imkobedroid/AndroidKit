package com.amijiaoyu.babybus.android.blank;

import android.support.annotation.DrawableRes;
import android.support.annotation.StringRes;
import android.view.View;

/**
 * Author:SHIHONG DONG
 * Date:2017/9/25 11:38
 * Email:imkobedroid@gmail.com
 */

public interface EmptyView {
  EmptyView buildEmptyImageView(@DrawableRes int drawableRes);

  EmptyView buildEmptyTitle(@StringRes int stringRes);

  EmptyView buildEmptyTitle(String title);

  EmptyView buildEmptySubtitle(@StringRes int stringRes);

  EmptyView buildEmptySubtitle(String subtitle);

  EmptyView shouldDisplayEmptySubtitle(boolean display);

  EmptyView shouldDisplayEmptyTitle(boolean display);

  EmptyView shouldDisplayEmptyImageView(boolean display);

  void setOnEmptyViewClickListener(OnEmptyViewClickListener listener);

  interface OnEmptyViewClickListener {
    void onEmptyViewClick(View view);
  }
}
