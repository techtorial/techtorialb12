package TESTNG;

import org.testng.annotations.*;

public class TestNGAnnotations {

    @Test
    public void test1(){
        System.out.println("test annotation-1");
    }
    @BeforeMethod
    public void beforeMethod(){
        System.out.println("Before Method");
        //You can use it to login to the page
    }
    @Test
    public void test2(){
        System.out.println("test annotation-2");

    }
    @AfterMethod
    public void afterMethod(){
        System.out.println("After Method");
        //You can take a screenShot for failed test
        //driver.quit/close
    }
    @BeforeClass
    public void beforeClass(){
        System.out.println("Before Class");
        //you can navigate to the website
    }
    @AfterClass
    public void afterClass(){
        System.out.println("After Class");
    }
    @BeforeTest
    public void beforeTest(){
        System.out.println("Before Test");
        //You can use to launch your browser
    }
    @AfterTest
    public void afterTest(){
        System.out.println("After Test");
    }
    @BeforeSuite
    public void beforeSuite(){
        System.out.println("Before Suite");
        //You can use to setup your chrome Browser properties(driver=DriverHelper.getDriver)
        //deleteCookies
    }
    @AfterSuite
    public void afterSuite(){
        System.out.println("After Suite");
    }
}
