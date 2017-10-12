package com.amijiaoyu.babybus.android.di.module;

import com.amijiaoyu.babybus.android.ui.LoginBean;
import com.amijiaoyu.babybus.android.ui.RequestBean;
import com.amijiaoyu.babybus.android.ui.UserInfoBean;
import io.reactivex.Flowable;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * Author:SHIHONG DONG
 * Date:2017/10/10 09:45
 * Email:imkobedroid@gmail.com
 */

public interface LoginApi {
 // @Headers({"Content-Type: application/json","Accept: application/json"})//需要添加头
  @POST("/oauth/token") Flowable<LoginBean> getPayData(@Body RequestBean body);


  @GET("/api/user") Flowable<UserInfoBean> getUser();
}
