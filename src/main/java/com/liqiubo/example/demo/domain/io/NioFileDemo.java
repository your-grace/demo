package com.liqiubo.example.demo.domain.io;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.EnumSet;

public class NioFileDemo {
    public static void main(String[] args) {
        NioFileDemo demo = new NioFileDemo();
        demo.writeFile();
        demo.readFile();
    }

    // 使用 NIO 写入文件
    public void writeFile() {
        Path path = Paths.get("logs/itwanger/paicoding.txt");
        try {
            FileChannel fileChannel = FileChannel.open(path, EnumSet.of(StandardOpenOption.CREATE, StandardOpenOption.WRITE));

            ByteBuffer buffer = StandardCharsets.UTF_8.encode("学编程就上技术派");
            fileChannel.write(buffer);

            System.out.println("写入完成");
            fileChannel.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // 使用 NIO 读取文件
    public void readFile() {
        Path path = Paths.get("logs/itwanger/paicoding.txt");
        try {
            FileChannel fileChannel = FileChannel.open(path, StandardOpenOption.READ);
            ByteBuffer buffer = ByteBuffer.allocate(1024);

            int bytesRead = fileChannel.read(buffer);
            while (bytesRead != -1) {
                buffer.flip();
                System.out.println("读取的内容: " + StandardCharsets.UTF_8.decode(buffer));
                buffer.clear();
                bytesRead = fileChannel.read(buffer);
            }

            fileChannel.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
