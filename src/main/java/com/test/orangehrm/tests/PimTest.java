package com.test.orangehrm.tests;

import com.test.orangehrm.TestBase;
import com.test.orangehrm.pages.LoginPage;
import com.test.orangehrm.pages.MainPage;
import com.test.orangehrm.pages.PimPage;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import utils.ConfigReader;

public class PimTest extends TestBase {

//    @Test
//    public void validateThePI() throws InterruptedException {
//        LoginPage loginPage=new LoginPage(driver);
//        loginPage.sendInformation("Admin","admin123");
//        MainPage mainPage=new MainPage(driver);
//        mainPage.clickPim();
//        PimPage pimPage=new PimPage(driver);
//        pimPage.sendPi("Ahmet","Baldir","1991",
//                "/Users/techtorial/Desktop/usa.png","AhmetIT3",
//                "12345678","12345678","Disabled");
//        pimPage.validationInformation("Ahmet","Baldir","1991");
//    }
    @Parameters({"firstName","lastName","employeeId","locationFile","userName","password","confirmPassword","status",
            "statusMarriage","national","dateOfBirth","date"})
    @Test
    public void validateEmployeeList(String firstName,String lastName,String employeeId
    ,String locationFile,String userName,String password,String confirmPassword,String status, String statusMarriage,
                                     String national,String dateOfBirth,String date) throws InterruptedException {
        LoginPage loginPage=new LoginPage(driver);
        loginPage.sendInformation(ConfigReader.readProperty("orangehrmusername"),ConfigReader.readProperty("orangehrmpassword"));
        MainPage mainPage=new MainPage(driver);
        mainPage.clickPim();
        PimPage pimPage=new PimPage(driver);
        pimPage.sendPi(firstName,lastName,employeeId, locationFile,userName, password,confirmPassword,status);
        pimPage.sendPersonalDetails(statusMarriage,national,dateOfBirth);
        pimPage.validateAfterEdit(statusMarriage,national,date);
    }




    /*
    1-Navigate to the website https://www.etsy.com/
    2-take care of your testbase class
    3-search iphone 13 case on the website
    4-validate all of the headers from search includes either iphone, case, 13
    5-Parameterize these iphone,case,13 and THE SEARCH PARAMETER(iphone 13 case)
    Totally you should have 4 parameters which are coming from xml file.
    Runner class.xml
     */






}
