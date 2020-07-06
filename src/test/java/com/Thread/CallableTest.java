package com.Thread;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @author jiejie
 * @date 2020/6/15 22:03
 */
public class CallableTest implements Callable<Boolean> {
    private String url;
    private String name;

    public CallableTest(String url, String name) {
        this.url = url;
        this.name = name;
    }

    @Override
    public Boolean call() throws Exception {
        WebDownloader webDownloader = new WebDownloader();
        webDownloader.downloader(url, name);
        System.out.println("下载了文件名为:" + name);
        return true;
    }

    public static void main(String[] args) {
        CallableTest t1 = new CallableTest("", "");
        CallableTest t2 = new CallableTest("", "");
        CallableTest t3 = new CallableTest("", "");

        //创建执行服务
        ExecutorService ser = Executors.newFixedThreadPool(3);
        //提交执行
        Future<Boolean> r1 = ser.submit(t1);
        Future<Boolean> r2 = ser.submit(t2);
        Future<Boolean> r3 = ser.submit(t3);

        System.out.println(t1);
        //关闭服务
        ser.shutdownNow();
    }


    class WebDownloader {
        public void downloader(String url, String name) {
            try {
                FileUtils.copyURLToFile(new URL(url), new File(name));
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("IO异常,下载出现问题");
            }
        }
    }
}
