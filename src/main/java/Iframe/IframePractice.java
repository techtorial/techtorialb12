package Iframe;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import utils.BrowserUtils;

import javax.sql.rowset.BaseRowSet;

public class IframePractice {

    @Test
    public void IframeTest(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/");
        driver.manage().window().maximize();
        WebElement Frames=driver.findElement(By.linkText("Frames"));
        Frames.click();
        WebElement iframes=driver.findElement(By.linkText("iFrame"));
        iframes.click();
        driver.switchTo().frame("mce_0_ifr");
        WebElement message=driver.findElement(By.xpath("//body[@id='tinymce']"));
        System.out.println(message.getText().trim());
        //NOTE:If you are getting "NOSUCHELEMENTEXCEPTION"
           //First check your Xpath
           //Second Check your multiple tabs you have it or not
          //Check you maximized your screen or not.
         //***Check is there any iframe/frame in the website and make sure your element
        //is not inside of it.If it is inside then switch your frame.
        driver.switchTo().parentFrame();
        WebElement header=driver.findElement(By.tagName("h3"));
        System.out.println(BrowserUtils.getText(header));
    }
}
