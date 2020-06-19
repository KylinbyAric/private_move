package com.move.tomcat;

import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.Socket;

/**
 * @description: TODO
 * @author: wu yang
 * @create: 2020-06-18 09:59
 */
public class Client {
    static String host = "127.0.0.1";
    static int port = 8080;

    public static void main(String[] args) {
        try {
            for (int i = 0; i < 10000; i++) {
                //获取socket实例
                Socket socket = new Socket(host,port);
                //获取输出流
                System.out.println("客户端启用");
                Writer writer = new OutputStreamWriter(socket.getOutputStream());
                writer.write("http://127.0.0.1:8080/com.move.tomcat/index.java?show");
                //冲刷输出流
                writer.flush();
                writer.close();
            }
        }catch (Exception exception){
            exception.printStackTrace();
        }

    }
}
