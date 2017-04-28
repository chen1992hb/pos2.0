package com.lcpay.pos.feature.presenter.impl;

import android.util.Log;

import com.blankj.utilcode.utils.LogUtils;
import com.blankj.utilcode.utils.ToastUtils;
import com.lcpay.pos.feature.bean.InitCofig;
import com.lcpay.pos.feature.bean.init.GetUsers;
import com.lcpay.pos.feature.bean.init.LoginRe;
import com.lcpay.pos.feature.http.utils.Callback;
import com.lcpay.pos.feature.http.utils.RetrofitInitUtils;
import com.lcpay.pos.feature.presenter.BasePresenter;
import com.lcpay.pos.feature.presenter.InitLoginPresenter;
import com.lcpay.pos.model.lcpay.LcpayData;
import com.lcpay.pos.util.MD5EncryptUtil;

import javax.inject.Inject;

import static android.R.attr.password;

/**
 * Created by admin on 2017/4/28.
 */

public class InitLoginPresenterImpl extends BasePresenter<InitLoginPresenter.View> implements InitLoginPresenter.Prestenter {
    private RetrofitInitUtils mRetrofitInitLoginUtils;

    @Inject
    public InitLoginPresenterImpl(RetrofitInitUtils mRetrofitInitAccountUtils) {
        this.mRetrofitInitLoginUtils = mRetrofitInitAccountUtils;
    }

    @Override
    public void fetchLoginList(String macid) {
        invoke(mRetrofitInitLoginUtils.fetchUserList(macid), new Callback<GetUsers>() {
            @Override
            public void onResponse(GetUsers data) {

                if ("02".equals(data.getResult_code().trim())) {
                    ToastUtils.showLongToast(data.getResult_msg());
                    return;
                }
                if ("01".equals(data.getResult_code())) {
                    LogUtils.i("GetUsers", data);
                    mView.refreshView(data);

                }
            }
        });
    }

    @Override
    public void login(String operator_id, String pwd) {
        String encPassword = MD5EncryptUtil.MD5Encode(pwd);
        invoke(mRetrofitInitLoginUtils.login(operator_id, encPassword), new Callback<LoginRe>() {
            @Override
            public void onResponse(LoginRe data) {
                if ("02".equals(data.getResult_code().trim())) {
                    ToastUtils.showLongToast(data.getResult_msg());
                    return;
                }
                if ("01".equals(data.getResult_code())) {
                    LogUtils.i("LoginRe", data);
                    LcpayData.setOperator(
                            data.getOperator_id(),
                            data.getRole_type(),
                            data.getNickname(),
                            data.getUsername(),
                            data.getPhone(),
                            data.getEmail());
                    mView.toMainActivity();
                }


            }
        });

    }
}
