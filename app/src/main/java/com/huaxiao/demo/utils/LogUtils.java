package com.huaxiao.demo.utils;

import android.util.Log;

import com.huaxiao.demo.BuildConfig;

/**
 * Created by huaxiao on 17/10/9.
 */

public class LogUtils {

    private static final String TAG = "huaxiao";
    private static volatile LogUtils mInstance;
    private long mTimeStart;
    private long mTimeEnd;
    private static final boolean debug = BuildConfig.DEBUG;

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

    public static void d(String msg) {
        d(TAG, msg);
    }

    public static void d(String tag, String msg) {
        if (debug) {
            Log.d(tag, msg);
        }
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
