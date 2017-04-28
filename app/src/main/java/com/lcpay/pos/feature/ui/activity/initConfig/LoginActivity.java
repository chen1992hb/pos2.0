package com.lcpay.pos.feature.ui.activity.initConfig;

import android.content.Intent;
import android.support.annotation.BinderThread;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.widget.Button;

import com.lcpay.pos.R;
import com.lcpay.pos.app.AppConstants;
import com.lcpay.pos.feature.bean.init.GetUsers;
import com.lcpay.pos.feature.injector.component.init.DaggerInitComponent;
import com.lcpay.pos.feature.injector.module.activity.InitModule;
import com.lcpay.pos.feature.presenter.InitAccountPresenter;
import com.lcpay.pos.feature.presenter.InitLoginPresenter;
import com.lcpay.pos.feature.presenter.impl.InitAccountImpl;
import com.lcpay.pos.feature.presenter.impl.InitLoginPresenterImpl;
import com.lcpay.pos.feature.ui.activity.base.InitDetailBaseActivity;
import com.lcpay.pos.feature.ui.activity.main.MainActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends InitDetailBaseActivity<InitLoginPresenterImpl> implements InitLoginPresenter.View {


    @Override
    protected void loadData() {
        mPresenter.fetchLoginList(AppConstants.MAC_ID);
    }

    @Override
    public int getContentLayoutId() {
        return R.layout.init_login_aty;
    }

    @Override
    protected void initView() {
        ButterKnife.bind(this);


    }

    @OnClick(R.id.bt_login)
    void login() {
        mPresenter.login("7492", "123456");
    }

    @Override
    protected void initInject() {
        DaggerInitComponent.builder().initModule(new InitModule()).build().injectLoginDeatil(this);//inject Presenster
    }


    @Override
    protected void initUI() {

    }

    @Override
    public void refreshView(GetUsers mData) {

    }

    @Override
    public void toMainActivity() {
        Intent it = new Intent();
        it.setClass(this, MainActivity.class);
        startActivity(it);
    }
}
