package com.lcpay.pos.feature.injector.module.activity;

import com.lcpay.pos.app.AppConstants;
import com.lcpay.pos.feature.http.service.InitService;
import com.lcpay.pos.feature.http.utils.RetrofitInitUtils;
import com.lcpay.pos.feature.injector.module.http.BaseHttpModule;
import com.lcpay.pos.feature.injector.module.qualifier.InitUrl;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;

/**
 * Created by admin on 2017/4/27.
 */
@Module
public class InitModule extends BaseHttpModule {

    @Provides
    @Singleton
    @InitUrl
    Retrofit provideInitRetrofit(Retrofit.Builder builder, OkHttpClient client) {
        return createRetrofit(builder, client, AppConstants.API_LCSW);
    }

    @Provides
    @Singleton
    InitService provideInitService(@InitUrl Retrofit retrofit) {
        return retrofit.create(InitService.class);
    }

    @Provides
    @Singleton
    RetrofitInitUtils provideRetrofitInitUtils(InitService initService) {
        return new RetrofitInitUtils(initService);
    }
}
