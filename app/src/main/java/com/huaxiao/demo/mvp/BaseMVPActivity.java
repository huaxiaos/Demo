package com.huaxiao.demo.mvp;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.huaxiao.demo.base.BaseActivity;
import com.huaxiao.demo.mvp.BasePresenter;
import com.huaxiao.demo.mvp.IView;

/**
 * Description TODO
 * Author sunhuaxiao
 * Date 2018/4/24
 */
@SuppressLint("Registered")
public abstract class BaseMVPActivity<P extends BasePresenter> extends BaseActivity implements IView<P> {

    private P mPresenter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        setPresenter(getPresenter());
    }

    @Override
    public void setPresenter(P presenter) {
        mPresenter = presenter;
    }
}
