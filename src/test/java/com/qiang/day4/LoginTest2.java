package com.qiang.day4;

import com.zhao.page.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class LoginTest2 {
    private WebDriver driver;
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
    public void loginSuccessPO() throws InterruptedException {
        //点击密码登录
        driver.findElement(By.xpath("//*[@id=\"lbNormal\"]")).click();
        Thread.sleep(2000);

        driver.switchTo().frame(driver.findElement(By.tagName("iframe")));
        //现将By.name("email")替换,运用到PO思想
        //调用LoginPage.emailinput  这个PO思想的类中的方法
        driver.findElement(LoginPage.emailinput).sendKeys("linghu_1635");
        //调用LoginPage.emailinput  这个PO思想的类中的方法
        driver.findElement(LoginPage.passwordinput).sendKeys("linghuchong");
        //调用LoginPage.emailinput  这个PO思想的类中的方法
        driver.findElement(LoginPage.dologinBotton).click();
        Thread.sleep(4000);

        //显示等待
        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText("退出")) );
        //校验提示信息准确性
//        String loginout = driver.findElement(By.className("sh0 nui-txt-link")).getText();
        String loginout = driver.findElement(By.linkText("退出")).getText();
        System.out.println(loginout);
        Assert.assertEquals(loginout,"退出");
        driver.findElement(By.linkText("退出")).click();
        Thread.sleep(4000);

    }
    @Test
    public void loginError() throws InterruptedException {
        //点击密码登录
/**        driver.findElement(By.xpath("//*[@id=\"lbNormal\"]")).click();
        Thread.sleep(2000);
        driver.switchTo().frame(driver.findElement(By.tagName("iframe")));
        driver.findElement(By.name("email")).sendKeys("linghu_1635");
        driver.findElement(By.name("password")).sendKeys("linghuchong111");
        driver.findElement(By.id("dologin")).click();*/
        //调用封装方法
        LoginTest2.login(driver,"linghu_1635","linghuchong");
        //显示等待
        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"nerror\"]/div[2]")));
        //校验提示信息准确性
        String error = driver.findElement(By.xpath("//*[@id=\"nerror\"]/div[2]")).getText();
        System.out.println(error);
        Assert.assertEquals(error,"请先进行验证");
    }
    //代码的封装 将点击密码登录输入值的栏位 封装成方法
    public static void login (WebDriver driver,String email,String pwd){
        driver.switchTo().frame(driver.findElement(By.tagName("iframe")));
        driver.findElement(By.name("email")).sendKeys(email);
        driver.findElement(By.name("password")).sendKeys(pwd);
        driver.findElement(By.id("dologin")).click();
    }
    @AfterMethod
    public void close(){
        driver.quit();
    }
}
