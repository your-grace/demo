package com.liqiubo.example.demo.domain.thread;

public class ThreadGroupDemo {
    public static void main(String[] args) {
        ThreadGroup threadGroup1 = new ThreadGroup("group1") {
            // 继承ThreadGroup并重新定义以下方法
            // 在线程成员抛出unchecked exception
            // 会执行此方法
            public void uncaughtException(Thread t, Throwable e) {
                System.out.println(t.getName() + ": " + e.getMessage());
            }
        };

        // 这个线程是threadGroup1的一员
        Thread thread1 = new Thread(threadGroup1, new Runnable() {
            public void run() {
                // 抛出unchecked异常
                throw new RuntimeException("测试异常");
            }
        });

        thread1.start();
    }
}
//获取当前的线程组名字
//Thread.currentThread().getThreadGroup().getName()

//复制线程组
// 获取当前的线程组
//ThreadGroup threadGroup = Thread.currentThread().getThreadGroup();
//    // 复制一个线程组到一个线程数组（获取Thread信息）
//    Thread[] threads = new Thread[threadGroup.activeCount()];
//threadGroup.enumerate(threads);