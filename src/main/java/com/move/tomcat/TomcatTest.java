package com.move.tomcat;

import com.move.tomcat.model.UrlBean;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Method;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @description: TODO
 * @author: wu yang
 * @create: 2020-06-18 09:32
 */
public class TomcatTest {
    static int port = 8080;
    static String host = "127.0.0.1";

    public static void main(String[] args) {
        System.out.println("my tomcat is running !");
        try {
            //获取ServerSocket实例
            ServerSocket serverSocket = new ServerSocket(port);
            while (true) {
                //持续获取socket链接
                Socket con = serverSocket.accept();
                //从socket中获取一个输入流，并解析出数据
                InputStream in = con.getInputStream();
                BufferedReader reader = new BufferedReader(new InputStreamReader(in));
                String url = "";
                String urlLine = reader.readLine();
                while (urlLine != null) {
                    url = url + urlLine;
                    urlLine = reader.readLine();
                }
                UrlBean urlBean = UrlUtil.parseUrl(url);
                if (urlBean != null) {
                    try {
                        //获得当前的类加载器
                        ClassLoader classLoader = ClassLoader.getSystemClassLoader();
                        //将目标装入类加载器
                        classLoader.loadClass(urlBean.getPath() + "." + urlBean.getFileName());
                        //获取目标的class
                        Class<?> target = Class.forName(urlBean.getPath() + "." + urlBean.getFileName());
                        //获取目标的方法
                        Method method = target.getMethod(urlBean.getParamter().trim());
                        //获取目标类的一个实例，并且激活方法
                        method.invoke(target.newInstance(), null);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }


        } catch (Exception e) {
            e.fillInStackTrace();
        }
    }
}
