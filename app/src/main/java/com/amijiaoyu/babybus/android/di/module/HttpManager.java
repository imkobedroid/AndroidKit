package com.amijiaoyu.babybus.android.di.module;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.compat.BuildConfig;
import com.amijiaoyu.babybus.android.app.Constants;
import com.amijiaoyu.babybus.android.di.interceptor.DefaultHeaderInterceptor;
import com.orhanobut.logger.Logger;
import java.util.concurrent.TimeUnit;
import okhttp3.Headers;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;

/**
 * Created by Dsh on 2017/5/9.
 * Use:
 */

class HttpManager {

  private OkHttpClient mOkHttpClient;
  @SuppressLint("StaticFieldLeak") private static HttpManager sHttpManager;
  private Context context;
  private final static int TIME_OUT = 30;

  private HttpManager(Context context) {
    this.context = context;
    initOkHttpClient();
  }

  static HttpManager getInstance(Context context) {
    if (sHttpManager == null) {
      synchronized (HttpManager.class) {
        if (sHttpManager == null) {
          sHttpManager = new HttpManager(context);
        }
      }
    }
    return sHttpManager;
  }

  OkHttpClient getOkHttpClient() {
    return mOkHttpClient;
  }

  private Headers.Builder defaultHeader() {
    Headers.Builder builder = new Headers.Builder();
    builder.add("Accept:", "application/json");
    return builder;
  }

  private void initOkHttpClient() {
    OkHttpClient.Builder builder = new OkHttpClient.Builder();
    if (BuildConfig.DEBUG) {
      HttpLoggingInterceptor loggingInterceptor =
          new HttpLoggingInterceptor((message) -> Logger.i(message));

      loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

      builder.addInterceptor(loggingInterceptor);
    }
    Headers.Builder defaultHeaderBuilder = defaultHeader();
    defaultHeaderBuilder.add("Accept", Constants.API_ACCEPT);
    builder.addInterceptor(new DefaultHeaderInterceptor(defaultHeaderBuilder, context));
    builder.connectTimeout(TIME_OUT, TimeUnit.SECONDS);
    builder.readTimeout(TIME_OUT, TimeUnit.SECONDS);
    builder.writeTimeout(TIME_OUT, TimeUnit.SECONDS);
    builder.retryOnConnectionFailure(true);
    mOkHttpClient = builder.build();
  }
}
