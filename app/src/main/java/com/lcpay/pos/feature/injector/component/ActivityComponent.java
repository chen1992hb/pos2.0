package com.lcpay.pos.feature.injector.component;

import android.app.Activity;


import com.lcpay.pos.feature.injector.module.ActivityModule;
import com.lcpay.pos.feature.injector.scope.ActivityScope;

import dagger.Component;

/**
 * Created by quantan.liu on 2017/3/21.
 */
@ActivityScope
@Component(dependencies = AppComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {
    Activity getActivity();
}
