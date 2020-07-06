package com.qiang.day3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.testng.annotations.Test;

public class PhantomJSTest {

    @Test
    public void pjsTEst() throws InterruptedException {
        System.setProperty("phantomjs.binary.path","C:\\Users\\asus\\Desktop\\workplace\\java\\selenium\\drivers\\phantomjs.exe");
        WebDriver driver =new PhantomJSDriver();

        driver.get("https://cn.bing.com/");
        driver.findElement(By.id("sb_form_q")).sendKeys("phantomjs");
        Thread.sleep(3000);

        String a = driver.getTitle();
        System.out.println(a);

        driver.quit();
    }
}
