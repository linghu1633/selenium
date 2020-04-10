package com.qiang.day1;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestNGDemo2 {
    //校验A=A
    String A;
    @Test
    public void assertEqualTest(){
        String a = "asdf";
        String b = "asdf111";
/*        if (a.equals(b) ){
            System.out.println("正确");
        }else{
            System.out.println("错误");
        }*/
        Assert.assertEquals(a,b,"a等于b");//第一个Assert如果错误不执行下面的代码
        System.out.println("+++++++++++++++++");
        Assert.assertEquals(a,b);
    }
    @Test
    public void a(){
        Boolean a = true;
        Assert.assertTrue(a);
    }
}
