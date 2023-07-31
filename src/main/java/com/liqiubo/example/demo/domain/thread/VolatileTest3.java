package com.liqiubo.example.demo.domain.thread;

import java.util.concurrent.atomic.AtomicInteger;

public class VolatileTest3 {
    public AtomicInteger inc = new AtomicInteger();
    public void increase() {
        inc.getAndIncrement();
    }
    public static void main(String[] args) {
        final VolatileTest3 test = new VolatileTest3();
        for(int i=0;i<10;i++){
            new Thread(){
                public void run() {
                    for(int j=0;j<100;j++)
                        test.increase();
                };
            }.start();
        }
        while(Thread.activeCount()>1)  //保证前面的线程都执行完
            Thread.yield();
        System.out.println("add AtomicInteger, inc output:" + test.inc);
    }
}
