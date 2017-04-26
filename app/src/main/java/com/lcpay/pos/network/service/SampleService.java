package com.lcpay.pos.network.service;

import okhttp3.RequestBody;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Query;
import rx.Observable;

public interface SampleService {
  @GET("lcsw/merchant/100/Sample1")
  Observable<String> Sample1(@Query("merchantno") String merchantno);

  @Headers({"Content-type:application/json;charset=UTF-8"})
  @POST("lcsw/merchant/100/Sample2")
  Observable<String> Sameple2(@Body RequestBody body);

}
