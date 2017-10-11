package com.amijiaoyu.babybus.android.model.rx;

import android.content.Context;
import com.google.common.base.Strings;
import java.io.IOException;

/**
 * Created by Dsh on 2017/5/8.
 * Use:
 */
public abstract class ErrorHandlerSubscriber<T> extends DefaultSubscriber<T> {
  private BaseException baseException;
  private RxErrorHandler errorHandler;

  public ErrorHandlerSubscriber(Context context) {
    Context Context = context;
    errorHandler = new RxErrorHandler(Context);
  }

  @Override public void onError(Throwable e) {
    try {
      baseException = errorHandler.handleError(e);
    } catch (IOException e1) {
      e1.printStackTrace();
    }

    if (baseException != null) {
      if (!Strings.isNullOrEmpty(baseException.getDisplayMessage())){//捕获到自定义的异常就显示，如果没有就在presenter中自己定义
        errorHandler.showErrorMessage(baseException);
      }
    } /*else {
      if (mContext != null && (baseException.getCode() == 401 || baseException.getCode() == 402)) {
        *//*if (mContext instanceof RxActivity) {
          AccountManager.getInstance(mContext).loginOut();
          ((RxActivity) mContext).showOfflineDialog();
        } else {
          AccountManager.getInstance(mContext).loginOut();
          Intent intent = new Intent(mContext, LoginActivity.class);
          intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
          mContext.startActivity(intent);
        }*//*
      }
      errorHandler.showErrorMessage(baseException);
    }*/
  }
}
