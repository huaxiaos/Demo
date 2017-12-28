package com.huaxiao.demo.utils;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;

/**
 * Description 手机状态监听
 * Author sunhuaxiao
 * Date 2017/9/6
 */

public class PhoneStatusHelper {

    private static final String SYSTEM_DIALOG_REASON_KEY = "reason";
    private static final String SYSTEM_DIALOG_REASON_HOME_KEY = "homekey";

    private Context mContext;
    private PhoneStatusReceiver mReceiver;
    private PhoneStatusListener mListener;

    public PhoneStatusHelper(Context context) {
        mContext = context;
        mReceiver = new PhoneStatusReceiver();
    }

    private class PhoneStatusReceiver extends BroadcastReceiver {

        @Override
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            if (Intent.ACTION_SCREEN_OFF.equals(action)) {
                // 锁屏
                mListener.onScreenOff();
            } else if (Intent.ACTION_CLOSE_SYSTEM_DIALOGS.equals(action)) {
                // Home键
                String reason = intent.getStringExtra(SYSTEM_DIALOG_REASON_KEY);
                if (reason != null) {
                    if (reason.equals(SYSTEM_DIALOG_REASON_HOME_KEY)) {
                        mListener.onHomePress();
                    }
                }
            }
        }

    }

    public void start(PhoneStatusListener listener) {
        mListener = listener;
        registerListener();
    }

    public void stop() {
        mContext.unregisterReceiver(mReceiver);
    }

    private void registerListener() {
        IntentFilter filter = new IntentFilter();
        filter.addAction(Intent.ACTION_SCREEN_OFF);
        filter.addAction(Intent.ACTION_CLOSE_SYSTEM_DIALOGS);
        mContext.registerReceiver(mReceiver, filter);
    }

    public interface PhoneStatusListener {
        void onScreenOff();
        void onHomePress();
    }

}
