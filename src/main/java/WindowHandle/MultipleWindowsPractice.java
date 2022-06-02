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

public class MultipleWindowsPractice {

    @Test
    public void practiceMultipleWindowsHandling(){
        /*Note: you might need JS methods for this task(either click or scroll)
        TASK:
        1-Navigate to the website "https://www.hyrtutorials.com/p/window-handles-practice.html"
        2-Click open multiple tabs under button 4
        3-Switch back to the Basic Controls and validate the header Basic Controls)
        4-Fill all the required boxes and click register
        5-Validate the message :Registration is Successful)
        6-Go back to alert tabs and click one of the click me box
        7-Close all the tabs.
         */
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.get("https://www.hyrtutorials.com/p/window-handles-practice.html");
        driver.manage().window().maximize();
        WebElement button4=driver.findElement(By.id("newTabsBtn"));
        BrowserUtils.scrollWithJS(driver,button4);
        button4.click();
        Set<String> allIds=driver.getWindowHandles();//3 ids
        for(String id:allIds){
            driver.switchTo().window(id);
            if(driver.getTitle().contains("Basic Controls")){
                break;
            }
        }
        WebElement header=driver.findElement(By.xpath("//h1[@class='post-title entry-title']"));
        String actualHeader=BrowserUtils.getText(header);
        String expectedHeader="Basic Controls";
        Assert.assertEquals(actualHeader,expectedHeader);
        WebElement register=driver.findElement(By.id("registerbtn"));
        BrowserUtils.scrollWithJS(driver,register);
        WebElement firstName=driver.findElement(By.id("firstName"));
        firstName.sendKeys("Ahmetiyo");
        WebElement lastName=driver.findElement(By.id("lastName"));
        lastName.sendKeys("Baldir");
        WebElement gender=driver.findElement(By.id("femalerb"));
        gender.click();
        WebElement englishBox=driver.findElement(By.id("englishchbx"));
        englishBox.click();
        WebElement email=driver.findElement(By.xpath("//input[@id='email']"));
        email.sendKeys("Baldir@gmail.com");
        WebElement password=driver.findElement(By.xpath("//input[@id='password']"));
        password.sendKeys("1234567");
        register.click();
        WebElement message=driver.findElement(By.xpath("//label[@id='msg']"));
        Assert.assertTrue(BrowserUtils.getText(message).equals("Registration is Successful"));

        for(String id:allIds){
            driver.switchTo().window(id);
            if(driver.getTitle().contains("AlertsDemo")){
                break;
            }
        }
        WebElement alerbox=driver.findElement(By.id("alertBox"));
        alerbox.click();
       driver.quit();
    }
}
