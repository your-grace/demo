package com.liqiubo.example.demo.domain.thread;

/**
 * 一个线程 A 需要访问实例对象 obj1 的 synchronized 方法 f1(当前对象锁是 obj1)，另一个线程 B 需要访
 * 问实例对象 obj2 的 synchronized 方法 f2(当前对象锁是 obj2)，这样是允许的：
 */
public class AccountingSyncBad implements Runnable{
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
        // new 两个AccountingSync新实例
        Thread t1 = new Thread(new AccountingSyncBad());
        Thread t2 = new Thread(new AccountingSyncBad());
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println("static, i output:" + i);
    }
}
/**
 * 输出结果:
 * static, i output:1224617
 */
/**
 * 上述代码与前面不同的是我们同时创建了两个新实例 AccountingSyncBad，然后启动两个不同的线程对共享
 * 变量 i 进行操作，但很遗憾操作结果是 1224617 而不是期望结果 2000000，因为上述代码犯了严重的错误，
 * 虽然我们使用 synchronized 修饰了 increase 方法，但却 new 了两个不同的实例对象，这也就意味着存在着
 * 两个不同的实例对象锁，因此 t1 和 t2 都会进入各自的对象锁，也就是说 t1 和 t2 线程使用的是不同的锁，
 * 因此线程安全是无法保证的。
 */