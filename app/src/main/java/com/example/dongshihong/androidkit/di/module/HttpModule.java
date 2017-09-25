package com.example.dongshihong.androidkit.di.module;

import android.content.Context;
import com.example.dongshihong.androidkit.app.Constants;
import com.example.dongshihong.androidkit.di.qualifier.BaseUrl;
import dagger.Module;
import dagger.Provides;
import javax.inject.Singleton;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * @author keal
 *         Created  on 2017/05/03 11:56.
 *         Summary:
 */

@Module
public class HttpModule {

    @Singleton
    @Provides
    Retrofit.Builder provideRetrofitBuilder() {
        return new Retrofit.Builder();
    }

    @Singleton
    @Provides
    OkHttpClient.Builder provideOkHttpBuilder() {
        return new OkHttpClient.Builder();
    }

    /**
     * 这里要提供相应的retrofit  本项目的baseUrl相同所以使用了相同的@BaseUrl
     */
 /*   @Singleton
    @Provides
    @ZhihuUrl
    Retrofit provideZhihuRetrofit(Retrofit.Builder builder,
                                  OkHttpClient client) {
        return createRetrofit(builder, client, ZhihuApis.HOST);
    }*/

    @Singleton
    @Provides
    @BaseUrl
    Retrofit LoginRetrofit(Retrofit.Builder builder,
                           OkHttpClient client) {
        return createRetrofit(builder, client, Constants.HOST);
    }

    @Singleton
    @Provides
    OkHttpClient provideClient(Context context) {
        return HttpManager.getInstance(context).getOkHttpClient();
    }

    private Retrofit createRetrofit(Retrofit.Builder builder, OkHttpClient client, String url) {
        return builder.baseUrl(url)
                .client(client)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    /**
     * 下面是提供一切接口的地方
     */

   /* @Singleton
    @Provides
    ZhihuApis provideZhihuService(@ZhihuUrl Retrofit retrofit) {
        return retrofit.create(ZhihuApis.class);
    }*/


}