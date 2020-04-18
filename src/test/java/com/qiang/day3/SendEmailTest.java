package com.qiang.day3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

/**
 * @author jiejie
 * @date 2020/4/13 10:20
 */

public class SendEmailTest {
    WebDriver driver;
    @BeforeMethod
    public void openChrome() throws InterruptedException{
        System.setProperty("webdriver.chrome.driver","C:\\Users\\asus\\Desktop\\workplace\\selenium\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        //全局等待
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://mail.163.com/");
        driver.manage().window().maximize();
        Thread.sleep(1000);
    }
    @Test
    public void sendEmail() throws InterruptedException {
        //点击密码登录
        driver.findElement(By.xpath("//*[@id=\"lbNormal\"]")).click();
        Thread.sleep(2000);
        LoginTest.login(driver,"linghu_1633","menghuan_1633");
        Thread.sleep(3000);
        //点击写信  //*[@id="_mail_component_19_19"]/span[2]  //*[@id="dvNavTop"]/ul/li[2]/span[2]
//        driver.findElement(By.xpath(".//*[text()='写 信']")).click();
        driver.findElement(By.id("_mail_component_19_19")).click();
        Thread.sleep(3000);
        //写入收件人
        driver.findElement(By.className("nui-editableAddr-ipt")).sendKeys("linghu_1631@163.com");
        Thread.sleep(3000);
        //定位主题
        driver.findElement(By.xpath(".//*[@aria-label=\"邮件主题输入框，请输入邮件主题\"]/input")).sendKeys("lianxi");
        Thread.sleep(3000);
        //上传文件
        driver.findElement(By.xpath(".//*[@title=\"一次可发送2000张照片，600首MP3，一部高清电影\"]/input")).sendKeys("C:\\Users\\asus\\Desktop\\workplace\\selenium\\src\\test\\java\\com\\qiang\\day3\\OIP.jpg");
        Thread.sleep(3000);
        //定位iframe
        WebElement iframe = driver.findElement(By.className("pass-form pass-form-normal"));
        //将控制权转交到frame
        driver.switchTo().frame(iframe);
        //写邮件内容
        driver.findElement(By.xpath("/html/body")).sendKeys("这是内容______________++++++++");
        Thread.sleep(3000);
        //将driver的控制权转交回来
        driver.switchTo().defaultContent();
        //点击发送
        driver.findElement(By.xpath(".//*[text()='发送']")).click();
        Thread.sleep(3000);
        //校验发送成功
        String success = driver.findElement(By.xpath(".//*[text()='发送成功']")).getText();
        System.out.println(success);
        Assert.assertEquals(success,"发送成功手机收发邮件更方便");
        Thread.sleep(3000);
    }
    @AfterMethod
    public void close(){
        driver.quit();
    }
}
