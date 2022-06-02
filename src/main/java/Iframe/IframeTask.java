package Iframe;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utils.BrowserUtils;

public class IframeTask {

    @Test
    public void iframeTask(){
          /*TASK: NOTE: You might need Action class,GetWindowHandles, and Iframe knowledge for this task
         1-Navigate to the website"https://skpatro.github.io/demo/iframes/"
         2-Click Pavilion and click Selenium-java and validate the header "Selenium-Java Tutorial – Basic to Advance"
         3-Go back to mainPage and click category1 and validate the header "Category Archives: SeleniumTesting"
         4-Go back to mainPage and click Category3 and validate the header "Category Archives: SoftwareTesting"
         and url "https://qavalidation.com/category/softwaretesting/"
         5-Close All Tabs
         */

        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.get("https://skpatro.github.io/demo/iframes/");
        driver.manage().window().maximize();
        WebElement pavilion=driver.findElement(By.linkText("Pavilion"));
        pavilion.click();
        BrowserUtils.switchByTitle(driver,"Home - qavalidation");//my driver is pointing home-qavalidation page
        WebElement selenium=driver.findElement(By.xpath("//ul[@id='primary-menu']//span[.='Selenium']//span"));
        Actions actions=new Actions(driver);
        actions.moveToElement(selenium).perform();
        WebElement selenium_java=driver.findElement(By.xpath("//ul[@id='primary-menu']//span[.='Selenium-Java']//span"));
        actions.click(selenium_java).perform();
        WebElement header=driver.findElement(By.tagName("h1"));
        String actualHeader=BrowserUtils.getText(header);
        String expectedHeader="Selenium-Java Tutorial – Basic to Advance";
        Assert.assertEquals(actualHeader,expectedHeader);
        BrowserUtils.switchByTitle(driver,"iframes");//my driver is pointing iframe page
        driver.switchTo().frame("Frame1");
        WebElement category1=driver.findElement(By.linkText("Category1"));
        category1.click();
        BrowserUtils.switchByTitle(driver,"SeleniumTesting Archives");//my driver is pointing seleniumTesting page
        WebElement header1=driver.findElement(By.tagName("h1"));
        Assert.assertTrue(BrowserUtils.getText(header1).equals("Category Archives: SeleniumTesting"));
        BrowserUtils.switchByTitle(driver,"iframes");
        driver.switchTo().frame("Frame2");
        WebElement category3=driver.findElement(By.linkText("Category3"));
        category3.click();
        BrowserUtils.switchByTitle(driver,"SoftwareTesting Archives");
        WebElement header2=driver.findElement(By.tagName("h1"));
        SoftAssert softAssert=new SoftAssert();
        softAssert.assertTrue(BrowserUtils.getText(header2).equals("Category Archives: SoftwareTesting"));
        softAssert.assertTrue(driver.getCurrentUrl().equals("https://qavalidation.com/category/softwaretesting/"));
        softAssert.assertAll();
        driver.quit();





    }
}
