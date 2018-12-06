package com.huaxiao.demo.mvp;

import android.content.Context;

/**
 * Created by sunhuaxiao on 2018/12/3.
 */
public class BasePresenter<V extends IView> {

    private V mView;
    private Context mContext;

    public BasePresenter(Context context, V view) {
        this.mContext = context;
        this.mView = view;
    }

}
