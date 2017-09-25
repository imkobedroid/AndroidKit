package com.example.dongshihong.androidkit.blank;

import android.content.Context;
import android.support.annotation.DrawableRes;
import android.support.annotation.StringRes;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.ButterKnife;
import com.example.dongshihong.androidkit.R;
import com.example.dongshihong.androidkit.blank.blankutils.ViewUtils;

/**
 * Author:SHIHONG DONG
 * Date:2017/9/25 11:45
 * Email:imkobedroid@gmail.com
 */

public class DefaultEmptyView extends FrameLayout implements EmptyView, View.OnClickListener {

  private ImageView imageView;
  private TextView titleTextView;
  private TextView subtitleTextView;

  private OnEmptyViewClickListener listener;

  public DefaultEmptyView(Context context) {
    super(context);
    initialize(context);
  }

  private void initialize(Context context) {
    View view = LayoutInflater.from(context).inflate(R.layout.support_ui_view_empty, this, false);
    addView(view);
  }

  @Override protected void onAttachedToWindow() {
    super.onAttachedToWindow();
    setOnClickListener(this);
  }

  @Override protected void onDetachedFromWindow() {
    super.onDetachedFromWindow();
    setOnClickListener(null);
    listener = null;
  }

  @Override public DefaultEmptyView buildEmptyImageView(@DrawableRes int drawableRes) {
    if (imageView() != null) {
      imageView().setImageResource(drawableRes);
    }
    return this;
  }

  @Override public DefaultEmptyView buildEmptyTitle(@StringRes int stringRes) {
    return buildEmptyTitle(getContext().getString(stringRes));
  }

  public DefaultEmptyView buildEmptyTitle(String title) {
    if (titleTextView() != null) {
      titleTextView().setText(title);
    }
    return this;
  }

  @Override public DefaultEmptyView buildEmptySubtitle(@StringRes int stringRes) {
    return buildEmptySubtitle(getContext().getString(stringRes));
  }

  @Override public DefaultEmptyView buildEmptySubtitle(String subtitle) {
    if (subtitleTextView() != null) {
      subtitleTextView().setText(subtitle);
    }
    return this;
  }

  @Override public EmptyView shouldDisplayEmptySubtitle(boolean display) {
    ViewUtils.setGone(subtitleTextView(), !display);
    return this;
  }

  @Override public EmptyView shouldDisplayEmptyTitle(boolean display) {
    ViewUtils.setGone(titleTextView(), !display);
    return this;
  }

  @Override public EmptyView shouldDisplayEmptyImageView(boolean display) {
    ViewUtils.setGone(imageView(), !display);
    return this;
  }

  public TextView titleTextView() {
    if (titleTextView == null) {
      titleTextView = ButterKnife.findById(this, R.id.supportUiEmptyTitle);
    }
    return titleTextView;
  }

  public TextView subtitleTextView() {
    if (subtitleTextView == null) {
      subtitleTextView = ButterKnife.findById(this, R.id.supportUiEmptySubtitle);
    }
    return subtitleTextView;
  }

  public ImageView imageView() {
    if (imageView == null) {
      imageView = ButterKnife.findById(this, R.id.supportUiEmptyImageView);
    }
    return imageView;
  }

  @Override public void onClick(View v) {
    if (listener != null) {
      listener.onEmptyViewClick(v);
    }
  }

  @Override public void setOnEmptyViewClickListener(OnEmptyViewClickListener listener) {
    this.listener = listener;
  }
}
