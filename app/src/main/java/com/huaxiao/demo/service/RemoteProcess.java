package com.huaxiao.demo.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;

import com.huaxiao.demo.utils.LogUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by sunhuaxiao on 2018/12/7.
 */
public class RemoteProcess extends Service {

    private static final String TAG = RemoteProcess.class.getSimpleName();
    private String[] mCmd = new String[]{"logcat", "-d", "-v", "time", "-s", "RemoteProcess:I"};

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        LogUtils.i(TAG, "RemoteProcess onBind");
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        LogUtils.i(TAG, "RemoteProcess onCreate");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        LogUtils.i(TAG, "RemoteProcess onStartCommand");

        try {
            Process exec = Runtime.getRuntime().exec(mCmd);
            BufferedReader r = new BufferedReader(new InputStreamReader(exec.getInputStream()));
            StringBuilder total = new StringBuilder();
            for (String line; (line = r.readLine()) != null; ) {
                total.append(line).append('\n');
            }
            LogUtils.i(TAG, "RemoteProcess Logcat " + total.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }

        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        LogUtils.i(TAG, "RemoteProcess onDestroy");
    }

}
