package com.amijiaoyu.babybus.android.blank;

import android.support.annotation.DrawableRes;
import android.support.annotation.StringRes;
import android.view.View;

/**
 * Author:SHIHONG DONG
 * Date:2017/9/25 11:39
 * Email:imkobedroid@gmail.com
 */

public interface ErrorView {
  ErrorView buildErrorImageView(@DrawableRes int drawableRes);

  ErrorView buildErrorTitle(@StringRes int stringRes);

  ErrorView buildErrorTitle(String title);

  ErrorView buildErrorSubtitle(@StringRes int stringRes);

  ErrorView buildErrorSubtitle(String subtitle);

  ErrorView shouldDisplayErrorSubtitle(boolean display);

  ErrorView shouldDisplayErrorTitle(boolean display);

  ErrorView shouldDisplayErrorImageView(boolean display);

  void setOnErrorViewClickListener(OnErrorViewClickListener listener);

  interface OnErrorViewClickListener {
    void onErrorViewClick(View view);
  }
}