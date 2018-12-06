package com.huaxiao.demo.mvp.demo1.impl;

import android.os.Bundle;

import com.huaxiao.demo.mvp.BaseMVPActivity;
import com.huaxiao.demo.mvp.BasePresenter;
import com.huaxiao.demo.mvp.demo1.IMVPDemo1View;

public class MVPDemo1Activity extends BaseMVPActivity implements IMVPDemo1View {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public BasePresenter getPresenter() {
        return null;
    }
}
