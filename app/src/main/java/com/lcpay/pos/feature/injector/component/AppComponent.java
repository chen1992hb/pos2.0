package com.lcpay.pos.feature.injector.component;


import com.lcpay.pos.app.ApplicationLike;
import com.lcpay.pos.feature.injector.module.AppModule;
import com.lcpay.pos.feature.injector.module.activity.InitModule;
import com.lcpay.pos.util.PosApplicationContext;

import javax.inject.Singleton;

import dagger.Component;


@Singleton
@Component(modules = {AppModule.class, InitModule.class})
public interface AppComponent {
    //ApplicationLike getApplication();  // 提供App的Context


}
