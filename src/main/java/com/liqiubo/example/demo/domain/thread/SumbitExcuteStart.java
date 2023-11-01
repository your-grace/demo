package com.liqiubo.example.demo.domain.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class SumbitExcuteStart {
    public static void main(String[] args) {
        /**
         * 1. submit方法：
         * submit方法用于向线程池提交一个任务，并返回一个表示任务执行结果的Future对象。它适用于需要获取任务执行结果的场景。
         */
        ExecutorService executorService = Executors.newFixedThreadPool(1);
        Future<String> future = executorService.submit(() -> {
            // 执行任务，返回结果
            return "Task-submit executed successfully";
        });
        try {
            String result = future.get(); // 获取任务执行结果
            System.out.println(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
        executorService.shutdown();

        /**
         * 2. execute方法：
         * execute方法用于向线程池提交一个任务，不返回执行结果。它适用于不需要获取任务执行结果的场景。
         */
        ExecutorService executorService2 = Executors.newFixedThreadPool(1);
        executorService2.execute(() -> {
            // 执行任务，不返回结果
            System.out.println("Task-execute executed successfully");
        });
        executorService2.shutdown();

        /**
         * 3. start方法：
         * start方法用于启动一个线程，并执行其run方法中的代码。它适用于直接创建和启动线程的场景。
         */
        Thread thread = new Thread(() -> {
            // 执行任务
            System.out.println("Thread-start executed successfully");
        });
        thread.start(); // 启动线程
    }
}
/**
 * 总结：
 * - submit方法适用于需要获取任务执行结果的场景，返回一个Future对象。
 * - execute方法适用于不需要获取任务执行结果的场景。
 * - start方法适用于直接创建和启动线程的场景。
 */