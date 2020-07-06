package com.myhashmap;

import java.net.InetSocketAddress;
import java.util.HashMap;
import java.util.Map;

/**
 * @author jiejie
 * @date 2020/5/25 22:04
 */
public class MyHashMap<K,V> {
    public static void main(String[] args) {

        InetSocketAddress SocketAddress=new InetSocketAddress("127.0.0.1",8080);
        System.out.println(SocketAddress.getAddress());
    }

}
