package com.qiang.day1;

import org.testng.annotations.*;

public class TestNGDemo1 {
    @BeforeTest
    public void beforetest(){
        System.out.println("这是第一个beforetest");
    }
    @BeforeMethod
    public void beforeMethod(){
        System.out.println("这是第一个BeforeMethod");
    }
    @Test
    //void定义没有返回值的方法
    public void testcase1(){
        System.out.println("这是第一个test");

    }
    @Test
    public void testcase2(){
        System.out.println("这是第er个test");
    }
    @AfterTest
    public void AfterTest1(){
        System.out.println("这是第er个test");

    }

}
