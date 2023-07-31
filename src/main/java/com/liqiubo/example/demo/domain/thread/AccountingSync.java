package com.liqiubo.example.demo.domain.thread;


/**
 * synchronized 作用于实例方法
 * 所谓的实例对象锁就是用 synchronized 修饰实例对象中的实例方法，注意是实例方法不包括静态方法，如下：
 */
public class AccountingSync implements Runnable{
    //共享资源(临界资源)
    static int i = 0;
    // synchronized 修饰实例方法
    public synchronized void increase() {
        i ++;
    }
    @Override
    public void run() {
        for(int j=0;j<1000000;j++){
            increase();
        }
    }
    public static void main(String args[]) throws InterruptedException {
        AccountingSync instance = new AccountingSync();
        Thread t1 = new Thread(instance);
        Thread t2 = new Thread(instance);
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println("static, i output:" + i);
    }
}
/**
 * 输出结果:
 * static, i output:2000000
 */