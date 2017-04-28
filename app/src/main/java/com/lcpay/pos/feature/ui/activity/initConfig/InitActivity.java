package com.lcpay.pos.feature.ui.activity.initConfig;

import android.content.Intent;
import android.provider.Settings;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;


import com.lcpay.pos.R;
import com.lcpay.pos.app.AppConstants;
import com.lcpay.pos.feature.bean.InitCofig;
import com.lcpay.pos.feature.injector.component.init.DaggerInitComponent;
import com.lcpay.pos.feature.injector.module.activity.InitModule;
import com.lcpay.pos.feature.presenter.InitAccountPresenter;
import com.lcpay.pos.feature.presenter.impl.InitAccountImpl;
import com.lcpay.pos.feature.ui.activity.base.InitDetailBaseActivity;
import com.lcpay.pos.feature.ui.activity.main.MainActivity;
import com.lcpay.pos.model.lcpay.LcpayData;


public class InitActivity extends InitDetailBaseActivity<InitAccountImpl> implements InitAccountPresenter.ViewActivity {

    @Override
    protected void loadData() {
        mPresenter.fetchinitCongfig(AppConstants.MAC_ID);
    }

    //统一处理View初始化
    @Override
    protected void initUI() {

    }

    @Override
    public int getContentLayoutId() {
        return R.layout.init_aty;
    }

    //统一处理Listener
    @Override
    protected void initView() {

    }

    @Override
    protected void initInject() {

        DaggerInitComponent.builder().initModule(new InitModule()).build().injectInitDeatil(this);//inject Presenster
    }


    @Override
    public void refreshView(InitCofig mData) {

    }

    @Override
    public void needRegister() {
        LayoutInflater inflater = getLayoutInflater();
        View view = inflater.inflate(
                R.layout.init_tologin, null);
        TextView id = (TextView) view
                .findViewById(R.id.machinid);
        id.setText(LcpayData.getMacid());
        InitActivity.this.setContentView(view);
    }

    @Override
    public void towifiSet() {
        startActivity(new Intent(Settings.ACTION_WIFI_SETTINGS));
    }

    @Override
    public void toLogin() {
        if (LcpayData.isLogin()) {
            Intent it = new Intent();
            it.setClass(this, MainActivity.class);
            startActivity(it);
            finish();
        } else {
            Intent loginIntent = new Intent(this,
                    LoginActivity.class);
            InitActivity.this.startActivity(loginIntent);
            finish();
        }

    }

    @Override
    public void reConnect(String macid) {
        mPresenter.fetchinitCongfig(AppConstants.MAC_ID);
    }
}
