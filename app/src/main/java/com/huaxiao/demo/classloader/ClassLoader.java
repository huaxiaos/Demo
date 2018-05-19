package com.huaxiao.demo.classloader;

/**
 * Description TODO
 * Author sunhuaxiao
 * Date 2018/5/17
 */

public class ClassLoader {

    public static void main(String[] args) {
        System.out.println(FinalTest.NUM);
        System.out.println(FinalTest1.NUM);
    }

    static class FinalTest {
        public static final int NUM = 3;

        static {
            System.out.println("hello");
        }
    }

    static class FinalTest1 {
        public static int NUM = 5;

        static {
            System.out.println("hello1");
        }
    }

}
