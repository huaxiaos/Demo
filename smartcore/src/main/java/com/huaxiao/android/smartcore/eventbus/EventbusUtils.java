package com.huaxiao.android.smartcore.eventbus;

import org.greenrobot.eventbus.EventBus;

/**
 * Description eventbus工具类
 * Author sunhuaxiao
 * Date 2017/11/11
 */

public class EventbusUtils {

    public static void register(Object subscriber) {
        EventBus.getDefault().register(subscriber);
    }

    public static void unregister(Object subscriber) {
        EventBus.getDefault().unregister(subscriber);
    }

    public static void post(Object event) {
        EventBus.getDefault().post(event);
    }

}
