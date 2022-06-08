package Mentoring.com.automation.test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

public class TestBase {
    public  WebDriver driver;
    @BeforeMethod//it will run before every test annotations
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://automationexercise.com/");
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
    }
}
