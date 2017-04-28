package com.lcpay.pos.feature.ui.activity.base;

import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.TextView;

import com.lcpay.pos.R;
import com.lcpay.pos.feature.presenter.BasePresenter;


/**
 * Created by quantan.liu on 2017/3/24.
 * 只要是头部和这个一样的都可以用这个Activity,底下可以自己定义。
 */

public abstract class InitDetailBaseActivity<T extends BasePresenter> extends LoadingBaseActivity<T> {

    @Override
    protected int getLayoutId() {
        return R.layout.init_aty;
    }

    @Override
    public int setFrameLayoutId() {
        return R.id.fl_root;
    }

}
