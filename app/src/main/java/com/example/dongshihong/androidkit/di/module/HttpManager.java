package com.example.dongshihong.androidkit.di.module;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.compat.BuildConfig;
import com.example.dongshihong.androidkit.app.Constants;
import com.example.dongshihong.androidkit.model.http.api.DefaultHeaderInterceptor;
import com.example.dongshihong.androidkit.model.http.cookie.CookieManager;
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
    // final AppInfo appInfo = SupportApp.appInfo();
    Headers.Builder builder = new Headers.Builder();
    builder.add("Content-Encoding", "gzip")
        /*.add("X-Client-Build", String.valueOf(appInfo.versionCode))
        .add("X-Client-Version", appInfo.version)
        .add("X-Client", appInfo.deviceId)
        .add("X-Language-Code", appInfo.languageCode)*/.add("X-Client-Type", "android");

    /*final String channel = appInfo.channel;
    if (!TextUtils.isEmpty(channel)) {
      builder.add("X-Client-Channel", channel);
    }*/
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
    builder.addInterceptor(new DefaultHeaderInterceptor(defaultHeaderBuilder, mContext));
    /*try {
      SSLContext sc = SSLContext.getInstance("SSL");
      TdTrustManager trustManager = getTdTrustManager();
      sc.init(null, new TrustManager[] { trustManager }, new java.security.SecureRandom());
      builder.sslSocketFactory(sc.getSocketFactory(), trustManager);
    } catch (Exception e) {
      Log.e(TAG, "初始化证书出错:" + e.getMessage());
    }*/
    builder.connectTimeout(TIME_OUT, TimeUnit.SECONDS);
    builder.readTimeout(TIME_OUT, TimeUnit.SECONDS);
    builder.writeTimeout(TIME_OUT, TimeUnit.SECONDS);
    builder.cookieJar(CookieManager.getInstance(mContext));
    builder.retryOnConnectionFailure(true);
    mOkHttpClient = builder.build();
  }

  /*private TdTrustManager getTdTrustManager() throws Exception {
    KeyStore localTrustStore = KeyStore.getInstance("BKS");
    InputStream input = SupportApp.getInstance().getResources().openRawResource(R.raw.projecttdtruststore);
    try {
      localTrustStore.load(input, BuildConfig.TRUST_SERVER_CERT_PASS.toCharArray());
    } finally {
      input.close();
    }
    return new TdTrustManager(localTrustStore);
  }*/
}
