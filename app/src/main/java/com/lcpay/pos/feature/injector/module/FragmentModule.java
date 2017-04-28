package com.lcpay.pos.feature.injector.module;

import android.app.Activity;
import android.support.v4.app.Fragment;

import com.lcpay.pos.feature.injector.scope.FragmentScope;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by quantan.liu on 2017/3/21.
 */

@Module
public class FragmentModule {

    private Fragment fragment;

    public FragmentModule(Fragment fragment) {
        this.fragment = fragment;
    }

    @Provides
    @FragmentScope
    public Activity provideActivity() {
        return fragment.getActivity();
    }

}
