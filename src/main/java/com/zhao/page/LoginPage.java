package com.zhao.page;

import org.openqa.selenium.By;

/**
 * @author jiejie
 * @date 2020/4/18 16:35
 */
public class LoginPage {
    //定义email文本框的定位方式
    public static By emailinput = By.name("email");
    //定义密码文本框输入的定位方式
    public static By passwordinput = By.name("password");
    //定义登录按钮的定位方式
    public static By dologinBotton = By.id("dologin");
}
