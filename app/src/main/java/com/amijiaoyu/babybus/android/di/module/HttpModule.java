package com.amijiaoyu.babybus.android.di.module;

import android.content.Context;
import com.amijiaoyu.babybus.android.app.Constants;
import com.amijiaoyu.babybus.android.di.assist.BaseUrl;
import dagger.Module;
import dagger.Provides;
import javax.inject.Singleton;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Author:Dsh
 * Date:2017/9/25 11:37
 * Email:imkobedroid@gmail.com
 */

@Module public class HttpModule {

  @Singleton @Provides Retrofit.Builder provideRetrofitBuilder() {
    return new Retrofit.Builder();
  }

  @Singleton @Provides OkHttpClient.Builder provideOkHttpBuilder() {
    return new OkHttpClient.Builder();
  }

  @Singleton @Provides OkHttpClient provideClient(Context context) {
    return HttpManager.getInstance(context).getOkHttpClient();
  }

  private Retrofit createRetrofit(Retrofit.Builder builder, OkHttpClient client, String url) {
    return builder.baseUrl(url)
        .client(client)
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .addConverterFactory(GsonConverterFactory.create())
        .build();
  }

  // TODO: 2017/10/10 这里要提供相应的retrofit  本项目的baseUrl相同所以使用了相同的@BaseUrl

  @Singleton @Provides @BaseUrl Retrofit LoginRetrofit(Retrofit.Builder builder,
      OkHttpClient client) {
    return createRetrofit(builder, client, Constants.HOST);
  }


  // TODO: 2017/10/10 下面是提供一切接口的地方
  @Singleton @Provides LoginApi provideLoginApi(@BaseUrl Retrofit retrofit) {
    return retrofit.create(LoginApi.class);
  }
}