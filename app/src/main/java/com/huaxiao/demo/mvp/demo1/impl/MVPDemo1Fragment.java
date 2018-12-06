package com.huaxiao.demo.mvp.demo1.impl;

import com.huaxiao.demo.mvp.BaseMVPFragment;
import com.huaxiao.demo.mvp.BasePresenter;
import com.huaxiao.demo.mvp.demo1.IMVPDemo1View;

/**
 * Created by sunhuaxiao on 2018/12/6.
 */
public class MVPDemo1Fragment extends BaseMVPFragment implements IMVPDemo1View {

    @Override
    public int getRootViewId() {
        return 0;
    }

    @Override
    public BasePresenter getPresenter() {
        return null;
    }
}
