package com.lcpay.pos.feature.presenter;

import com.lcpay.pos.feature.bean.InitCofig;

/**
 * Created by admin on 2017/4/27.
 */

public interface InitAccountPresenter {

    interface View extends BaseView<InitCofig> {

        /**
         * 机器未注册,需要联系客服
         */
        void needRegister();

        /**
         * 未联网,需要跳转WIFI设置
         */
        void towifiSet();

        /**
         * 初始化成功,根据是否登录跳转登录或者进入主界面
         */
        void toLogin();
    }


    interface Prestenter {

        /**
         * 初始化机器支付配置
         *
         * @param macid
         */
        void fetchinitCongfig(String macid);

        void fetchLoginList(String macid);

    }

    interface ViewActivity extends View {

        /**
         * 设置完主界面需要重新初始化,或点击了重新连接按钮
         *
         * @param macid
         */
        void reConnect(String macid);
    }


}
