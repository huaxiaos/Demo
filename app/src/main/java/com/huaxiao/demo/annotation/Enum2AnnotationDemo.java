package com.huaxiao.demo.annotation;

import android.support.annotation.StringDef;

/**
 * Created by sunhuaxiao on 2018/12/19.
 */
@StringDef({Enum2AnnotationDemo.KEY_1, Enum2AnnotationDemo.KEY_2, Enum2AnnotationDemo.KEY_3})
public @interface Enum2AnnotationDemo {

    String KEY_1 = "key_1";
    String KEY_2 = "key_2";
    String KEY_3 = "key_3";

}
