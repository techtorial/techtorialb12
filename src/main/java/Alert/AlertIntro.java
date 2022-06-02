package Alert;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BrowserUtils;

import javax.sql.rowset.BaseRowSet;

public class AlertIntro {

    @Test
    public void alertAcceptAndGetText(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        WebElement jsAlert=driver.findElement(By.xpath("//button[contains(@onclick,'jsAlert()')]"));
        jsAlert.click();
        Alert alert=driver.switchTo().alert();
        String actualMessage=alert.getText();
        String expectedMessage="I am a JS Alert";
        Assert.assertEquals(actualMessage,expectedMessage);
        alert.accept();
        WebElement result=driver.findElement(By.id("result"));
        Assert.assertTrue(BrowserUtils.getText(result).equals("You successfully clicked an alert"));
    }

    @Test
    public void alertDismiss(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        WebElement jsConfirm=driver.findElement(By.xpath("//button[contains(@onclick,'jsConfirm()')]"));
        jsConfirm.click();
        Alert alert=driver.switchTo().alert();
        alert.dismiss();
        WebElement result=driver.findElement(By.id("result"));
        Assert.assertTrue(BrowserUtils.getText(result).equals("You clicked: Cancel"));
    }

    @Test
    public void alertSendKeys(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        WebElement jsConfirm=driver.findElement(By.xpath("//button[contains(@onclick,'jsP')]"));
        jsConfirm.click();
        Alert alert=driver.switchTo().alert();
        alert.sendKeys("Techtorial");
        alert.accept();
        WebElement result=driver.findElement(By.id("result"));
        Assert.assertTrue(BrowserUtils.getText(result).equals("You entered: Techtorial"));

    }
}
