package com.huaxiao.demo.utils;

import java.math.BigDecimal;

/**
 * Description 数字工具类
 * Author sunhuaxiao
 * Date 2017/12/26
 */

public class NumberUtils {

    /**
     * 设置小数点位数
     * 若double d=0，输出结果为0.0；
     * 若double d=1.999，输出结果为2.0；
     * 若double d=1.89，输出结果为1.89；
     *
     * @param num   原数字
     * @param digit 小数点位数
     * @return double 四舍五入
     */
    public static double setDecimalPoint(double num, int digit) {
        BigDecimal bigDecimal = new BigDecimal(num);
        return bigDecimal.setScale(digit, BigDecimal.ROUND_HALF_UP).doubleValue();
    }

}
