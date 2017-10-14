package com.amijiaoyu.babybus.android.model.rx;

import android.content.Context;

/**
 * Created by Dsh on 2017/5/8.
 * Use:
 */
public abstract class ProgressDialogSubscriber<T> extends ErrorHandlerSubscriber<T>
    implements ProgressDialogHandler.OnProgressCancelListener {

  private ProgressDialogHandler mProgressDialogHandler;

  public ProgressDialogSubscriber(Context context) {
    super(context);
    mProgressDialogHandler = new ProgressDialogHandler(context, true, this);
  }

  @Override public void onCancelProgress() {
    dispose();//点击取消对话框后断开订阅关系
  }

  @Override public void onStart() {
    super.onStart();
    this.mProgressDialogHandler.showProgressDialog();
  }

  @Override public void onComplete() {
    this.mProgressDialogHandler.dismissProgressDialog();
  }

  @Override public void onError(Throwable e) {
    super.onError(e);
    this.mProgressDialogHandler.dismissProgressDialog();
  }


}
