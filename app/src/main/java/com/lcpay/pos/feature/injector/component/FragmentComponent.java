package com.lcpay.pos.feature.injector.component;

import android.app.Activity;


import com.lcpay.pos.feature.injector.module.FragmentModule;
import com.lcpay.pos.feature.injector.scope.FragmentScope;

import dagger.Component;

/**
 * Created by quantan.liu on 2017/3/21.
 */

@FragmentScope
@Component(dependencies = AppComponent.class, modules = FragmentModule.class)
public interface FragmentComponent {
    Activity getActivity();

}
