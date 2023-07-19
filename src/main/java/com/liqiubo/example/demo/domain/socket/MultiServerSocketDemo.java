package com.liqiubo.example.demo.domain.socket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

public class MultiServerSocketDemo {
    public static void main(String[] args) {
        final  AtomicInteger atomicInteger = new AtomicInteger(1);
        try (ServerSocket server = new ServerSocket(8888)) {
            while (true) {
                Socket socket = server.accept();
                atomicInteger.set(atomicInteger.get()+1);
                System.out.println("AtomicInteger Value is:"+atomicInteger.get());
                Thread thread = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        // 套接字处理程序
                        try {
                            InputStream is = socket.getInputStream();
                            OutputStream os = socket.getOutputStream();
                            Scanner scanner = new Scanner(is);
                            // 其他代码省略
                            // 向客户端发送消息
                            PrintWriter pw = new PrintWriter(new OutputStreamWriter(os, "gbk"), true);
                            pw.println("你好啊，欢迎关注「沉默王二」 公众号，回复关键字「2048」 领取程序员进阶必读资料包");
                            // 读取客户端发送过来的消息
                            while (scanner.hasNextLine()) {
                                String line = scanner.nextLine();
                                System.out.println(line);
                            }

                        } catch (IOException e) {
                            e.printStackTrace();
                        } finally {
                            try {
                                socket.close();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                });
                thread.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
