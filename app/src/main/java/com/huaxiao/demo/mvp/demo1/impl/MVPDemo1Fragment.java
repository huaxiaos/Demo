package com.huaxiao.demo.mvp.demo1.impl;

import com.huaxiao.demo.R;
import com.huaxiao.demo.mvp.BaseMVPFragment;
import com.huaxiao.demo.mvp.BasePresenter;
import com.huaxiao.demo.mvp.demo1.IMVPDemo1View;
import com.huaxiao.demo.mvp.demo1.MVPDemo1Presenter;

/**
 * Created by sunhuaxiao on 2018/12/6.
 */
public class MVPDemo1Fragment extends BaseMVPFragment implements IMVPDemo1View {

    @Override
    public int getRootViewId() {
        return R.layout.view_mvpdemo1;
    }

    @Override
    public BasePresenter getPresenter() {
        return new MVPDemo1Presenter(getContext(), this);
    }

}
