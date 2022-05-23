package Actions;

import io.github.bonigarcia.wdm.WebDriverManager;
import javafx.scene.layout.BackgroundRepeat;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BrowserUtils;

import java.util.*;

public class HoverOver {

    @Test
    public void hoverOver() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/");
        WebElement hover=driver.findElement(By.linkText("Hovers"));
        hover.click();
        List<WebElement> allNames=driver.findElements(By.tagName("h5"));//3 names
        List<WebElement> allPictures=driver.findElements(By.xpath("//div[@class='figure']/img"));//3 images
        List<String> expectedNames= Arrays.asList("name: user1","name: user2","name: user3");
        List<String> actualNames=new ArrayList<>();
        Actions actions=new Actions(driver);
        for(int i = 0; i<allNames.size();i++){
            Thread.sleep(3000);
            actions.moveToElement(allPictures.get(i)).perform();//index 0
            Thread.sleep(3000);
            actualNames.add(BrowserUtils.getText(allNames.get(i)));
            System.out.println(BrowserUtils.getText(allNames.get(i)));//nothing
        }
        Assert.assertEquals(actualNames,expectedNames);
    }

    @Test
    public void HoverOverPractice(){
        /*
        1-Navigate to the website "https://demos.telerik.com/kendo-ui/fx/expand'
        2-If you see Accept Cookies, click it
        3-Get all the names of the products and prices
        4-Sort both of them
        5-Print them out on your console.
         */
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demos.telerik.com/kendo-ui/fx/expand");
        WebElement acceptCookies=driver.findElement(By.id("onetrust-accept-btn-handler"));
        acceptCookies.click();
        List<WebElement>allPictures=driver.findElements(By.xpath("//div[@class='product k-listview-item']"));//30
        List<WebElement>allNames=driver.findElements(By.xpath("//div[@class='product-description']//h3"));//30
        List<WebElement>allPrices=driver.findElements(By.xpath("//div[@class='product-description']//p"));//30
        List<String> names=new ArrayList<>();
        List<Double> prices=new ArrayList<>();
        Actions actions=new Actions(driver);
        Map<String,Double> AllProduct=new HashMap<>();
        for(int i=0;i<allPictures.size();i++){
            actions.moveToElement(allPictures.get(i)).perform();
            names.add(BrowserUtils.getText(allNames.get(i)));
            prices.add(Double.parseDouble(BrowserUtils.getText(allPrices.get(i)).substring(1)));
            AllProduct.put(names.get(i),prices.get(i));
        }
        System.out.println(AllProduct);
//        Collections.sort(names);
//        Collections.sort(prices);
//        System.out.println(names);
//        System.out.println(prices);


    }
}
