package com.qiang.day1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class FindElements {
    WebDriver driver;
    @BeforeMethod
    public void opencharme(){
        System.setProperty("webdriver.chrome.driver","C:\\Users\\asus\\Desktop\\workplace\\selenium\\drivers\\chromedriver.exe");
        //实例化一个driver  启动浏览器
        driver = new ChromeDriver();
    }
    //通过ID定位
    @Test
    public void byIdTest(){
        driver.get("https://www.baidu.com/");
        WebElement  key = driver.findElement(By.id("kw"));
    }
    //通过name定位
    @Test
    public void byNameTest(){
        driver.get("https://www.baidu.com/");
        WebElement  key = driver.findElement(By.name("kw"));
    }
    //通过class定位
    @Test
    public void byClassTest(){
        driver.get("https://www.baidu.com/");
        WebElement  key = driver.findElement(By.className("kw"));
    }
    //通过Xpath定位
    @Test
    public void byXPath() throws InterruptedException {
        driver.get("https://cn.bing.com/");
        List<WebElement> lists = driver.findElements(By.xpath("//*[@id=\"sc_hdu\"]/li"));
        driver.manage().window().maximize();
        Thread.sleep(5000);
        //获取sc_hdu  这个标签下的全部值
        for (int i = 0; i < lists.size(); i++) {
            String test = lists.get(i).getText();
            System.out.println(test);
        }

    }
    @AfterMethod
    public void closeBrowser(){
//        WebDriver driver = new ChromeDriver();
        driver.quit();
    }
}
