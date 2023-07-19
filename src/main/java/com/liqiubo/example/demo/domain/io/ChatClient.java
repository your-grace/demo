package com.liqiubo.example.demo.domain.io;

import java.io.*;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.nio.charset.StandardCharsets;

public class ChatClient {
    private Selector selector;
    private SocketChannel socketChannel;
    private static final String HOST = "localhost";
    private static final int PORT = 8080;

    public ChatClient() {
        try {
            selector = Selector.open();
            socketChannel = SocketChannel.open(new InetSocketAddress(HOST, PORT));
            socketChannel.configureBlocking(false);
            socketChannel.register(selector, SelectionKey.OP_READ);
            System.out.println("连接到聊天室了");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void start() {
        new Thread(() -> {
            try {
                while (true) {
                    if (selector.select() > 0) {
                        for (SelectionKey key : selector.selectedKeys()) {
                            selector.selectedKeys().remove(key);
                            if (key.isReadable()) {
                                readMessage();
                            }
                        }
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start();

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in
        ))) {
            String input;
            while ((input = reader.readLine()) != null) {
                sendMessage(input);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void sendMessage(String message) throws IOException {
        if (message != null && !message.trim().isEmpty()) {
            ByteBuffer buffer = ByteBuffer.wrap(message.getBytes());
            socketChannel.write(buffer);
        }
    }

    private void readMessage() throws IOException {
        // 设置控制台的字符编码为UTF-8
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        int read = socketChannel.read(buffer);
        if (read > 0) {
            buffer.flip();
            String msg = new String(buffer.array(), 0, read);
            System.out.println(msg);
        }
    }

    public static void main(String[] args) throws UnsupportedEncodingException {
        // 设置控制台的字符编码为UTF-8
        System.setOut(new PrintStream(System.out, true, StandardCharsets.UTF_8.toString()));
        new ChatClient().start();
    }
}

