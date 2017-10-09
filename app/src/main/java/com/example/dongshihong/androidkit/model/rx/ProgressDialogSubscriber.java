package com.example.dongshihong.androidkit.model.rx;

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

  public boolean isShowProgressDialog() {
    return true;
  }

  @Override public void onCancelProgress() {
    dispose();//点击取消对话框后断开订阅关系
  }

  @Override public void onStart() {
    super.onStart();
    if (isShowProgressDialog()) {
      this.mProgressDialogHandler.showProgressDialog();
    }
  }

  @Override public void onComplete() {
    if (isShowProgressDialog()) {
      this.mProgressDialogHandler.dismissProgressDialog();
    }
  }


  @Override public void onError(Throwable e) {
    super.onError(e);
    if (isShowProgressDialog()) {
      this.mProgressDialogHandler.dismissProgressDialog();
    }
  }
}
