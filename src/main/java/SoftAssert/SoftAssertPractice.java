package SoftAssert;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SoftAssertPractice {

    public int sum(int num1,int num2){
        return num1+num2;
    }
    @Test
    public void test1(){
        Assert.assertEquals(sum(2,6),8);
        System.out.println("Ahmet");
        Assert.assertEquals(sum(3,8),12);//fail
        System.out.println("Mehmet");
        Assert.assertEquals(sum(0,0),0);
        System.out.println("Leyla");
    }

    @Test
    public void test2(){
        SoftAssert softAssert=new SoftAssert();
        softAssert.assertEquals(sum(1,3),4);
        System.out.println("Leyla");
        softAssert.assertEquals(sum(5,4),8);
        System.out.println("Ahmet");
        softAssert.assertEquals(sum(8,6),15);
        System.out.println("Mehmet");
        softAssert.assertAll();

    }
}
