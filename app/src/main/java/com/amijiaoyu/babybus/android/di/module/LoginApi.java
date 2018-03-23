package com.amijiaoyu.babybus.android.di.module;

import com.amijiaoyu.babybus.android.model.bean.BaseBean;
import com.amijiaoyu.babybus.android.model.bean.LoginOkBean;

import io.reactivex.Flowable;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * Date:2017/10/10 09:45
 * Email:imkobedroid@gmail.com
 *
 * @author dongshihong
 */

public interface LoginApi {

    @FormUrlEncoded
    @POST("/api/login")
    Flowable<LoginOkBean> Login(@Field("mobile") String phone, @Field("password") String password);
}
