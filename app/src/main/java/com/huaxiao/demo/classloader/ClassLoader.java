package com.huaxiao.demo.classloader;

/**
 * Description TODO
 * Author sunhuaxiao
 * Date 2018/5/17
 */

public class ClassLoader {

    public static void main(String[] args) {
        new B();
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

    static class A {
        static {
            System.out.println("A1");
        }
        {
            System.out.println("A2");
        }

        public A() {
            System.out.println("A3");
        }
    }

    static class B extends A {
        static {
            System.out.println("B1");
        }
        {
            System.out.println("B2");
        }

        public B() {
            System.out.println("B3");
        }
    }

}
