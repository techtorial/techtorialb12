package Mentoringz;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class Paint {

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","chromedriver1");
        WebDriver driver= new ChromeDriver();

        driver.get("https://kleki.com/");

        Thread.sleep(2000);

        WebElement canvas = driver.findElement(By.xpath("//canvas"));



        Actions actions = new Actions(driver);

        actions
                .moveToElement(canvas)
                .clickAndHold()
                .moveByOffset(-100,0)
                .moveByOffset(0,100)
                .release()
                .moveByOffset(0,100)
                .clickAndHold()
                .moveByOffset(0,100)
                .perform();

        Thread.sleep(100000);
        driver.quit();
    }


}
