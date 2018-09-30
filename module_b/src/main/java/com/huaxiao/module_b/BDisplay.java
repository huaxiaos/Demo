package com.huaxiao.module_b;

import com.huaxiao.smartspi.IDisplay;

/**
 * Created by sunhuaxiao on 2018/9/30.
 */
public class BDisplay implements IDisplay {
    @Override
    public String display() {
        return "display by module B";
    }
}
