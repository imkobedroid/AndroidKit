package com.example.dongshihong.androidkit.model.rx;

import android.content.Context;
import android.util.Log;
import com.google.gson.Gson;
import com.google.gson.JsonParseException;
import java.io.IOException;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import retrofit2.HttpException;

/**
 * Created by Dsh on 2017/5/8.
 * Use:
 */
public class RxErrorHandler {

  private Context mContext;

  public RxErrorHandler(Context context) {

    this.mContext = context;
  }

  public BaseException handleError(Throwable e) throws IOException {
    Log.v("RxError", e.toString());
    BaseException exception = new BaseException();
    if (e instanceof ApiException) {
      exception.setCode(((ApiException) e).getCode());
    } else if (e instanceof JsonParseException) {
      exception.setCode(BaseException.JSON_ERROR);
    } else if (e instanceof HttpException) {
      exception.setCode(((HttpException) e).code());
      HttpException httpException = (HttpException) e;
      Gson gson = new Gson();
   /*   Message messages;
      messages = gson.fromJson(httpException.response().errorBody().string(),
          Message.class);//后台服务器返回的错误json
      exception.setDisplayMessage(messages.getMessage());*/
    } else if (e instanceof SocketTimeoutException) {
      exception.setCode(BaseException.SOCKET_TIMEOUT_ERROR);
    } else if (e instanceof SocketException) {

    } else {
      exception.setCode(BaseException.UNKNOWN_ERROR);
    }

    if (e instanceof HttpException) {
    } else {
      exception.setDisplayMessage(ErrorMessageFactory.create(mContext, exception.getCode()));
    }

    return exception;
  }

  public void showErrorMessage(BaseException e) {
    //Toast.makeText(mContext, e.getDisplayMessage(), Toast.LENGTH_SHORT).show();
  }
}
