package com.huaxiao.demo.retrofit;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Created by sunhuaxiao on 2019/1/7.
 */
@Target(METHOD)
@Retention(RUNTIME)
public @interface Domain {
    String value() default "";
}
