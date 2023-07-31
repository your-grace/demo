package com.liqiubo.example.demo.domain.thread;

/**
 * synchronized 的可重入性
 * 从互斥锁的设计上来说，当一个线程试图操作一个由其他线程持有的对象锁的临界资源时，将会处于阻塞状
 * 态，但当一个线程再次请求自己持有对象锁的临界资源时，这种情况属于重入锁，请求将会成功。
 * synchronized 就是可重入锁，因此一个线程调用 synchronized 方法的同时，在其方法体内部调用该对象另
 * 一个 synchronized 方法是允许的，如下：
 */
public class AccountingSync3 implements Runnable{
    static AccountingSync3 instance=new AccountingSync3();
    static int i=0;
    static int j=0;
    @Override
    public void run() {
        for(int j=0;j<1000000;j++){
            //this,当前实例对象锁
            synchronized(this){
                i++;
                increase();//synchronized的可重入性
            }
        }
    }
    public synchronized void increase(){
        j++;
    }
    public static void main(String[] args) throws InterruptedException {
        Thread t1=new Thread(instance);
        Thread t2=new Thread(instance);
        t1.start();t2.start();
        t1.join();t2.join();
        System.out.println(i);
    }
}
/**
 * 当前实例对象锁后进入 synchronized 代码块执行同步代码，并在代码块中调用了当前实例对象的另外一
 * synchronized 方法，再次请求当前实例锁时，将被允许。需要特别注意另外一种情况，当子类继承父类时，
 * 子类也是可以通过可重入锁调用父类的同步方法。注意由于 synchronized 是基于 monitor 实现的，因此每
 * 次重入，monitor 中的计数器仍会加 1。
 */