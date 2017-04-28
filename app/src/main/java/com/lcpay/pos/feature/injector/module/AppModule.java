package com.lcpay.pos.feature.injector.module;


import android.app.Application;

import com.lcpay.pos.app.ApplicationLike;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class AppModule {

    private final Application application;

    public AppModule(Application application) {
        this.application = application;
    }

    @Provides
    @Singleton
    Application provideApplicationContext() {
        return application;
    }
}
