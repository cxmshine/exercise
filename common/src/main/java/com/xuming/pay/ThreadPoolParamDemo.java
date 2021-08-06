package com.xuming.pay;

import java.util.Date;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 线程池参数探究
 * 参考https://www.cnblogs.com/thisiswhy/p/12690630.html#4915020
 * 相关学习资料https://tech.meituan.com/2020/04/02/java-pooling-pratice-in-meituan.html
 *
 * @author xuming.chen
 * @create 2021/8/1 4:58 下午
 **/
public class ThreadPoolParamDemo {

    /**
     * 分隔符
     */
    private static final String SPLIT_SYMBOL = "-";

    private static final String COLON = ":";

    /**
     * 任务数
     */
    private static final Integer NUMBER_OF_TASK = 15;

    public static void main(String[] args) throws InterruptedException {
        dynamicModifyExecutorParam();
    }

    private static ThreadPoolExecutor buildThreadPoolExecutor() {
        return new ThreadPoolExecutor(2, 5,
                60, TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(10),
                r -> new Thread(r, "thread-pool-param"));
    }

    private static void dynamicModifyExecutorParam() throws InterruptedException {
        ThreadPoolExecutor executor = buildThreadPoolExecutor();
        for (int i = 0; i < NUMBER_OF_TASK; i++) {
            executor.submit(() -> {
                displayThreadPoolStatus(executor, "创建任务");
                try {
                    TimeUnit.SECONDS.sleep(3);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
        }

        /**
         * 当前设置的核心线程数为2，最大线程数为5，workQueue最多放10个任务
         * 若不考虑核心线程数、最大线程数的改变
         * 15个任务进来，则5个线程都工作 且 队列放满任务(10个)
         * 执行完这15个任务需要多少时间呢？
         * 不考虑其他细微的时间，每个任务的执行需要3秒 (TimeUnit.SECONDS.sleep(3);)
         * 前5个任务执行完，花费3秒；
         * 取出队列中存放的前5个任务并执行，花费3秒；
         * 取出队列中存放的余下5个任务并执行，花费3秒；
         * 则15个任务执行完共花费 3 * 3 = 9秒
         *
         */
        displayThreadPoolStatus(executor, "改变参数之前");
        TimeUnit.SECONDS.sleep(1);
        // 核心线程数设为10
        executor.setCorePoolSize(10);
        // 最大线程数也设置为10
        executor.setMaximumPoolSize(10);
        // 对线程池进行预热，Starts all core threads，启动所有核心线程
        executor.prestartAllCoreThreads();
        // 对线程池进行预热，Starts a core thread，启动一个
//        executor.prestartCoreThread();
        displayThreadPoolStatus(executor, "改变参数之后");
        Thread.currentThread().join();
    }

    private static void displayThreadPoolStatus(ThreadPoolExecutor executor, String threadName) {
        LinkedBlockingQueue queue = (LinkedBlockingQueue)executor.getQueue();
        System.out.println(new Date() +
                Thread.currentThread().getName() + SPLIT_SYMBOL + threadName + SPLIT_SYMBOL + COLON +
                "核心线程数:" + executor.getCorePoolSize() +
                "活跃线程数:" + executor.getActiveCount() +
                "最大线程数:" + executor.getMaximumPoolSize() +
                "线程池活跃度:" + divide(executor.getActiveCount(), executor.getMaximumPoolSize()) +
                "任务完成数:" + executor.getCompletedTaskCount() +
                "队列大小:" + (queue.size() + queue.remainingCapacity()) +
                "当前排队任务数:" + queue.size() +
                "队列剩余大小:" + queue.remainingCapacity() +
                "队列使用度:" + divide(queue.size(), queue.size() + queue.remainingCapacity()));
    }

    private static String divide(int num1, int num2) {
        return String.format("%1.2f%%",
                Double.parseDouble(String.valueOf(num1)) / Double.parseDouble(String.valueOf(num2)) * 100);
    }
}
