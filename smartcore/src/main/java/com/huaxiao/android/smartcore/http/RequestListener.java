package com.huaxiao.android.smartcore.http;

/**
 * Created by sunhuaxiao on 2019/1/8.
 */
public interface RequestListener<T> {

    void onResponse(T t);

    void onFailure(Throwable t);
}
