package com.huaxiao.demo.utils;

import com.alibaba.fastjson.JSON;

import java.util.List;

/**
 * Description Gson解析工具类
 * Author sunhuaxiao
 * Date 2017/11/7
 */

public class JsonUtils {

    public static <T> T parseObject(String text, Class<T> clazz) {
        return JSON.parseObject(text, clazz);
    }

    public static <T> List<T> parseArray(String text, Class<T> clazz) {
        return JSON.parseArray(text, clazz);
    }

    public static String parseObject(Object o) {
        return JSON.toJSONString(o);
    }

}
