package com.TCP;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * @author jiejie
 * @date 2020/5/27 23:59
 */
public class TCPClientDemo1 {
    public static void main(String[] args) {

        Socket socket = null;
        OutputStream os = null;
        try {
            //1.要知道服务的地址与端口号
            InetAddress serverIp = InetAddress.getByName("127.0.0.1");
            int port = 9999;
            //2.创建一个socket链接
            socket = new Socket(serverIp, port);
            //3.发送消息IO流
            os = socket.getOutputStream();
            os.write("佩佩你好可爱".getBytes());

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (os != null) {
                try {
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (socket != null) {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
