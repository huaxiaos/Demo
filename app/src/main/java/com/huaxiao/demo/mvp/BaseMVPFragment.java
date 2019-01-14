package com.huaxiao.demo.mvp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.huaxiao.android.smartcore.base.BaseFragment;

/**
 * Created by sunhuaxiao on 2018/12/6.
 */
public abstract class BaseMVPFragment<P extends BasePresenter> extends BaseFragment implements
        IView<P> {

    private P mPresenter;
    private View mRootView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        setPresenter(getPresenter());
        getLifecycle().addObserver(mPresenter);
        mRootView = inflater.inflate(getRootViewId(), container, false);
        return mRootView;
    }

    @Override
    public void setPresenter(P presenter) {
        mPresenter = presenter;
    }

    public abstract int getRootViewId();

}
