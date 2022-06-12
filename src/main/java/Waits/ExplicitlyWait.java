package Waits;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BrowserUtils;

import java.time.Duration;

public class ExplicitlyWait {

    @Test
    public void practice(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver =new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://the-internet.herokuapp.com/dynamic_loading/1");
        WebElement startButton=driver.findElement(By.xpath("//button"));
        startButton.click();
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement text=driver.findElement(By.xpath("//div[@id='finish']//h4"));
        WebElement mytext=wait.until(ExpectedConditions.visibilityOf(text));
        //WebElement mytext=wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[@id='finish']//h4")));
        System.out.println(mytext.getText().trim());
        Assert.assertTrue(BrowserUtils.getText(mytext).equals("Hello World!"));
    }
}
