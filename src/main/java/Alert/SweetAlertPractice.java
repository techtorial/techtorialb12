package Alert;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SweetAlertPractice {

    @Test
    public void sweetAlert(){
        /*
        TASK:
        1-Navigate to the website
        2-click preview button under Normal Alert(JS ALERT)
        3-Validate the message "Oops, something went wrong!"
        4-Click Ok Button
        5-Click preview button under Sweet Alert  (HTML ALERT)
        6-Validate the message "Something went wrong!"
        7-Click Ok button
        8-CLose the webpage
         */
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://sweetalert.js.org/");
        WebElement NormalPreviewButton=driver.findElement(By.xpath("//button[contains(@onclick,'alert')]"));
        NormalPreviewButton.click();
        Alert alert = driver.switchTo().alert();
        String actualText=alert.getText();
        String expectedText="Oops, something went wrong!";
        Assert.assertEquals(actualText,expectedText);
        alert.accept();
        WebElement sweetPreviewButton=driver.findElement(By.xpath("//button[contains(@onclick,'swal')]"));
        sweetPreviewButton.click();
//        Alert alert1=driver.switchTo().alert(); I cannot handle HTML pop-ups with Alert interface
//        alert1.accept();
        WebElement clickOk=driver.findElement(By.xpath("//button[@class='swal-button swal-button--confirm']"));
        clickOk.click();
        //NOTE:Another xpath for preview button://h5[contains(text(),'Normal alert')]//..//button
    }
}
