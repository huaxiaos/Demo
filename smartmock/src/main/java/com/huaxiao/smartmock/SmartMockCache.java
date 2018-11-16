package com.huaxiao.smartmock;

/**
 * Created by sunhuaxiao on 2018/11/16.
 */
public class SmartMockCache {

    private static volatile SmartMockCache mInstance;

    public static SmartMockCache getInstance() {
        if (mInstance == null) {
            synchronized (SmartMockCache.class) {
                if (mInstance == null) {
                    mInstance = new SmartMockCache();
                }
            }
        }

        return mInstance;
    }

}
