package Actions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BrowserUtils;

public class MoveByOffSet {

    @Test
    public void moveByOffSetPractice() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/horizontal_slider");
        driver.manage().window().maximize();
        WebElement slider=driver.findElement(By.tagName("input"));
        Actions actions=new Actions(driver);
        actions.clickAndHold(slider).moveByOffset(30,0).perform();
        Thread.sleep(3000);
        actions.clickAndHold(slider).moveByOffset(10,0).perform();
        Thread.sleep(3000);
        actions.clickAndHold(slider).moveByOffset(-30,0).perform();
    }

    @Test
    public void moveOffByOffSetWithPOINTCLASS(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.get("http://www.techtorialacademy.com/");
        WebElement contactUs=driver.findElement(By.xpath("//div[@class='navigation hidden-xs']//a[.='Contact Us']"));
        Point coordinatesOfContactUs=contactUs.getLocation();
        int xCord=coordinatesOfContactUs.getX();
        int yCord=coordinatesOfContactUs.getY();
        System.out.println(xCord);
        System.out.println(yCord);
        Actions actions=new Actions(driver);
        actions.moveByOffset(xCord,yCord).click().perform();

    }
    @Test
    public void sliderShortCut() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/horizontal_slider");
        WebElement slider=driver.findElement(By.tagName("input"));
        WebElement range=driver.findElement((By.id("range")));
        String rangeNumber="3";

        while(!BrowserUtils.getText(range).equals(rangeNumber)){
            Thread.sleep(1000);
            slider.sendKeys(Keys.ARROW_RIGHT);
        }
        String actualNumber=BrowserUtils.getText(range);
        String expectedNumber=rangeNumber;
        Assert.assertEquals(actualNumber,expectedNumber);
    }

}
