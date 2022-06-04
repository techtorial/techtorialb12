package com.test.orangehrm.tests;

import com.test.orangehrm.TestBase;
import com.test.orangehrm.pages.LoginPage;
import com.test.orangehrm.pages.MainPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MainTest extends TestBase {
//    WebDriver driver;
//    @BeforeMethod//it will run before every test annotations
//    public void setUp(){
//        WebDriverManager.chromedriver().setup();
//        driver=new ChromeDriver();
//        driver.manage().window().maximize();
//        driver.get("https://opensource-demo.orangehrmlive.com/index.php/auth/login/");
//    }
    @Test
    public void validatingAdminButton() throws InterruptedException {
        LoginPage loginPage=new LoginPage(driver);
        loginPage.sendInformation("Admin","admin123");
        MainPage mainPage=new MainPage(driver);
        mainPage.clickAdmin();
    }
}
