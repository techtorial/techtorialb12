package com.test.orangehrm.tests;

import com.test.orangehrm.TestBase;
import com.test.orangehrm.pages.LoginPage;
import com.test.orangehrm.pages.MainPage;
import com.test.orangehrm.pages.PimPage;
import org.testng.annotations.Test;

public class PimTest extends TestBase {

    @Test
    public void validateThePI() throws InterruptedException {
        LoginPage loginPage=new LoginPage(driver);
        loginPage.sendInformation("Admin","admin123");
        MainPage mainPage=new MainPage(driver);
        mainPage.clickPim();
        PimPage pimPage=new PimPage(driver);
        pimPage.sendPi("Ahmet","Baldir","1991",
                "/Users/techtorial/Desktop/usa.png","AhmetIT3",
                "12345678","12345678","Disabled");
        pimPage.validationInformation("Ahmet","Baldir","1991");
    }
    @Test
    public void validateEmployeeList() throws InterruptedException {
        LoginPage loginPage=new LoginPage(driver);
        loginPage.sendInformation("Admin","admin123");
        MainPage mainPage=new MainPage(driver);
        mainPage.clickPim();
        PimPage pimPage=new PimPage(driver);
        pimPage.sendPi("Ahmet","Baldir","1991",
                "/Users/techtorial/Desktop/usa.png","AhmetIT15",
                "12345678","12345678","Disabled");
        pimPage.sendPersonalDetails("Single","Turkish","2022-06-11");
        pimPage.validateAfterEdit("Single","Turkish","2022-06-11");
    }
}
