package com.amijiaoyu.babybus.android.model.rx;

import android.accounts.NetworkErrorException;
import android.content.Context;
import android.util.Log;
import android.widget.Toast;
import com.amijiaoyu.babybus.android.ui.NoUser;
import com.google.common.base.Strings;
import com.google.gson.Gson;
import com.google.gson.JsonParseException;
import java.io.IOException;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import retrofit2.HttpException;
import work.wanghao.rxbus2.RxBus;

/**
 *
 * @author Dsh
 * @date 2017/5/8
 * Use:
 */
public class RxErrorHandler {

  private static final int NO_FIND = 1000;

  private Context mContext;

  public RxErrorHandler(Context context) {

    this.mContext = context;
  }

  public BaseException handleError(Throwable e) throws IOException {
    Log.v("RxError", e.toString());
    BaseException exception = new BaseException();
    if (e instanceof ApiException) {
      exception.setCode(BaseException.API_ERROR);
      exception.setDisplayMessage(ErrorMessageFactory.create(mContext, BaseException.API_ERROR));
    } else if (e instanceof JsonParseException) {
      exception.setCode(BaseException.JSON_ERROR);
      exception.setDisplayMessage(ErrorMessageFactory.create(mContext, BaseException.JSON_ERROR));
    } else if (e instanceof RxTransformerException) {
      exception.setCode(BaseException.ERROR_TRANSFORMER);
      exception.setDisplayMessage(ErrorMessageFactory.create(mContext, BaseException.ERROR_TRANSFORMER));
    } else if (e instanceof SocketTimeoutException) {
      exception.setCode(BaseException.SOCKET_TIMEOUT_ERROR);
      exception.setDisplayMessage(
          ErrorMessageFactory.create(mContext, BaseException.SOCKET_TIMEOUT_ERROR));
    } else if (e instanceof UnknownHostException) {
      exception.setCode(BaseException.UNKOWNHOST_ERROR);
      exception.setDisplayMessage(
          ErrorMessageFactory.create(mContext, BaseException.UNKOWNHOST_ERROR));
    } else if (e instanceof SocketException) {
      exception.setCode(BaseException.SOCKET_TIMEOUT_ERROR);
      exception.setDisplayMessage(
          ErrorMessageFactory.create(mContext, BaseException.SOCKET_TIMEOUT_ERROR));
    } else if (e instanceof NetworkErrorException) {
      exception.setCode(BaseException.SOCKET_ERROR);
      exception.setDisplayMessage(ErrorMessageFactory.create(mContext, BaseException.SOCKET_ERROR));
    } else if (e instanceof HttpException) {
      exception.setCode(((HttpException) e).code());
      HttpException httpException = (HttpException) e;
      Gson gson = new Gson();
      //后台服务器返回的错误json
      Message messages = gson.fromJson(httpException.response().errorBody().string(),
          Message.class);
      if (messages.getCode() == NO_FIND) {
        RxBus.Companion.get().post(new NoUser());
      }
      if (!Strings.isNullOrEmpty(messages.getMessage())) {
        exception.setDisplayMessage(messages.getMessage());
      } else {
        exception.setDisplayMessage(ErrorMessageFactory.create(mContext, exception.getCode()));
      }
    } else {
      exception.setCode(BaseException.UNKNOWN_ERROR);
      exception.setDisplayMessage(
          ErrorMessageFactory.create(mContext, BaseException.UNKNOWN_ERROR));
    }
    return exception;
  }

  public void showErrorMessage(BaseException e) {
    Toast.makeText(mContext, e.getDisplayMessage(), Toast.LENGTH_SHORT).show();
  }
}
