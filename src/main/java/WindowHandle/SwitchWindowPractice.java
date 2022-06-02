package WindowHandle;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BrowserUtils;

import javax.sql.rowset.BaseRowSet;
import java.util.Set;

public class SwitchWindowPractice {

    @Test
    public void practice(){
        /*
        TASK:
          1-Navigate to the website "https://www.hyrtutorials.com/p/window-handles-practice.html"
          2-Click Open New Tab under Button2
          3-Get the title of the newTab and validate"
          4-Get the header of the newTab and validate "AlertsDemo"
          5-Close the newTab
          6-Validate the Header of MainPage(which you navigated first) with "Window Handles Practice"
         */
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.get("https://www.hyrtutorials.com/p/window-handles-practice.html");
        driver.manage().window().maximize();
        WebElement button2=driver.findElement(By.id("newTabBtn"));
        BrowserUtils.scrollWithJS(driver,button2);
        button2.click();//note i will switch the title
        String mainId=driver.getWindowHandle();//mainPageId
        Set<String> allPagesIds=driver.getWindowHandles();
         for(String id:allPagesIds){
             if(!id.equals(mainId)){
                 driver.switchTo().window(id);
             }
         }
        String actualTitle=driver.getTitle();
        String expectedTitle="AlertsDemo - H Y R Tutorials";
        Assert.assertEquals(actualTitle,expectedTitle);
        WebElement header=driver.findElement(By.xpath("//h1[@class='post-title entry-title']"));
        String actualHeader= BrowserUtils.getText(header);
        String expectedHeader="AlertsDemo";
        Assert.assertEquals(actualHeader,expectedHeader);
        driver.close();
        driver.switchTo().window(mainId);
        WebElement headerMain=driver.findElement(By.xpath("//h1[@class='post-title entry-title']"));
        String actualHeaderMain=BrowserUtils.getText(headerMain);
        String expectedHeaderMain="Window Handles Practice";
        Assert.assertEquals(actualHeaderMain,expectedHeaderMain);
    }
}
