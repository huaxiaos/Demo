package com.huaxiao.demo.proxy;

import com.huaxiao.demo.utils.LogUtils;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created by sunhuaxiao on 2018/8/10.
 */
public class TimeInvocationHandler implements InvocationHandler {

    private Object mTarget;
    private static final String TAG = "Proxy";

    public TimeInvocationHandler(Object target) {
        mTarget = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        long start = System.currentTimeMillis();
        Object obj = method.invoke(mTarget, args);
        LogUtils.i(TAG, "time " + (System.currentTimeMillis() - start));
        return obj;
    }
}
