package com.lcpay.pos.feature.http.utils;

import com.lcpay.pos.app.AppConstants;
import com.lcpay.pos.feature.bean.InitCofig;
import com.lcpay.pos.feature.bean.init.GetUsers;
import com.lcpay.pos.feature.bean.init.LoginParams;
import com.lcpay.pos.feature.bean.init.LoginRe;
import com.lcpay.pos.feature.http.service.InitService;

import rx.Observable;

/**
 * Created by admin on 2017/4/27.
 */

public class RetrofitInitUtils extends HttpUtils {
    private InitService mInitService;

    public RetrofitInitUtils(InitService mInitService) {
        this.mInitService = mInitService;
    }

    public Observable<InitCofig> fetchMerchInfo(String id) {
        return mInitService.getInitCofig(id);
    }

    public Observable<GetUsers> fetchUserList(String id) {
        return mInitService.getUserList(id);
    }

    public Observable<LoginRe> login(String operator_id, String pwd) {
        return mInitService.login(getNewPosLogin(operator_id, pwd));
    }

    /**
     * POS登陆接口
     *
     * @param operator_id 终端号
     * @param password    密码
     * @return
     */
    public static LoginParams getNewPosLogin(String operator_id, String password) {
        LoginParams params = new LoginParams();
        params.setOperator_id(operator_id);
        params.setPassword(password);
        params.setMacid(AppConstants.MAC_ID);
        //params.setDevice_token(StaticValues.devicetoken);
        return params;
    }
}
