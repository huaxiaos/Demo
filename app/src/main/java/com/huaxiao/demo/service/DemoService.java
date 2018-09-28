package com.huaxiao.demo.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;

import com.huaxiao.demo.utils.LogUtils;

/**
 * Created by sunhuaxiao on 2018/9/28.
 */
public class DemoService extends Service {

    @Override
    public void onCreate() {
        super.onCreate();
        LogUtils.i("DemoService", "DemoService onCreate");
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        LogUtils.i("DemoService", "DemoService onBind");
        return null;
    }
}
