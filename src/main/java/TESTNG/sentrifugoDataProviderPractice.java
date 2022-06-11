package TESTNG;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class sentrifugoDataProviderPractice {

    /*
    1-Navigate to the website
    2-Make sure all of the username and password are logging in correctly
    3-Validate the title or url

    NOTE:Store your data provider under DATAPROVIDERCLASS
         Use data provider to do this task
           -->you should have only 1 Test
     */

    @Test(dataProvider = "SentrifugoLogin",dataProviderClass = DataProviderClass.class)
    public void validateSentrifugoTestLogin(String user,String pass){
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.navigate().to("http://demo.sentrifugo.com/index.php/");
        driver.manage().window().maximize();
        WebElement userName=driver.findElement(By.xpath("//input[@id='username']"));
        WebElement password=driver.findElement(By.xpath("//input[@id='password']"));
        WebElement loginButton=driver.findElement(By.id("loginsubmit"));
        userName.sendKeys(user);
        password.sendKeys(pass);
        loginButton.click();
        Assert.assertEquals(driver.getCurrentUrl(),"http://demo.sentrifugo.com/index.php/index/welcome");

    }

}
