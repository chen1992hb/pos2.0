package com.lcpay.pos.feature.presenter;


public interface BaseView<T> {
    void refreshView(T mData);//获取数据成功调用该方法。
}
