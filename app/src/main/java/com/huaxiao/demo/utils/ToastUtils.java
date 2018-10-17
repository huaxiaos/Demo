package com.huaxiao.demo.utils;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by sunhuaxiao on 2018/10/17.
 */
public class ToastUtils {

    public static void show(Context context, String text) {
        Toast.makeText(context, text, Toast.LENGTH_SHORT).show();
    }

}
