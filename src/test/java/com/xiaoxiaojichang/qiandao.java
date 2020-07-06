package com.xiaoxiaojichang;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

/**
 * @author jiejie
 * @date 2020/7/2 22:52
 */
public class qiandao {
    ChromeDriver driver;
//    WebDriver driver;
    @BeforeMethod
    public void openChrome() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "F:\\workplace\\java\\selenium\\drivers\\chromedriver.exe");
//        System.setProperty("phantomjs.binary.path","C:\\Users\\asus\\Desktop\\workplace\\java\\selenium\\drivers\\phantomjs.exe");
//        driver =new PhantomJSDriver();
        driver = new ChromeDriver();

        //全局等待
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://xxjc.pro/auth/login");
        driver.manage().window().maximize();
        Thread.sleep(1000);
    }
    @Test
    public void qiandao() throws InterruptedException {
        driver.findElement(By.xpath("/html/body/div[1]/div/form/div/div[2]/div/input")).sendKeys("linghu_1633@163.com");
        driver.findElement(By.xpath("/html/body/div[1]/div/form/div/div[3]/div/input")).sendKeys("linghu_1633");
        driver.findElement(By.xpath("/html/body/div[1]/div/form/div/div[5]/button")).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        try{
            driver.findElement(By.xpath("/html/body/main/div[2]/section/div[1]/div[6]/div[1]/div/div/dl/div/div/div/button")).click();
        }catch (Exception e){
            System.out.println(e);
        }
        Thread.sleep(5000);
    }

    @AfterMethod
    public void close() {
        driver.quit();
    }
}
