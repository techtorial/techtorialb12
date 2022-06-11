package com.test.orangehrm.tests;

import com.test.orangehrm.OrangeHrmDataProviderClass;
import com.test.orangehrm.TestBase;
import com.test.orangehrm.pages.AdminPage;
import com.test.orangehrm.pages.LoginPage;
import com.test.orangehrm.pages.MainPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.ConfigReader;

public class AdminTest extends TestBase {
//    WebDriver driver;
//    @BeforeMethod//it will run before every test annotations
//    public void setUp(){
//        WebDriverManager.chromedriver().setup();
//        driver=new ChromeDriver();
//        driver.manage().window().maximize();
//        driver.get("https://opensource-demo.orangehrmlive.com/index.php/auth/login/");
//    }
    @Test
    public void validateUrlAndAddButton() throws InterruptedException {
         /*
        1-Choose the User Role "Admin"
        2-Employee Name "Alice Duval"
        3-Username can be anything but should be different for each run
        4-Status should be disabled
        5-put your password
        6-put your confirm password
        7-Click save button
         */
        LoginPage loginPage = new LoginPage(driver);
        loginPage.sendInformation("Admin", "admin123");
        MainPage mainPage = new MainPage(driver);
        mainPage.clickAdmin();
        AdminPage adminPage = new AdminPage(driver);
        adminPage.clickAddButton();
        adminPage.sendEmployeeInformation("Admin", "Alice Duval", "ahmet53",
                "Disabled", "12345678", "12345678"); //hard coding
        //Assert.assertTrue(adminPage.validationUserNameIsCreated("ahmet51"));


    }
    @Test(dataProvider ="EmployeeCreation",dataProviderClass = OrangeHrmDataProviderClass.class)
    public void creatingEmployeeAccount(String role,String name,String username,String statusName,
                                        String password,String confirmPassword) throws InterruptedException {
        /*
        1-Navigate to the website
        2-Click admin
        3-Click Add button
        4-Provide information and save it
        5-Validate the name is on the table(contains)
        5-Do it for 3 different users
        */
        LoginPage loginPage=new LoginPage(driver);
        loginPage.sendInformation(ConfigReader.readProperty("orangehrmusername"),ConfigReader.readProperty("orangehrmpassword"));
        MainPage mainPage=new MainPage(driver);
        mainPage.clickAdmin();
        AdminPage adminPage=new AdminPage(driver);
        adminPage.clickAddButton();
        adminPage.sendEmployeeInformation(role,name,username,statusName,password,confirmPassword);//dynamic
        Assert.assertTrue(adminPage.validationUserNameIsCreated(username));

    }
}
