package Mentoringz.NetflixLogin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;

public class loginParameter {

    public static void clickByNumber(ArrayList<WebElement> elements, int number) {


        if(number>elements.size() || elements.size()==0) {
            System.out.println("HA HA DOESNT WORK");
        }else{ elements.get(number).click();}
    }

    public static void main(String[] args) throws InterruptedException {


        System.setProperty("webdriver.chrome.driver","chromedriver1");
        WebDriver driver= new ChromeDriver();

        driver.get("https://www.cvs.com");


        ArrayList<WebElement> cards = (ArrayList<WebElement>) driver.findElements(By.xpath("//div[@class=\"slider1-cards\"]"));


        clickByNumber(cards,2);


        Thread.sleep(2000);

        ArrayList<WebElement> images = (ArrayList<WebElement>) driver.findElements(By.xpath("//div[@class=\"css-1dbjc4n r-16lk18l r-11g3r6m\"]"));


        clickByNumber(images ,6);



        Thread.sleep(10000);
//
//
    }

}
