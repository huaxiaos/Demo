package com.huaxiao.demo.proxy;

import com.huaxiao.demo.utils.LogUtils;

/**
 * Created by sunhuaxiao on 2018/8/10.
 */
public class OperateImpl implements IOperate {

    private static final String TAG = "Proxy";

    @Override
    public void method1() {
        sleep(100);
        LogUtils.i(TAG, "sleep method1");
    }

    @Override
    public void method2() {
        sleep(200);
        LogUtils.i(TAG, "sleep method2");
    }

    @Override
    public void method3() {
        sleep(300);
        LogUtils.i(TAG, "sleep method3");
    }

    private void sleep(long m) {
        try {
            Thread.sleep(m);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
