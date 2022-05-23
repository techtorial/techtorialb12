package SeleniumIntro;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class YahooInterviewQuestion {

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","chromedriver1");
        WebDriver driver= new ChromeDriver();
        driver.get("https://www.yahoo.com/");
        /*
        1-Navigate to the website
        2-Click news
        3-Find all the headers and check for the "US" it has or not
        4-If it has it print out and count++
        5-Sout total count()
         */
        WebElement news = driver.findElement(By.id("root_2"));
        news.click();
        List<WebElement> headers=driver.findElements(By.tagName("h3"));
        int counter=0;
        for(WebElement header:headers){
            if(header.getText().contains("US")){
                System.out.println(header.getText().trim());
                counter++;
            }
        }
        System.out.println(counter);
    }
}
