package com.huaxiao.demo.mvp;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.huaxiao.android.smartcore.base.BaseActivity;

/**
 * Description TODO
 * Author sunhuaxiao
 * Date 2018/4/24
 */
@SuppressLint("Registered")
public abstract class BaseMVPActivity<P extends BasePresenter> extends BaseActivity implements IView<P> {

    private P mPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setPresenter(getPresenter());
        getLifecycle().addObserver(mPresenter);
    }

    @Override
    public void setPresenter(P presenter) {
        mPresenter = presenter;
    }

}
