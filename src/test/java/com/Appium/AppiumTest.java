package com.Appium;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * @author jiejie
 * @date 2020/5/2 16:28
 *  {
 *      "deviceName": "127.0.0.1:62001",
 *      "platformName": "Android",
 *      "appPackage": "com.tencent.mm",
 *      "appActivity": "com.tencent.mm.ui.LauncherUI"
 *  }
 */
public class AppiumTest {
    public static AndroidDriver<WebElement> androidDriver;
    @Test
    public void AppiumTest_1() throws MalformedURLException, InterruptedException {
        //创建配置对象
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        //添加配置
        //devicesName 可以找到测试设备
        desiredCapabilities.setCapability("deviceName","127.0.0.1:62001");
        //platformName:测试平台Android OR IOS
        desiredCapabilities.setCapability("platformName","Android");
        //appPackage找到测试的APP
        desiredCapabilities.setCapability("appPackage","com.handsgo.jiakao.android");
        Thread.sleep(2000);
        //appActivity:测试APP启动入口
        desiredCapabilities.setCapability("appActivity","com.handsgo.jiakao.android.splash.Login");
        //创建驱动
        //传入两个参数
        //第一个参数Appium通讯地址
        //第二个参数配置对象
        //AndroidDriver<WebElement> androidDriver = new AndroidDriver<WebElement>(desiredCapabilities)
        //不要用127.0.0.1报错呀!!!!!!!!!!!
        androidDriver = new AndroidDriver<WebElement>(new URL("http://127.0.0.1:4723/wd/hub"),desiredCapabilities);
        androidDriver.currentActivity();
    }
}
