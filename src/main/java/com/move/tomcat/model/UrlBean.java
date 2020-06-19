package com.move.tomcat.model;

import lombok.Data;

/**
 * @description: TODO
 * @author: wu yang
 * @create: 2020-06-17 16:57
 */
public class UrlBean {
    private String Protocal;
    private String Host;

    public String getProtocal() {
        return Protocal;
    }

    public void setProtocal(String protocal) {
        Protocal = protocal;
    }

    public String getHost() {
        return Host;
    }

    public void setHost(String host) {
        Host = host;
    }

    public String getPort() {
        return Port;
    }

    public void setPort(String port) {
        Port = port;
    }

    public String getPath() {
        return Path;
    }

    public void setPath(String path) {
        Path = path;
    }

    public String getFileName() {
        return FileName;
    }

    public void setFileName(String fileName) {
        FileName = fileName;
    }

    public String getParamter() {
        return Paramter;
    }

    public void setParamter(String paramter) {
        Paramter = paramter;
    }

    private String Port;
    private String Path;
    private String FileName;
    private String Paramter;

    public UrlBean(String protocal, String host, String port, String path,
                   String fileName, String paramter) {
        Paramter = paramter;
        Path = path;
        Host = host;
        FileName = fileName;
        Protocal = protocal;
        Port = port;
    }

    @Override
    public String toString() {
        return "UrlBean{" +
                "Protocal='" + Protocal + '\'' +
                ", Host='" + Host + '\'' +
                ", Port='" + Port + '\'' +
                ", Path='" + Path + '\'' +
                ", FileName='" + FileName + '\'' +
                ", Paramter='" + Paramter + '\'' +
                '}';
    }
}
