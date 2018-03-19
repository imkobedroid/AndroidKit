package com.amijiaoyu.babybus.android.di.interceptor;

import android.content.Context;
import com.amijiaoyu.babybus.android.model.account.AccountManager;
import com.google.common.base.Strings;
import java.io.IOException;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by Dsh on 2017/5/5.
 * Use:
 */

public class DefaultHeaderInterceptor implements HeaderInterceptor {
    private Context context;
    private   Request authorised;
    public DefaultHeaderInterceptor(Context context) {
        this.context=context;
    }

    @Override public Response intercept(Interceptor.Chain chain) throws IOException {
        Request originalRequest = chain.request();

        final String token = AccountManager.getInstance(context).getToken();
        if (!Strings.isNullOrEmpty(token)) {
            authorised = originalRequest.newBuilder()
                .header("Authorization", "Bearer " + token)
                .build();
            return chain.proceed(authorised);

        }else {

            return chain.proceed(originalRequest);
        }
    }
}
