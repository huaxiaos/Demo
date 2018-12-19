package com.huaxiao.demo.annotation;

import com.huaxiao.demo.utils.LogUtils;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Description TODO
 * Author sunhuaxiao
 * Date 2018/5/19
 */

public class AnnotationDemo {

    private static final String TAG = "AnnotationDemo";

    @BindPort
    private String port;

    public void start() {
        LogUtils.i(TAG, "port p1 " + port);

        try {
            Class clazz = Class.forName("com.huaxiao.demo.annotation.AnnotationDemo");
            AnnotationDemo demo = (AnnotationDemo) clazz.newInstance();
            Field[] fields = clazz.getDeclaredFields();
            for (Field field : fields) {
                if (field.isAnnotationPresent(BindPort.class)) {
                    BindPort bindPort = field.getAnnotation(BindPort.class);
                    field.setAccessible(true);
                    field.set(demo, bindPort.value());
                }
            }

            LogUtils.i(TAG, "port p2 " + demo.port);

            Method[] methods = clazz.getDeclaredMethods();
            for (Method method : methods) {
                if (method.isAnnotationPresent(BindGet.class)) {
                    BindGet bindGet = method.getAnnotation(BindGet.class);
                    String param = bindGet.value();
                    method.invoke(demo, param);
                }
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        enum2Annotation(Enum2AnnotationDemo.KEY_1);
    }

    @BindGet
    public void get(String param) {
        LogUtils.i(TAG, "get() " + param);
    }

    public void enum2Annotation(@Enum2AnnotationDemo String value) {
        LogUtils.i(TAG, "enum2Annotation value " + value);
    }
}
