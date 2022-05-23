package SeleniumIntro;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class FindElementPractice2 {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","chromedriver1");
        WebDriver driver= new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com");
        /*
        1-Navigate to the website
        2-Find all the webelements
        3-Print out the only links that length is less than 12
        4-Count
         */
        List<WebElement> allLinks=driver.findElements(By.xpath("//li"));
        int counter=0;
        for(WebElement link:allLinks){
            if(link.getText().trim().length()<12){
                System.out.println(link.getText().trim());
                counter++;
            }
        }
        System.out.println(counter);

    }
}
