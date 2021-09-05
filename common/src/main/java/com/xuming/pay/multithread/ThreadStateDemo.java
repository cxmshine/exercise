package com.xuming.pay.multithread;

/**
 * 线程状态
 * http://concurrent.redspider.group/article/01/4.html
 *
 * 线程状态见java.lang.Thread.State
 * NEW
 * RUNNABLE
 * BLOCKED
 * WAITING
 * TIMED_WAITING
 * TERMINATED
 *
 * @author xuming.chen
 * @create 2021/8/16 2:38 下午
 **/
public class ThreadStateDemo {


    public static void main(String[] args) {
        startTwice();
    }

    /**
     * 调用start方法两次
     *
     * 查看java.lang.Thread#start()源码可以发现，其内部有一个变量threadStatus
     * 若该值不为0，会直接抛出java.lang.IllegalThreadStateException异常
     * 下方demo，第一次调用start()方法，变量threadStatus值为0
     * 第二次调用start()方法，变量threadStatus的值不为0，直接抛异常
     */
    private static void startTwice() {
        Thread thread = new Thread(() -> {});
        thread.start();
        // 第二次调用时，会抛出java.lang.IllegalThreadStateException异常
        thread.start();
    }
}
