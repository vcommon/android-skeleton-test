package com.diyerland;

/**
 * 单件模式
 */
public class SingletonPattern {
    /**
     *
     * 最简单的单件方式。
     * 使用上的限制，构造函数不能有参数。大多情况下，都需要参数初始化来保证类的调用顺序问题。
     */
    public static class Singleton1 {
        private Singleton1() {
        }

        //在自己内部定义自己一个实例，是不是很奇怪？
        //注意这是 private 只供内部调用
        private static Singleton1 instance = new Singleton1();

        //这里提供了一个供外部访问本 class 的静态方法，可以直接访问
        public static Singleton1 getInstance() {
            return instance;
        }
    }

    /**
     * 效率问题，每次都synchronized，其实第一次之后，完全不需要了，效率被浪费了。
     */
    public static class Singleton2 {
        private static Singleton2 instance = null;
        public static synchronized Singleton2 getInstance() {
            //这个方法比上面有所改进，不用每次都进行生成对象，只是第一次
            //使用时生成实例，提高了效率！
            if (instance==null)
                instance = new Singleton2();
            return instance;
        }
    }

    /**
     * 解决了效率问题，double-checked locking问题。
     * 由于Java的内存模型。如果多线程同时调用，导致第二个进入getInstance时单件未初始化，即被返回。
     */
    public static class Singleton3 {
        private static Singleton3 instance = null;

        public static Singleton3 getInstance() {
            if (instance == null) {
                synchronized (Singleton3.class) {
                    if (instance == null) {
                        instance = new Singleton3();
                    }
                }
            }
            return instance;
        }
    }

    /**
     * 解决Java的DCL（double-checked locking）
     */
    public static class Singleton {
        private volatile static Singleton instance = null;

        public static Singleton getInstance() {
            if (instance == null) {
                synchronized (Singleton.class) {
                    if (instance == null) {
                        instance = new Singleton();
                    }
                }
            }
            return instance;
        }
    }
}