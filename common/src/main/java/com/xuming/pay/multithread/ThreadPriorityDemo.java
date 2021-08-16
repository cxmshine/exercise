package com.xuming.pay.multithread;

import java.util.stream.IntStream;

/**
 * 线程优先级
 * http://concurrent.redspider.group/article/01/3.html
 *
 * Java程序中对线程所设置的优先级只是给操作系统一个建议，操作系统不一定会采纳。真正的调用顺序是由操作系统的线程调度算法决定的。
 *
 * @author xuming.chen
 * @create 2021/8/16 2:18 下午
 **/
public class ThreadPriorityDemo {

    /**
     * 最终的输出是：
     * 线程组的优先级=6
     * 线程的优先级=6
     *
     * 所以，如果某个线程优先级大于线程所在线程组的最大优先级，那么该线程的优先级将会失效，取而代之的是线程组的最大优先级。
     *
     * @param args
     */
    public static void main(String[] args) {
        /*** demo1 ***/
        ThreadGroup threadGroup = new ThreadGroup("t1");
        // 设置线程组优先级为6
        threadGroup.setMaxPriority(6);
        Thread thread = new Thread(threadGroup, "thread-1");
        // 设置线程优先级是9
        thread.setPriority(9);
        System.out.println("线程组的优先级=" + threadGroup.getMaxPriority());
        System.out.println("线程的优先级=" + thread.getPriority());

        /*** demo2 ***/
        validateThreadPriority();
    }

    public static class Thread1 extends Thread {
        @Override
        public void run() {
            super.run();
            System.out.println(String.format("当前执行的线程是：%s，优先级：%d",
                    Thread.currentThread().getName(),
                    Thread.currentThread().getPriority()));
        }
    }

    /**
     * 验证线程优先级
     * 优先级高的,不一定先执行
     */
    private static void validateThreadPriority() {
        IntStream.range(1, 10).forEach(i -> {
            Thread thread = new Thread(new Thread1());
            thread.setPriority(i);
            thread.start();
        });
    }



}
