package SeleniumIntro;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class YoutubeGeTAttribute {
    /*(GET ATTRIBUTE)
    1-Navigate to the youtube
    2-Search your favorite singer(Justin Bieber)
    3-Store all the song names
    4-click the one that you want "Justin Bieber - Love Yourself (Official Music Video)
    5-Make sure the music is playing and sout(url)
     */
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","chromedriver1");
        WebDriver driver=new ChromeDriver();
        driver.get("https://www.youtube.com/");
        driver.manage().window().maximize();
        WebElement searchBox=driver.findElement(By.xpath("//input[@id='search']"));
        searchBox.sendKeys("Justin Bieber");
        WebElement searchButton=driver.findElement(By.id("search-icon-legacy"));
       Thread.sleep(3000);
        searchButton.click();
        Thread.sleep(3000);
        List<WebElement> allSongs=driver.findElements(By.xpath("//a[@id='video-title']"));//23 songs

        for(WebElement song:allSongs){
            System.out.println(song.getText());
        }

    }
}
