package com.amijiaoyu.babybus.android.model.account;

import android.content.Context;
import com.amijiaoyu.babybus.android.utils.ACache;
import com.google.common.base.Strings;
import com.google.gson.Gson;

/**
 * Created by Dsh on 2017/5/5.
 * Use:
 */

public class AccountManager {

  private final static String TOKEN = "baby_token";
  private final static String NAME = "name";
  private final static String JSON = "json";
  private final static String USER = "account";
  private final static String IS_LOGIN = "login";

  private BaseAccount mCurrentAccount;
  private static AccountManager accountManager;
  private static ACache aCache;
  private static Gson gson;

  public static AccountManager getInstance(Context context) {
    gson = new Gson();
    if (accountManager == null) {
      synchronized (AccountManager.class) {
        if (accountManager == null) {
          accountManager =
              new AccountManager(context.getApplicationContext());//使用getApplicationContext防止内存泄漏
        }
      }
    }
    return accountManager;
  }

  AccountManager(Context context) {
    if (aCache == null) {
      synchronized (AccountManager.class) {
        if (aCache == null) {
          aCache = ACache.get(context.getApplicationContext());
        }
      }
    }
  }

  public boolean isLogin() {
    return AccountManager.IS_LOGIN.equals(aCache.getAsString(AccountManager.IS_LOGIN));
  }

  public void storeAccount(BaseAccount account) {
    mCurrentAccount = account;
    aCache.put(AccountManager.IS_LOGIN, AccountManager.IS_LOGIN);
    if (!Strings.isNullOrEmpty(account.token())) {
      aCache.put(AccountManager.TOKEN, account.token());
    }
    if (!Strings.isNullOrEmpty(account.name())) {
      aCache.put(AccountManager.NAME, account.name());
    }
    aCache.put(AccountManager.USER, gson.toJson(account));
    if (!Strings.isNullOrEmpty(account.toJson())) {
      aCache.put(AccountManager.JSON, account.toJson());
    }
  }

  public String getToken() {
    return aCache.getAsString(AccountManager.TOKEN);
  }

  public String getName() {
    return aCache.getAsString(AccountManager.NAME);
  }

  public BaseAccount getCurrentUser() {
    //mCurrentAccount = gson.fromJson(aCache.getAsString(AccountManager.USER), UserInfoBean.class);
    return mCurrentAccount;
  }

  public void loginOut() {
    mCurrentAccount = null;
    aCache.clear();
  }
}
