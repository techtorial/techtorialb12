package MentoringWithAhmet.com.test.sentrifugo.tests;

import MentoringWithAhmet.com.test.sentrifugo.pages.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest {
    WebDriver driver;
    @BeforeMethod
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://demo.sentrifugo.com/index.php/");
    }

    @Test
    public void validateHappyPath(){
        LoginPage loginPage=new LoginPage(driver);
        loginPage.login("EM01","sentrifugo");//dynamic method
        Assert.assertTrue(driver.getTitle().equals("Sentrifugo - Open Source HRMS"));
    }
    @Test
    public void validateNegativePath(){//i will pass two empty for username and password
        LoginPage loginPage=new LoginPage(driver);
        loginPage.login("","");
        Assert.assertTrue(loginPage.userNameError().equals("Please enter username or email."));
        Assert.assertEquals(loginPage.passwordError(),"Please enter password.");
        Assert.assertEquals(loginPage.getColorOfMessage(),"rgba(255, 0, 0, 1)");
    }
    @AfterMethod
    public void tearDown(){
        driver.close();
    }
}
