package com.huaxiao.demo.mvp.demo1.impl;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.huaxiao.demo.R;
import com.huaxiao.demo.mvp.BaseMVPActivity;
import com.huaxiao.demo.mvp.BasePresenter;
import com.huaxiao.demo.mvp.demo1.MVPDemo1Presenter;

public class MVPDemo1Activity extends BaseMVPActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_mvpdemo1);
    }

    @Override
    public BasePresenter getPresenter() {
        return new MVPDemo1Presenter(this, this);
    }
}
