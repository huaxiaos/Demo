package com.huaxiao.demo.utils;

import android.content.Context;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

/**
 * Description 软键盘
 * Author sunhuaxiao
 * Date 2017/11/25
 */

public class SoftKeyboardUtils {

    public static void hide(View view) {
        if (view == null) return;
        InputMethodManager imm = (InputMethodManager) view.getContext()
                .getSystemService(Context.INPUT_METHOD_SERVICE);
        if (imm != null) {
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }

}
