package com.lcpay.pos.feature.injector.module.qualifier;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;

import javax.inject.Qualifier;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Created by admin on 2017/4/27.
 */
@Qualifier
@Documented
@Retention(RUNTIME)
public @interface InitUrl {
}
