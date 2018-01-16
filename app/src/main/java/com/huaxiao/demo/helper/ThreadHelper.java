package com.huaxiao.demo.helper;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Description 线程管理
 * Author sunhuaxiao
 * Date 2018/1/13
 */

public class ThreadHelper {

    private static volatile ThreadHelper mInstance;
    private ExecutorService mGlobalThreadPool;

    public static ThreadHelper getInstance() {
        if (mInstance == null) {
            synchronized (ThreadHelper.class) {
                if (mInstance == null) {
                    mInstance = new ThreadHelper();
                }
            }
        }

        return mInstance;
    }

    private ThreadHelper() {
        mGlobalThreadPool = Executors.newCachedThreadPool();
    }

    public ExecutorService getGlobalThreadPool() {
        return mGlobalThreadPool;
    }

}
