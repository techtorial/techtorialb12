package SeleniumLocators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AbsoluteXpath {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","chromedriver1");
        WebDriver driver= new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com");
        WebElement clickAB=driver.findElement(By.linkText("A/B Testing"));
        clickAB.click();
        WebElement text=driver.findElement(By.xpath("/html/body/div[2]/div/div/p"));
        System.out.println(text.getText());
        WebElement text2=driver.findElement(By.xpath("//a[contains(text(),'Elemental')]"));
        System.out.println(text2.getText().trim());
        WebElement text3=driver.findElement(By.xpath("//a[.='Elemental Selenium']"));
        System.out.println(text3.getText().trim());



    }
}
