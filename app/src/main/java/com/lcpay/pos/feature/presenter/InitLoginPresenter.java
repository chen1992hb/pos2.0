package com.lcpay.pos.feature.presenter;

import com.lcpay.pos.feature.bean.InitCofig;
import com.lcpay.pos.feature.bean.init.GetUsers;
import com.lcpay.pos.feature.ui.activity.main.MainActivity;

/**
 * Created by admin on 2017/4/28.
 */

public interface InitLoginPresenter {
    interface View extends BaseView<GetUsers> {
        void toMainActivity();
    }

    interface Prestenter {

        /**
         * 获取用户列表
         *
         * @param macid
         */
        void fetchLoginList(String macid);

        /*
            *登录
             */
        void login(String operator_id, String pwd);
    }
}
