package com.example.dongshihong.androidkit.model.http.cookie;

import android.content.Context;
import java.util.List;
import okhttp3.Cookie;
import okhttp3.CookieJar;
import okhttp3.HttpUrl;

/**
 * Author:SHIHONG DONG
 * Date:2017/9/25 11:37
 * Email:imkobedroid@gmail.com
 */

public class CookieManager implements CookieJar {

  private static CookieManager sCookieManager;

  private CookieStoreManager mCookieStoreManager;

  private CookieManager(Context context) {
    mCookieStoreManager = new CookieStoreManager(context);
  }

  public static CookieManager getInstance(Context context) {
    if (sCookieManager == null) {
      synchronized (CookieManager.class) {
        if (sCookieManager == null) {
          sCookieManager = new CookieManager(context.getApplicationContext());/*memory leak*/
        }
      }
    }
    return sCookieManager;
  }

  @Override public void saveFromResponse(HttpUrl url, List<Cookie> cookies) {
    mCookieStoreManager.add(url, cookies);
  }

  @Override public List<Cookie> loadForRequest(HttpUrl url) {
    return mCookieStoreManager.get(url);
  }
}
