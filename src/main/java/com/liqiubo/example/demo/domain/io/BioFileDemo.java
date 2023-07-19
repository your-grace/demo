package com.liqiubo.example.demo.domain.io;

import java.io.*;

public class BioFileDemo {
    public static void main(String[] args) {
        BioFileDemo demo = new BioFileDemo();
        demo.writeFile();
        demo.readFile();
    }

    // 使用 BIO 写入文件
    public void writeFile() {
        String filename = "logs/itwanger/paicoding.txt";
        try {
            FileWriter fileWriter = new FileWriter(filename);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            bufferedWriter.write("学编程就上技术派");
            bufferedWriter.newLine();

            System.out.println("写入完成");
            bufferedWriter.close();
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // 使用 BIO 读取文件
    public void readFile() {
        String filename = "logs/itwanger/paicoding.txt";
        try {
            FileReader fileReader = new FileReader(filename);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println("读取的内容: " + line);
            }

            bufferedReader.close();
            fileReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
