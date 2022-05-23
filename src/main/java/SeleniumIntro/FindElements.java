package SeleniumIntro;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class FindElements {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","chromedriver1");
        WebDriver driver= new ChromeDriver();
        driver.get("file:///Users/techtorial/Downloads/Techtorialhtml.html");
       List<WebElement> allCheckBoxes= driver.findElements(By.xpath("//input[@type='crererheckbox']"));
        System.out.println(allCheckBoxes);
       for(WebElement checkbox:allCheckBoxes){
           System.out.println(checkbox.isSelected());//only selenium will give me true
           if(checkbox.isSelected()==false){
               checkbox.click();
           }
           System.out.println(checkbox.isSelected());//only selenium will give false
       }
    }
}
