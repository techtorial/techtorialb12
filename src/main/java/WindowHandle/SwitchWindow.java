package WindowHandle;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BrowserUtils;

import java.util.Set;

public class SwitchWindow {

    @Test
    public void practice(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/");
        WebElement multipleWindow=driver.findElement(By.linkText("Multiple Windows"));
        multipleWindow.click();
        WebElement clickhere=driver.findElement(By.xpath("//*[.='Click Here']"));
        clickhere.click();
        WebElement header=driver.findElement(By.tagName("h3"));
        System.out.println(header.getText());
        Assert.assertTrue(BrowserUtils.getText(header).equals("New Window"));
        //NOTE:THIS WILL FAIL BECAUSE OUR DRIVER IS STILL IN THE PREVIOUS PAGE.TO BE ABLE TO DO
        //ANY ACTIONS(MANIPULATIONS) ON THE NEW TAB/WINDOW, We have to "SWITCH" OUR DRIVER TO THE NEW
        //PAGE.
    }
    @Test
    public void switchingWindow(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/");
        WebElement multipleWindow=driver.findElement(By.linkText("Multiple Windows"));
        multipleWindow.click();
        WebElement clickhere=driver.findElement(By.xpath("//*[.='Click Here']"));
        clickhere.click();
        String mainId=driver.getWindowHandle();//I am expecting one id
        Set<String> allPageIds=driver.getWindowHandles();
        for(String id:allPageIds){//123
            System.out.println(id);//I am expecting 2 ids but one of them will be my mainid
            if(!id.equals(mainId)){//123,345
                driver.switchTo().window(id);
            }
        }
        System.out.println(driver.getWindowHandle());
        WebElement header=driver.findElement(By.tagName("h3"));
        System.out.println(header.getText());
        Assert.assertTrue(BrowserUtils.getText(header).equals("New Window"));
    }
}
