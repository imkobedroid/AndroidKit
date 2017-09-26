package com.example.dongshihong.androidkit.model.rx;

import android.content.Context;
import java.io.IOException;

/**
 * Created by Dsh on 2017/5/8.
 * Use:
 */
public abstract class ErrorHandlerSubscriber<T> extends DefaultSubscriber<T> {

  protected RxErrorHandler mErrorHandler = null;

  protected Context mContext;

  public ErrorHandlerSubscriber(Context context) {

    this.mContext = context;

    mErrorHandler = new RxErrorHandler(mContext);
  }

  @Override public void onError(Throwable e) {
    BaseException baseException = null;
    try {
      baseException = mErrorHandler.handleError(e);
    } catch (IOException e1) {
      e1.printStackTrace();
    }
    if (baseException == null) {
      e.printStackTrace();
    } else {
      if (mContext != null && (baseException.getCode() == 401 || baseException.getCode() == 402)) {
        /*if (mContext instanceof RxActivity) {
          AccountManager.getInstance(mContext).loginOut();
          ((RxActivity) mContext).showOfflineDialog();
        } else {
          AccountManager.getInstance(mContext).loginOut();
          Intent intent = new Intent(mContext, LoginActivity.class);
          intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
          mContext.startActivity(intent);
        }*/
      }
      mErrorHandler.showErrorMessage(baseException);
    }
  }
}
