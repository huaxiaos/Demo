package com.huaxiao.module_a;

import android.view.Display;

import com.huaxiao.smartspi.IDisplay;

/**
 * Created by sunhuaxiao on 2018/9/30.
 */
public class ADisplay implements IDisplay {
    @Override
    public String display() {
        return "display by module A";
    }
}
