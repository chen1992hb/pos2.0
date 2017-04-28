package com.lcpay.pos.feature.presenter.impl;

import com.blankj.utilcode.utils.LogUtils;
import com.blankj.utilcode.utils.NetworkUtils;
import com.lcpay.pos.feature.bean.InitCofig;
import com.lcpay.pos.feature.bean.init.GetUsers;
import com.lcpay.pos.feature.http.utils.Callback;
import com.lcpay.pos.feature.http.utils.RetrofitInitUtils;
import com.lcpay.pos.feature.presenter.BasePresenter;
import com.lcpay.pos.feature.presenter.InitAccountPresenter;
import com.lcpay.pos.model.lcpay.LcpayData;

import javax.inject.Inject;

/**
 * Created by admin on 2017/4/27.
 */

public class InitAccountImpl extends BasePresenter<InitAccountPresenter.ViewActivity> implements InitAccountPresenter.Prestenter {
    private RetrofitInitUtils mRetrofitInitAccountUtils;

    @Inject
    public InitAccountImpl(RetrofitInitUtils mRetrofitInitAccountUtils) {
        this.mRetrofitInitAccountUtils = mRetrofitInitAccountUtils;
    }


    @Override
    public void fetchinitCongfig(String macid) {
        if (!NetworkUtils.isAvailableByPing()) {
            mView.towifiSet();
            return;
        }
        invoke(mRetrofitInitAccountUtils.fetchMerchInfo(macid), new Callback<InitCofig>() {
            @Override
            public void onResponse(InitCofig data) {

                if ("02".equals(data.getResult_code().trim())) {
                    mView.needRegister();
                    return;
                }
                if ("01".equals(data.getResult_code())) {
                    LogUtils.i("initData", data);
                    // 存微信支付宝的配置
                    LcpayData.setLcpayConfig(data.getId(),
                            data.getMerchant_name(),
                            data.getMerchant_no(),
                            data.getStore_id(),
                            data.getStore_name(),
                            data.getTerminal_id(),
                            data.getAccess_token());
                    mView.toLogin();
                }
            }
        });
    }

    @Override
    public void fetchLoginList(String macid) {
        invoke(mRetrofitInitAccountUtils.fetchUserList(macid), new Callback<GetUsers>() {
            @Override
            public void onResponse(GetUsers data) {

            }
        });
    }
}
