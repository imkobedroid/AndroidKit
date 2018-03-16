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


    @Override
    public void onComplete() {

    }

    @Override public void onError(Throwable e) {
    try {
      baseException = errorHandler.handleError(e);
    } catch (IOException e1) {
      e1.printStackTrace();
    }

    if (baseException != null) {

      if (!Strings.isNullOrEmpty(baseException.getDisplayMessage())){
        errorHandler.showErrorMessage(baseException);
      }
    }
  }
}
