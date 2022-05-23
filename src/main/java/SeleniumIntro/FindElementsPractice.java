package SeleniumIntro;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class FindElementsPractice {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","chromedriver1");
        WebDriver driver= new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com");

        /*
        1-Navigate to the website
        2-Find all the elements(subcategories) and print them out

         */
        List<WebElement> allLinks=driver.findElements(By.tagName("li"));//By.xPath("//li)"
        for(WebElement link : allLinks){
            System.out.println(link.getText().trim());
        }
    }
}
