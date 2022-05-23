package SeleniumLocators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LinksAndTags {

    public static void main(String[] args) throws InterruptedException {
        //LinkText()
        System.setProperty("webdriver.chrome.driver","chromedriver1");
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("file:///Users/techtorial/Downloads/Techtorialhtml.html");
        WebElement javaLink=driver.findElement(By.linkText("Java"));
        javaLink.click();
        /*
        1-first of all you are supposed to get the header of the oracle page(sout gettext)
        2-You need to navigate back to the main page and click Selenium and sout getTitle()
        3-Go back to the main page and click CUcumber and sout header of the page.
        4-Go back to the main page and refresh it.
         */
        WebElement headerJava=driver.findElement(By.className("rwaccent"));
        System.out.println(headerJava.getText());
      //  Thread.sleep(3000);
        driver.navigate().back(); //main
      //  Thread.sleep(3000);
        WebElement seleniumLink=driver.findElement(By.linkText("Selenium"));
        seleniumLink.click();  //selenium
        System.out.println(driver.getTitle());
       // Thread.sleep(3000);
        driver.navigate().back();//main
       // Thread.sleep(3000);

        javaLink=driver.findElement(By.linkText("Java"));
        Thread.sleep(4000);
        javaLink.click();
        WebElement cucumberLink=driver.findElement(By.linkText("Cucumber"));
        cucumberLink.click();
        WebElement headerCucumber=driver.findElement(By.className("font-light"));
        System.out.println(headerCucumber.getText());
       // Thread.sleep(3000);
        driver.navigate().back();
      //  Thread.sleep(3000);
        driver.navigate().refresh();
       // Thread.sleep(3000);

        //LOCATOR:PARTIALLINKTEXT()-->part of the linktext.(it means you can use piece of the whole word)
        //example here: we use only Rest instead of rest-api.
        WebElement restApiLink=driver.findElement(By.partialLinkText("Rest"));
        restApiLink.click();
        System.out.println(driver.getTitle());
        driver.navigate().back();


        //LOCATOR:tag name:
        WebElement version=driver.findElement(By.tagName("u"));
        System.out.println(version.getText());


        driver.get("https://the-internet.herokuapp.com");

        /*
        1-Navigate to the internet-herokuapp.com
        2-Find the Horizontal Slider with the linktext or partialLinktext and click
        3-Find the header with tagname and validate it (if)
        4-Find the paragraph and print out
        5-close the page
         */

        WebElement horizontalSlider=driver.findElement(By.linkText("Horizontal Slider"));
        horizontalSlider.click();
      //  driver.findElement(By.linkText("Horizontal Slider")).click();
        //WHENEVER YOU ARE WORKING ON GETTEXT,GETTITLE,GETCURRENTURL USE TRIM AT THE END.
        WebElement headerOfSlider=driver.findElement(By.tagName("h3"));
        String actualHeader=headerOfSlider.getText().trim();
        String expectedHeader="Horizontal Slider";
        if(actualHeader.equals(expectedHeader)){
            System.out.println("passed");
        }else{
            System.out.println("failed");
        }
        WebElement paragraph=driver.findElement(By.tagName("h4"));
        System.out.println(paragraph.getText().trim());
        driver.close();

    }
}
