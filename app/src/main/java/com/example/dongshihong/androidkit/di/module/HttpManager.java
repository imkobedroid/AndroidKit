package com.example.dongshihong.androidkit.di.module;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.compat.BuildConfig;
import com.example.dongshihong.androidkit.di.cookie.CookieManager;
import com.example.dongshihong.androidkit.di.interceptor.DefaultHeaderInterceptor;
import com.orhanobut.logger.Logger;
import java.util.concurrent.TimeUnit;
import okhttp3.Headers;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;

/**
 * Created by Dsh on 2017/5/9.
 * Use:
 */

public class HttpManager {

  private OkHttpClient mOkHttpClient;
  @SuppressLint("StaticFieldLeak") private static HttpManager sHttpManager;
  private Context context;
  private final static int TIME_OUT = 30;
  private Headers.Builder builder;
  private HttpManager(Context context) {
    this.context = context;
    initOkHttpClient();
  }

  public static HttpManager getInstance(Context context) {
    if (sHttpManager == null) {
      synchronized (HttpManager.class) {
        if (sHttpManager == null) {
          sHttpManager = new HttpManager(context);
        }
      }
    }
    return sHttpManager;
  }

  public OkHttpClient getOkHttpClient() {
    return mOkHttpClient;
  }

  private Headers.Builder defaultHeader() {
    builder = new Headers.Builder();
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
    builder.addInterceptor(new DefaultHeaderInterceptor(defaultHeaderBuilder, context));
    builder.connectTimeout(TIME_OUT, TimeUnit.SECONDS);
    builder.readTimeout(TIME_OUT, TimeUnit.SECONDS);
    builder.writeTimeout(TIME_OUT, TimeUnit.SECONDS);
    builder.cookieJar(CookieManager.getInstance(context));
    builder.retryOnConnectionFailure(true);
    mOkHttpClient = builder.build();

    // TODO: 2017/9/26 也可以通过这样的方式来添加请求头信息
    /*mOkHttpClient.interceptors().add(chain -> {
      Request original = chain.request();
      Request.Builder requestBuilder = original.newBuilder()
          .addHeader("header-key", "value1")
          .addHeader("header-key", "value2");
      Request request = requestBuilder.build();
      return chain.proceed(request);
    });*/
  }
}
