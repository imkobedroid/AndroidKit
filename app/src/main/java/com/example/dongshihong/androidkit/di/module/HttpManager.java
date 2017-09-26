package com.example.dongshihong.androidkit.di.module;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.compat.BuildConfig;
import com.example.dongshihong.androidkit.app.Constants;
import com.example.dongshihong.androidkit.di.interceptor.DefaultHeaderInterceptor;
import com.example.dongshihong.androidkit.di.cookie.CookieManager;
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
  private Context mContext;
  private final static int TIME_OUT = 30;

  private HttpManager(Context context) {
    mContext = context;
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
    Headers.Builder builder = new Headers.Builder();
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
    builder.addInterceptor(new DefaultHeaderInterceptor(defaultHeaderBuilder, mContext));
    builder.connectTimeout(TIME_OUT, TimeUnit.SECONDS);
    builder.readTimeout(TIME_OUT, TimeUnit.SECONDS);
    builder.writeTimeout(TIME_OUT, TimeUnit.SECONDS);
    builder.cookieJar(CookieManager.getInstance(mContext));
    builder.retryOnConnectionFailure(true);
    mOkHttpClient = builder.build();
  }
}
