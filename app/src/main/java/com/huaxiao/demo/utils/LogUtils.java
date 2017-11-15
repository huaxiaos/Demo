package com.huaxiao.demo.utils;

import android.util.Log;

/**
 * Created by huaxiao on 17/10/9.
 */

public class LogUtils {

    private static final String TAG = "huaxiao";
    private static volatile LogUtils mInstance;
    private long mTimeStart;
    private long mTimeEnd;

    public static LogUtils getInstance() {
        if (mInstance == null) {
            synchronized (LogUtils.class) {
                if (mInstance == null) {
                    return new LogUtils();
                }
            }
        }

        return mInstance;
    }

    public LogUtils() {

    }

    public static void e(String msg) {
        Log.e(TAG, msg);
    }

    public void timeStart() {
        mTimeStart = System.currentTimeMillis();
        e(mTimeStart + "");
    }

    public void timeEnd() {
        mTimeEnd = System.currentTimeMillis();
        e(mTimeEnd + "");
    }

    public void logTimeDelta() {
        e(String.valueOf(mTimeEnd - mTimeStart));
        mTimeEnd = 0;
        mTimeStart = 0;
    }

}
