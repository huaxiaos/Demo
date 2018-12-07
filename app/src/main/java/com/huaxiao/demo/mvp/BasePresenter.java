package com.huaxiao.demo.mvp;

import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleObserver;
import android.arch.lifecycle.OnLifecycleEvent;
import android.content.Context;

import com.huaxiao.demo.utils.LogUtils;

/**
 * Created by sunhuaxiao on 2018/12/3.
 */
public class BasePresenter<V extends IView> implements LifecycleObserver {

    private static final String TAG = BasePresenter.class.getSimpleName();
    private V mView;
    private Context mContext;

    public BasePresenter(Context context, V view) {
        this.mContext = context;
        this.mView = view;
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    public void onCreate() {
        LogUtils.i(TAG, "onCreate");
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    public void onResume() {
        LogUtils.i(TAG, "onResume");
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public void onDestory() {
        LogUtils.i(TAG, "onDestory");
    }
}
