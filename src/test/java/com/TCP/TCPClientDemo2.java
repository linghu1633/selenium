package com.TCP;

import java.io.InputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * @author jiejie
 * @date 2020/6/9 22:00
 */
public class TCPClientDemo2 {
    public static void main(String[] args) throws Exception {
        //创建socket连接
        Socket socket = new Socket(InetAddress.getByName("127.0.0.1"),9000);
        InputStream oos = socket.getInputStream();
    }
}
