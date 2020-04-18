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

public class RegisterTest {
    WebDriver driver;
    @BeforeMethod
    public void openChrome()throws InterruptedException{
        System.setProperty("webdriver.chrome.driver","C:\\Users\\asus\\Desktop\\workplace\\selenium\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        //全局等待
//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://mail.163.com/");
        driver.manage().window().maximize();
        Thread.sleep(2000);
    }
    @Test
    public void registerTest() throws InterruptedException {
        //点击密码登录
        driver.findElement(By.xpath("//*[@id=\"commonOperation\"]/a[2]")).click();
        Thread.sleep(3000);
/**        driver.findElement(By.id("lbNormal")).click();
        Thread.sleep(3000);
        //控制权转交到iframe里面
        driver.switchTo().frame("x-URS-iframe1586669553424.715");

        //点击注册按钮
        driver.findElement(By.id("changepage")).click();*/
        //获取当年页面的handle值
        String handle1 = driver.getWindowHandle();
        //driver切换到window
        for (String handles : driver.getWindowHandles()){
            if (handles.equals(handle1) ){
                continue;
            }
            driver.switchTo().window(handles);
        }
        //增加时间戳来完成参数化
        String time = String.valueOf(System.currentTimeMillis()/100);
        driver.findElement(By.id("username")).sendKeys("gmail"+time);
        driver.findElement(By.id("password")).sendKeys(time);
        driver.findElement(By.id("phone")).sendKeys(time);
        //显示等待
        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[2]/div/div/div[2]/div[2]/div")) );
        //校验提示信息准确性
        String error = driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[2]/div")).getText();
        System.out.println(error);
        Assert.assertEquals(error,"密码过于简单，请尝试“字母+数字”的组合");

        Thread.sleep(8000);

    }

    @AfterMethod
    public void close(){
        driver.quit();
    }

}
