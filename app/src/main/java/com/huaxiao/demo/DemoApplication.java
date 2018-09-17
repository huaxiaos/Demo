package com.huaxiao.demo;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;

import com.huaxiao.demo.utils.LogUtils;

/**
 * Created by sunhuaxiao on 2018/9/13.
 */
public class DemoApplication extends Application implements Application.ActivityLifecycleCallbacks{

    private static final String TAG = "DemoApplication";

    @Override
    public void onCreate() {
        super.onCreate();

    }

    @Override
    public void onActivityCreated(Activity activity, Bundle savedInstanceState) {
        LogUtils.i(TAG, "onActivityCreated");
    }

    @Override
    public void onActivityStarted(Activity activity) {
        LogUtils.i(TAG, "onActivityStarted");
    }

    @Override
    public void onActivityResumed(Activity activity) {
        LogUtils.i(TAG, "onActivityResumed");
    }

    @Override
    public void onActivityPaused(Activity activity) {
        LogUtils.i(TAG, "onActivityPaused");
    }

    @Override
    public void onActivityStopped(Activity activity) {
        LogUtils.i(TAG, "onActivityStopped");
    }

    @Override
    public void onActivitySaveInstanceState(Activity activity, Bundle outState) {
        LogUtils.i(TAG, "onActivitySaveInstanceState");
    }

    @Override
    public void onActivityDestroyed(Activity activity) {
        LogUtils.i(TAG, "onActivityDestroyed");
    }
}
