package com.amijiaoyu.babybus.android.di.module;

import com.amijiaoyu.babybus.android.model.bean.BaseBean;
import com.amijiaoyu.babybus.android.model.bean.LoginOkBean;
import com.amijiaoyu.babybus.android.ui.LoginBean;
import com.amijiaoyu.babybus.android.ui.RequestBean;
import com.amijiaoyu.babybus.android.ui.UserInfoBean;
import io.reactivex.Flowable;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * Date:2017/10/10 09:45
 * Email:imkobedroid@gmail.com
 * @author dongshihong
 */

public interface LoginApi {
  /**
   * 得到支付的数据
   *
   * @param body 登录要使用的json数据
   * @return 返回用户登录的数据
   */
  @POST("/oauth/token") Flowable<BaseBean<LoginBean>> getPayData(@Body RequestBean body);

  /**
   * 得到用户的信息
   *
   * @return 返回用户的数据
   */
  @GET("/api/user") Flowable<BaseBean<UserInfoBean>> getUser();



  @FormUrlEncoded
    @POST("/api/login") Flowable<LoginOkBean> login(@Field("mobile")String mobile,@Field("password")String password);
}
