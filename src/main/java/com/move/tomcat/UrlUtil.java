package com.move.tomcat;

import com.move.tomcat.model.UrlBean;
import org.springframework.util.StringUtils;

/**
 * @description: TODO
 * @author: wu yang
 * @create: 2020-06-17 16:56
 */
public class UrlUtil {

    //http://127.0.0.1:8080/JayKing.Tomcat.Study/index.java?show
    public static UrlBean parseUrl(String url){
        UrlBean urlBean = null;
        int protocolIndex = url.indexOf(":");
        int hostIndex = url.lastIndexOf(":");
        int portIndex = url.indexOf("/",hostIndex);
        int pathIndex = url.lastIndexOf("/");
        int paramIndex = url.indexOf("?");
        int fileNameIndex = url.lastIndexOf(".");
        String protocol = url.substring(0,protocolIndex);
        String host = url.substring(protocolIndex+3,hostIndex);
        String port = url.substring(hostIndex+1,portIndex);
        String path = url.substring(portIndex+1,pathIndex);
        String fileName = url.substring(pathIndex+1,fileNameIndex);
        String paramter = url.substring(paramIndex+1,url.trim().length());
        if (StringUtils.isEmpty(host)){
            protocol="http";
        }
        urlBean = new UrlBean(protocol,host,port,path,fileName,paramter);
        return urlBean;
    }

    public static void main(String[] args) {
        String url = "https://127.0.0.1:8080/tomcat";
        String url2 = "http://127.0.0.1:8080/com.move.tomcat/index.java?show";
        UrlBean urlBean = UrlUtil.parseUrl(url2);
        System.out.println(urlBean.toString());
    }
}
