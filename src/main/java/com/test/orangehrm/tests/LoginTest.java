package com.test.orangehrm.tests;

import com.test.orangehrm.pages.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest {
    WebDriver driver;
    @BeforeMethod//it will run before every test annotations
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://opensource-demo.orangehrmlive.com/index.php/auth/login/");
        System.out.println("I am running for BeforeMethod Annotation");
    }
    @Test
    public void validatePositiveLoginTest() throws InterruptedException {
        LoginPage loginPage=new LoginPage(driver);
        loginPage.sendInformation("Admin","admin123");
        Assert.assertEquals(driver.getCurrentUrl(),"https://opensource-demo.orangehrmlive.com/index.php/dashboard");
    }

    @Test
    public void validateNegativeLoginTest1() throws InterruptedException {
//        WebDriverManager.chromedriver().setup();
//        WebDriver driver=new ChromeDriver();
//        driver.manage().window().maximize();
//        driver.get("https://opensource-demo.orangehrmlive.com/index.php/auth/login/");
        LoginPage loginPage=new LoginPage(driver);
        loginPage.sendInformation("Admin","admfdfd");//correct username wrong password
        String actualMessage=loginPage.errorMessage();
        String expectedMessage="Invalid credentials";
        Assert.assertEquals(actualMessage,expectedMessage);
    }

    @Test//this test is specifically for negative test(this blank username and password)
    public void validateNegativeLoginTest2() throws InterruptedException {
//        WebDriverManager.chromedriver().setup();
//        WebDriver driver=new ChromeDriver();
//        driver.manage().window().maximize();
//        driver.get("https://opensource-demo.orangehrmlive.com/index.php/auth/login/");
        LoginPage loginPage=new LoginPage(driver);
        loginPage.sendInformation("","");
        String actualMessage=loginPage.errorMessage();
        String expectedMessage="Username cannot be empty";
        Assert.assertEquals(actualMessage,expectedMessage);
        String actualColor=loginPage.getColorOfMessage();
        String expectedColor="rgba(221, 119, 0, 1)";
        Assert.assertEquals(actualColor,expectedColor);
    }

    @AfterMethod
    public void tearDown(){
        driver.close();
        //System.out.println("this is running for after method annotation");
    }



}
