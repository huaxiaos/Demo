package com.huaxiao.demo.broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import com.huaxiao.demo.utils.LogUtils;

/**
 * Created by sunhuaxiao on 2018/9/28.
 */
public class DemoBroadcastReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        LogUtils.i("BroadcastDemo", "DemoBroadcastReceiver onReceive");
    }

}
