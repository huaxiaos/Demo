package com.huaxiao.demo;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;

import com.huaxiao.demo.utils.LogUtils;
import com.tencent.android.tpush.XGIOperateCallback;
import com.tencent.android.tpush.XGPushManager;

/**
 * Created by sunhuaxiao on 2018/9/13.
 */
public class DemoApplication extends Application implements Application.ActivityLifecycleCallbacks{

    private static final String TAG = "DemoApplication";

    @Override
    public void onCreate() {
        super.onCreate();
        XGPushManager.registerPush(this, new XGIOperateCallback() {
            @Override
            public void onSuccess(Object o, int i) {
                LogUtils.i(TAG, "XG token-->" + o);
            }

            @Override
            public void onFail(Object o, int i, String s) {
                LogUtils.i(TAG, "XG fail errCode--> " + i + " errMsg--> " + s);
            }
        });
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
