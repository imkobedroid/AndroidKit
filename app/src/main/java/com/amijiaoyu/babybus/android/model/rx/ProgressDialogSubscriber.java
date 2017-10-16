package com.amijiaoyu.babybus.android.model.rx;

import android.content.Context;

/**
 * @author dongshihong
 * @date 2017/5/8
 */

public abstract class ProgressDialogSubscriber<T> extends ErrorHandlerSubscriber<T>
    implements ProgressDialogHandler.OnProgressCancelListener {

  private ProgressDialogHandler mProgressDialogHandler;

  public ProgressDialogSubscriber(Context context) {
    super(context);
    mProgressDialogHandler = new ProgressDialogHandler(context, true, this);
  }

  /**
   * 取消对话框断开观察者与被观察者的连接
   */
  @Override public void onCancelProgress() {
    dispose();
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
