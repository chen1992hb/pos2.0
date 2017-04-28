package com.lcpay.pos.feature.http.service;

import com.lcpay.pos.feature.bean.InitCofig;
import com.lcpay.pos.feature.bean.init.GetUsers;
import com.lcpay.pos.feature.bean.init.LoginParams;
import com.lcpay.pos.feature.bean.init.LoginRe;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by admin on 2017/4/27.
 */

public interface InitService {
    //初始化机器
    @GET("/lcsw/epospay/110/init")
    Observable<InitCofig> getInitCofig(@Query("macid") String macid);

    //获取用户列表
    @GET("/lcsw/epospay/110/getusers")
    Observable<GetUsers> getUserList(@Query("macid") String macid);

    //登录
    @POST("/lcsw/epospay/110/login")
    Observable<LoginRe> login(@Body LoginParams user);
}
