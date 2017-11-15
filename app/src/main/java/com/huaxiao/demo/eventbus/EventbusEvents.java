package com.huaxiao.demo.eventbus;

/**
 * Description 事件统一管理
 * Author sunhuaxiao
 * Date 2017/11/11
 */

public class EventbusEvents {

    public static class DemoEvent {
        public boolean demo;

        public DemoEvent(boolean demo) {
            this.demo = demo;
        }
    }

}
