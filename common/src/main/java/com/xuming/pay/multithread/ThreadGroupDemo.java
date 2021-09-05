package com.xuming.pay.multithread;

/**
 * 线程组demo
 * http://concurrent.redspider.group/article/01/3.html
 *
 * @author xuming.chen
 * @create 2021/9/5 2:12 下午
 **/
public class ThreadGroupDemo {

    public static void main(String[] args) {
        Thread testThread = new Thread(() -> {
            // testThread所属线程组名字：main
            // new Thread时若没有显式指定线程组，则默认将父线程(当前执行new Thread的线程)线程组设置为自己的线程组。
            System.out.println("testThread所属线程组名字：" +
                    Thread.currentThread().getThreadGroup().getName());
            System.out.println("testThread线程名字：" +
                    Thread.currentThread().getName());
        });

        testThread.start();

        System.out.println("执行main()方法所属线程组名字：" +
                Thread.currentThread().getThreadGroup().getName());
        System.out.println("执行main()方法线程名字：" + Thread.currentThread().getName());
    }
}
