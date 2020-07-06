package com.URL;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import static java.lang.System.currentTimeMillis;

/**
 * @author jiejie
 * @date 2020/6/10 23:19
 */
public class URLDown {
    public static void main(String[] args) throws Exception {
        //下载地址
//        URL url = new URL("https://vodkgeyttp8.vod.126.net/cloudmusic/adbc/core/54c7/8144cbc48be59a6520413689e7401605.mp4?wsSecret=7b85b49a076618dad8c919f8c9bac168&wsTime=1591803863");
        //色情网址
//        URL url = new URL("https://hls-hw.xvideos-cdn.com/videos/hls/63/ab/32/63ab322d02d77a1dc92ee9d8c755bc7a/hls-1080p-6215b40.ts?e=1592659641&l=0&h=0784bf85d7ad4ab649d6bb80a6c83810");
        URL url = new URL("");
        //连接到资源  http
        HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
        InputStream inputStream = urlConnection.getInputStream();
        FileOutputStream fileOutputStream = new FileOutputStream(currentTimeMillis() / 1000 + ".mp4");
        byte[] bytes = new byte[1024];
        int len;
        while ((len = inputStream.read(bytes)) != -1) {
            //写出这个数据
            fileOutputStream.write(bytes, 0, len);
        }

        inputStream.close();
        fileOutputStream.close();
        urlConnection.disconnect();//断开连接
    }

}
