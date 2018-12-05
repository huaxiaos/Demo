package com.huaxiao.demo.generic;

import android.util.Log;

import com.huaxiao.demo.IDemo;

/**
 * Created by sunhuaxiao on 2018/12/3.
 */
public class GenericDemo<T extends GenericBean> implements IDemo {

    public T mBean;

    public GenericDemo() {
    }

    public void setGenericBean(T bean) {
        mBean = bean;
    }

    @Override
    public void start() {
        GenericBean bean = new GenericBean();
        bean.value = "123";
        GenericDemo<GenericBean> a = new GenericDemo<>();
    }
}
