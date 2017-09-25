package com.example.dongshihong.androidkit.model.http.api;

import android.content.Context;
import com.example.dongshihong.androidkit.model.account.AccountManager;
import com.google.common.base.Strings;
import java.io.IOException;
import okhttp3.Headers;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by Dsh on 2017/5/5.
 * Use:
 */

public class DefaultHeaderInterceptor implements HeaderInterceptor {
  private Headers.Builder builder;
  private Context context;
  public DefaultHeaderInterceptor(Headers.Builder builder,Context context) {
    this.builder = builder;
    this.context=context;
  }

  @Override public Response intercept(Chain chain) throws IOException {
    Request originalRequest = chain.request();
    if (builder == null) {
      builder = new Headers.Builder();
    }

    final String token = AccountManager.getInstance(context).getToken();
    if (!Strings.isNullOrEmpty(token)) {
      builder.set("Authorization", "Bearer" + token);
    }

    Request compressedRequest = originalRequest
        .newBuilder()
        .headers(builder.build())
        .build();

    return chain.proceed(compressedRequest);
  }
}
