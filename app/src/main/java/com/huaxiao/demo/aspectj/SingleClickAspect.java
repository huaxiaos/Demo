package com.huaxiao.demo.aspectj;

import android.view.View;

import com.huaxiao.demo.utils.LogUtils;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

import java.util.Calendar;

/**
 * Created by sunhuaxiao on 2018/9/17.
 */
@Aspect
public class SingleClickAspect {

    private static final String TAG = "SingleClickAspect";
    public static final int MIN_CLICK_DELAY_TIME = 600;
    private static Long sLastClick = 0L;

    @Pointcut("execution(* android.view.View.OnClickListener.onClick(..))")
    public void methodAnnotated() {
    }

    @Around("methodAnnotated()")//在连接点进行方法替换
    public void aroundJoinPoint(ProceedingJoinPoint joinPoint) throws Throwable {
        if (System.currentTimeMillis() - sLastClick >= MIN_CLICK_DELAY_TIME) {
            sLastClick = System.currentTimeMillis();
            try {
                joinPoint.proceed();
            } catch (Throwable throwable) {
                throwable.printStackTrace();
            }
        } else {
            LogUtils.i(TAG, "duplicate click");
        }
    }

}
