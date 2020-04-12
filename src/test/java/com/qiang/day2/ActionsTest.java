package com.qiang.day2;


import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import javax.xml.transform.OutputKeys;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class ActionsTest {
    WebDriver driver;
    @BeforeMethod
    public void openChrome(){
        System.setProperty("webdriver.chrome.driver","C:\\Users\\asus\\Desktop\\workplace\\selenium\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        //全局等待
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    /**
    * 点击跳转并且校验链接的正确性
    */
    @Test
    public void clickTest() throws InterruptedException {
        driver.get("https://cn.bing.com/");
        driver.manage().window().maximize();
        Thread.sleep(1000);
//        driver.findElement(By.xpath("//*[@id=\"u_sp\"]/a[2]"));
        WebElement newslink = driver.findElement(By.id("scpl0"));
        System.out.println(newslink);
        //点击新闻
        newslink.click();
        Thread.sleep(3000);
        //校验跳转页面的正确性
//        driver.getCurrentUrl();
        String url = driver.getCurrentUrl();
        System.out.println(url);
        Assert.assertEquals(url,"https://cn.bing.com/images/trending?form=Z9LH");
        Thread.sleep(3000);
    }

    @Test
    public void sendkeysTest() throws InterruptedException{
        driver.get("https://www.baidu.com/");
        //定位百度搜索框
        WebElement keys = driver.findElement(By.id("kw"));
        //搜索框输入selenium
        keys.sendKeys("selenium");
        //定位百度按钮
        WebElement baiduButton = driver.findElement(By.id("su"));
        //点击
        baiduButton.click();
        Thread.sleep(5000);
        //获取页面title
        String title = driver.getTitle();
        System.out.println(title);
        //校验
        Assert.assertEquals(title,"selenium_百度搜索");
    }

    /**
     * 截图百度页面
     */
    @Test
    public void screenShotFile(){
        driver.get("https://www.baidu.com/");
        //((TakesScreenshot)driver)  这个得意思是  将driver转换成TakesScreenshot的类型
        File file= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        try{
            FileUtils.copyFile(file,new File("C:\\Users\\asus\\Desktop\\workplace\\test1.png"));

        }catch (IOException e){
            e.printStackTrace();
        }

    }

    @AfterMethod
    public void close(){
        driver.quit();
    }
}
