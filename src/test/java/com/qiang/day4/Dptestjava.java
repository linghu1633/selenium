package com.script;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class Dptestjava {
    WebDriver driver;
    @Test(dataProvider = "fff")
    public void DTTTest(String user,String pwd,String expectedRes){
        System.setProperty("webdriver.chrome.driver","C:\\Users\\asus\\Desktop\\workplace\\TestTmfJava\\chromedriver.exe");
        driver =new ChromeDriver();
        driver.get("https://www.baidu.com/");
        //点击登录

        driver.findElement(By.name("tj_login")).click();
        //输入用户名
        driver.findElement(By.name("userName")).sendKeys(user);
        //输入密码
        driver.findElement(By.name("password")).sendKeys(pwd);
        //点击密码页登录
        driver.findElement(By.className("pass-button pass-button-submit")).click();

        driver.findElement(By.className("tang-pass-footerBarULogin pass-link")).click();
        String result = driver.findElement(By.xpath("//*[@id=\"TANGRAM__PSP_10__error\"]")).getText();
        System.out.println(result);
//        判断获取的结果是否与预期的一致   断言
        assertEquals(result,expectedRes);
//        之后的操作就是上述方法的封装,如何在Excel中编写测试用例,之后就是读取数据测试
    }
    @DataProvider
    public Object[][] fff(){
        return new Object[][]{
                new Object[]{"Will","123456","帐号或密码错误，请重新输入或者"},
                new Object[]{"","123456","帐号或密码错误，请重新输入或者"},
                new Object[]{"Will","234","帐号或密码错误，请重新输入或者"}
        };
    }
    @AfterMethod
    public void close(){
        driver.quit();
    }
}
