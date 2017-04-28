package com.lcpay.pos.feature.presenter;


import com.lcpay.pos.app.AppConstants;
import com.lcpay.pos.feature.http.LifeSubscription;
import com.lcpay.pos.feature.http.Stateful;
import com.lcpay.pos.feature.http.utils.Callback;
import com.lcpay.pos.feature.http.utils.HttpUtils;

import java.util.List;

import rx.Observable;


public class BasePresenter<T extends BaseView> {

    protected T mView;//指的是界面，也就是BaseFragment或者BaseActivity

    public void setLifeSubscription(LifeSubscription mLifeSubscription) {
        this.mView = (T) mLifeSubscription;
    }

    protected <T> void invoke(Observable<T> observable, Callback<T> callback) {
        HttpUtils.invoke((LifeSubscription) mView, observable, callback);
    }

    /**
     * 给子类检查返回集合是否为空
     * 这样子做虽然耦合度高，但是接口都不是统一定的，我们没有什么更好的办法
     *
     * @param list
     */
    public void checkState(List list) {
        if (list.size() == 0) {
            if (mView instanceof Stateful)
                ((Stateful) mView).setState(AppConstants.STATE_EMPTY);
            return;
        }
    }
}
