package com.huaxiao.demo.utils;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.widget.TextView;

/**
 * Description Drawable
 * Author sunhuaxiao
 * Date 2017/12/1
 */

public class DrawableUtils {

    public static Drawable getDrawable(Context context, int id) {
        return ContextCompat.getDrawable(context, id);
    }

    public static void setDrawableLeft(Context context, int id, TextView textView) {
        Drawable img = getDrawable(context, id);
        textView.setCompoundDrawablesWithIntrinsicBounds(img, null, null, null);
    }

    public static void removeAllDrawable(TextView textView) {
        textView.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
    }

}
