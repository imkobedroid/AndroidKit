package com.example.dongshihong.androidkit.di.module;

import com.example.dongshihong.androidkit.ui.LoginBean;
import com.example.dongshihong.androidkit.ui.RequestBean;
import io.reactivex.Flowable;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

/**
 * Author:SHIHONG DONG
 * Date:2017/10/10 09:45
 * Email:imkobedroid@gmail.com
 */

public interface LoginApi {
  @Headers({"Content-Type: application/json","Accept: application/json"})//需要添加头
   @POST("/oauth/token") Flowable<LoginBean> getPayData(@Body RequestBean body);
}
