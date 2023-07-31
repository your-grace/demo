package com.liqiubo.example.demo.domain.thread;

/**
 * synchronized 作用于静态方法
 * 当 synchronized 作用于静态方法时，其锁就是当前类的 class 锁，不属于某个对象。
 * 当前类 class 锁被获取，不影响对象锁的获取，两者互不影响。
 * 由于静态成员不专属于任何一个实例对象，是类成员，因此通过 class 对象锁可以控制静态成员的并发操
 * 作。需要注意的是如果一个线程 A 调用一个实例对象的非 static synchronized 方法，而线程 B 需要调用这个
 * 实例对象所属类的静态 synchronized 方法，不会发生互斥现象，因为访问静态 synchronized 方法占用的锁
 * 是当前类的 class 对象，而访问非静态 synchronized 方法占用的锁是当前实例对象锁，看如下代码：
 */
public class AccountingSyncClass implements Runnable{
    static int i = 0;
    /**
     * 作用于静态方法,锁是当前class对象,也就是
     * AccountingSyncClass类对应的class对象
     */
    public static synchronized void increase() {
        i++;
    }
    // 非静态,访问时锁不一样不会发生互斥
    public synchronized void increase4Obj() {
        i++;
    }
    @Override
    public void run() {
        for(int j=0;j<1000000;j++){
            increase();
        }
    }
    public static void main(String[] args) throws InterruptedException {
        //new新实例
        Thread t1=new Thread(new AccountingSyncClass());
        //new新实例
        Thread t2=new Thread(new AccountingSyncClass());
        //启动线程
        t1.start();t2.start();
        t1.join();t2.join();
        System.out.println(i);
    }
}
/**
 * 输出结果:
 * 2000000
 */
/**
 * 由于 synchronized 关键字修饰的是静态 increase 方法，与修饰实例方法不同的是，其锁对象是当前类的
 * class 对象。注意代码中的 increase4Obj 方法是实例方法，其对象锁是当前实例对象，如果别的线程调用该
 * 方法，将不会产生互斥现象，毕竟锁对象不同，但我们应该意识到这种情况下可能会发现线程安全问题(操作
 * 了共享静态变量 i)。
 */
