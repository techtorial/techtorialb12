package SeleniumLocators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LocatorsIntro {

    public static void main(String[] args) {
        //LOCATOR:ID
        System.setProperty("webdriver.chrome.driver","chromedriver1");
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("file:///Users/techtorial/Downloads/Techtorialhtml.html");
        WebElement header=driver.findElement(By.id("techtorial1"));
        String actualHeader=header.getText();
        String expectedHeader="Techtorial Academy";
        if(actualHeader.equals(expectedHeader)){
            System.out.println("passed");
        }else{
            System.out.println("failed");
        }
        WebElement paragraph=driver.findElement(By.id("details2"));
        System.out.println(paragraph.getText());
        //LOCATOR: CLASS
        WebElement allTools=driver.findElement(By.className("group_checkbox"));
        System.out.println(allTools.getText());
        //LOCATOR: NAME
        WebElement nameBox=driver.findElement(By.name("firstName"));
        nameBox.sendKeys("Ahmet");
        WebElement lastNameBox=driver.findElement(By.name("lastName"));
        lastNameBox.sendKeys("Baldi");
        WebElement phoneBox=driver.findElement(By.name("phone"));
        phoneBox.sendKeys("3123232");
        WebElement emailBox=driver.findElement(By.id("userName"));
        emailBox.sendKeys("ahmet@gmail.com");
//        WebElement submitButton=driver.findElement(By.id("submitbutton"));
//        submitButton.click();
        //Click(),isSelected(),isDisplayed()
        WebElement javaBox=driver.findElement(By.id("cond1"));
        System.out.println(javaBox.isDisplayed());;//boolean(true)
        System.out.println(javaBox.isSelected());//boolean(false)
        javaBox.click();//it clicks the box,button...(element)
        System.out.println(javaBox.isSelected());//boolean(true)

        WebElement testNG=driver.findElement(By.id("cond3"));
        System.out.println(testNG.isDisplayed());
        testNG.click();
        System.out.println(testNG.isSelected());

        WebElement cucumber=driver.findElement(By.id("cond4"));
        System.out.println(cucumber.isDisplayed());
        cucumber.click();
        System.out.println(cucumber.isSelected());



        //GIVE A MAN A FISH YOU FEED HIM FOR A DAY
        //TEACH A MAN TO FISH YOU FEED HIM FOR LIFETIME
    }


}
