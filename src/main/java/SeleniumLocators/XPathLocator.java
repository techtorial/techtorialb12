package SeleniumLocators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class XPathLocator {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","chromedriver1");
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("file:///Users/techtorial/Downloads/Techtorialhtml.html");
        WebElement phone=driver.findElement(By.xpath("//input[@name='phone']"));
        phone.sendKeys("123456789");
        WebElement adress=driver.findElement(By.xpath("//input[@name='address1']"));
        adress.sendKeys("aghag");
        Thread.sleep(3000);
        WebElement homeLink=driver.findElement(By.xpath("//a[@href='https://www.techtorialacademy.com/']"));
        homeLink.click();
        Thread.sleep(3000);

    }
}
