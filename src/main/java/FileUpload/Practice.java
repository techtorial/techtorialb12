package FileUpload;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BrowserUtils;

public class Practice {

    @Test
    public void fileUploadPractice() throws InterruptedException {
                /*
        1-Navigate to the "https://demo.guru99.com/test/upload/"
        2-upload the file
        3-Click the box of I accept terms of service
        4-Click submit file
        5-Validate the message "1 file has been successfully uploaded."
        6-Close the webpage
         */
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demo.guru99.com/test/upload/");
        WebElement choose=driver.findElement(By.id("uploadfile_0"));
        choose.sendKeys("/Users/techtorial/Desktop/usa.png");
        WebElement clickbox=driver.findElement(By.id("terms"));
        clickbox.click();
        WebElement submitButton=driver.findElement(By.id("submitbutton"));
        submitButton.click();
        WebElement message=driver.findElement(By.tagName("h3"));
        Thread.sleep(3000);
        String actualMessage= BrowserUtils.getText(message);
        String expectedMessage="1 file\n" +
                "has been successfully uploaded.";
        Assert.assertEquals(actualMessage,expectedMessage);
        Assert.assertTrue(BrowserUtils.getText(message).contains("has been successfully"));


    }
}
