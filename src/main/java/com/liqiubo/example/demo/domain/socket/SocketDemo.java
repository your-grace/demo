package com.liqiubo.example.demo.domain.socket;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class SocketDemo {
    public static void main(String[] args) throws UnsupportedEncodingException {
        try (Socket socket = new Socket("bbs.newsmth.net", 23);) {
            InputStream is = socket.getInputStream();
            Scanner scanner = new Scanner(is, "gbk");
            System.setOut(new PrintStream(System.out, true, StandardCharsets.UTF_8.toString()));
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                System.out.println(line);
            }

        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
