package com.huaxiao.demo.java;

import com.huaxiao.demo.utils.LogUtils;

/**
 * Description TODO
 * Author sunhuaxiao
 * Date 2018/5/21
 */

public class SynchronizedDemo {

    private static final String TAG = "SynchronizedDemo";

    public static synchronized void test1() {
        test2();
        LogUtils.i(TAG, "test1");
    }

    public static synchronized void test2() {
        LogUtils.i(TAG, "test2");
    }

}
