package SeleniumIntro;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumBasics {
    public static void main(String[] args) {
        //STEP1:We need to define the chrome driver into the
        //project as a property.
        System.setProperty("webdriver.chrome.driver","chromedriver1");//mac
      //  System.setProperty("webdriver.chrome.driver","chromedriver1.exe")-->Windows
        //STEP2:We need to instantiate(declare) our Chrome driver.
        WebDriver driver=new ChromeDriver();//INTERVIEW QUESTIONS.WHERE DO YOU USE POLYMORPHISM IN YOUR FRAMEWORK
        driver.manage().window().maximize();
        //getCurrentUrl()-->it gets the url of the website.
        System.out.println(driver.getCurrentUrl()+"Before anything");//empty
        //get()-->it will navigate to the website.

        driver.get("https://www.techtorialacademy.com/");
        System.out.println(driver.getCurrentUrl()+"After navigation");//techtorial academy.com
        String actualURL=driver.getCurrentUrl();
        String expectedURL="https://www.techtorialacademy.com/";
        if(actualURL.equals(expectedURL)){
            System.out.println("passed");
        }else{
            System.out.println("failed");
        }
        String actualTitle=driver.getTitle();
        String expectedTitle="Home Page - Techtorial";
        if(actualTitle.equals(expectedTitle)){
            System.out.println("Passed");
        }else{
            System.out.println("Failed");
        }

    }
}
