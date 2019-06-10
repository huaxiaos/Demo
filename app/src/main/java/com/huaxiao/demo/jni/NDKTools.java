package com.huaxiao.demo.jni;

/**
 * Created by sunhuaxiao on 2019-06-10.
 */
public class NDKTools {

    static {
        System.loadLibrary("native-lib");
    }

    public static native String getStringFromNDK();

}
