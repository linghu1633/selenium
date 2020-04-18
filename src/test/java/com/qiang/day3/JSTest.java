package com.qiang.day3;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import sun.plugin2.message.JavaScriptBaseMessage;

import java.util.concurrent.TimeUnit;

public class JSTest {
    WebDriver driver;
    @BeforeMethod
    public void openChrome(){
        System.setProperty("webdriver.chrome.driver","C:\\Users\\asus\\Desktop\\workplace\\selenium\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        //全局等待
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    @Test
    public void JSTest() throws InterruptedException {
        driver.get("https://www.baidu.com/");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("document.getElementById(\"kw\").setAttribute(\"value\",\"webdriver\")");
        Thread.sleep(5000);
    }
    @AfterMethod
    public void close(){
        driver.quit();
    }
}
