package com.test.orangehrm;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class TestBase {

    public WebDriver driver;
    @BeforeMethod//it will run before every test annotations
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://opensource-demo.orangehrmlive.com/index.php/auth/login/");
    }

    @AfterMethod
    public void tearDown(){
       // driver.close();
    }

    /*
    TASK:
      1-Click the PIM button
      2-Click add button
      3-Fill the all necessary fields and click Login details and fill all the boxes
      4-status should be disabled
      5-Click save button
      6- Validate first name and last name from table

          HOMEWORK: THIS IS OPTIONAL


     */
}
