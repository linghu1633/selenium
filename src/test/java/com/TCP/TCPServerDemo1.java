package com.TCP;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author jiejie
 * @date 2020/5/28 0:00
 */
public class TCPServerDemo1 {
    public static void main(String[] args) {
        //提升作用域
        ServerSocket serverSocket = null;
        Socket socket = null;
        InputStream is = null;
        ByteArrayOutputStream baos = null;
        try {
            //我de有一个地址
            serverSocket = new ServerSocket(9999);
            while (true) {
                //等待客户端链接过来
                socket = serverSocket.accept();
                //读取客户端的信息
                is = socket.getInputStream();
                //管道流
                baos = new ByteArrayOutputStream();
                byte[] buffer = new byte[1024];
                int len;
                while ((len = is.read(buffer)) != -1) {
                    baos.write(buffer, 0, len);
                }
                System.out.println(baos.toString());
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //关闭资源
            if (baos != null) {
                try {
                    baos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (is != null) {
                try {
                    is.close();
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
            if (serverSocket != null) {
                try {
                    serverSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }


        }
    }
}
