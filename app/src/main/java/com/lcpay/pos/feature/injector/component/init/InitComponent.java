package com.lcpay.pos.feature.injector.component.init;

import com.lcpay.pos.feature.injector.module.activity.InitModule;
import com.lcpay.pos.feature.ui.activity.initConfig.InitActivity;
import com.lcpay.pos.feature.ui.activity.initConfig.LoginActivity;

import javax.inject.Singleton;

import dagger.Component;


@Singleton
@Component(modules = {InitModule.class})
public interface InitComponent {
    void injectInitDeatil(InitActivity initActivity);

    void injectLoginDeatil(LoginActivity loginActivity);
}
