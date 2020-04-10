package com.qiang.day1;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class OpenBrower {
    WebDriver driver;
    //每次执行test都会执行Method====BeforeTest是执行一次
    @BeforeMethod
    public void openChrom(){
        //设置chromedriver路径
        System.setProperty("webdriver.chrome.driver","C:\\Users\\asus\\Desktop\\workplace\\selenium\\drivers\\chromedriver.exe");
        //ChromeDriver 中可以传参数来满足全新浏览器的配置需求
        //实例化 chromedriver
//        WebDriver driver = new ChromeDriver();
        driver = new ChromeDriver();
    }

    @Test
    public void openChrome() throws InterruptedException {
        //设置chromedriver路径
        System.setProperty("webdriver.chrome.driver","C:\\Users\\asus\\Desktop\\workplace\\selenium\\drivers\\chromedriver.exe");
        //ChromeDriver 中可以传参数来满足全新浏览器的配置需求
        //实例化 chromedriver
        WebDriver driver = new ChromeDriver();
        Thread.sleep(5000);
        //关闭浏览器
        driver.close();
    }
    @Test
    public void openChrome1() throws InterruptedException {
        //设置chromedriver路径
        System.setProperty("webdriver.chrome.driver","C:\\Users\\asus\\Desktop\\workplace\\selenium\\drivers\\chromedriver.exe");
        //ChromeDriver 中可以传参数来满足全新浏览器的配置需求
        //实例化 chromedriver
        WebDriver driver = new ChromeDriver();
        //等待5s
        Thread.sleep(5000);
        //关闭浏览器
        driver.quit();
    }
    /**打开浏览器
     *打开百度首页
     * 获取当前页面的url
     * 等待3s
     * 家宴当前页面url是不是百度的王子
     * 关闭浏览器
     * */
    @Test
    public void getUrlTest() throws InterruptedException {
        driver.get("http://baidu.com");
        String url = driver.getCurrentUrl();
        System.out.println("获取到的url是:"+url);
        Assert.assertEquals(url,"https://www.baidu.com/");
        //浏览器后退
        driver.navigate().back();
        Thread.sleep(3000);
        //浏览器前进
        driver.navigate().forward();
        Thread.sleep(3000);
        //刷新
        driver.navigate().refresh();
        Thread.sleep(3000);
        //设置大小
        Dimension dimension = new Dimension(500,500);
        driver.manage().window().setSize(dimension);
        Thread.sleep(3000);
        //最大化
        driver.manage().window().maximize();
        Thread.sleep(3000);
    }
    @AfterMethod
    public void closeBrowser(){
//        WebDriver driver = new ChromeDriver();
        driver.quit();
    }
}
