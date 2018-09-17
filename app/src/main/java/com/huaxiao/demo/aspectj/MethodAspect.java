package com.huaxiao.demo.aspectj;

import com.huaxiao.demo.utils.LogUtils;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

/**
 * Created by sunhuaxiao on 2018/9/17.
 */
@Aspect
public class MethodAspect {

    private static final String TAG = "MethodAspect";

    @Pointcut("call(* com.huaxiao.demo.aspectj.AspectJ1.run(..))")
    public void callMethod() {

    }

    @Before("callMethod()")
    public void beforCallMethod(JoinPoint joinPoint) {
        LogUtils.i(TAG, "before->" + joinPoint.getTarget().toString() + "#" + joinPoint.getSignature().getName());
    }

}
