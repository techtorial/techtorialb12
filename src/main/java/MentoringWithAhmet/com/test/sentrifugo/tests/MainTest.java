package MentoringWithAhmet.com.test.sentrifugo.tests;

import MentoringWithAhmet.com.test.sentrifugo.pages.LoginPage;
import MentoringWithAhmet.com.test.sentrifugo.pages.MainPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MainTest {
    WebDriver driver;
    @BeforeMethod
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://demo.sentrifugo.com/index.php/");
    }

    @Test
    public void validationOnMainPage(){
        LoginPage loginPage=new LoginPage(driver);
        loginPage.login("EM01","sentrifugo");//successfully login
        MainPage mainPage=new MainPage(driver);
        Assert.assertTrue(mainPage.getRoleName().equals("Super Admin")); //validate the role name
        Assert.assertTrue(mainPage.getInterviewMessage().equals("No interviews scheduled for today."));
        mainPage.clickDepartment();
    }
    @AfterMethod
    public void tearDown(){
       // driver.close();
    }
}
