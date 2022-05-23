package Mentoringz;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;

public class Netflixxz {


    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","chromedriver1");
        WebDriver driver= new ChromeDriver();

        driver.get("https://www.netflix.com/login");

        WebElement  login = driver.findElement(By.xpath("//input[@name='userLoginId']"));
        WebElement  password = driver.findElement(By.xpath("//input[@name=\"password\"]"));
        WebElement  button =  driver.findElement(By.xpath("//button[@type=\"submit\"]"));

      //  login.sendKeys("123456789");
      //    password.sendKeys("whatever");
     //  button.click();

        for (int i = 0; i < 10 ; i++) {

            login.sendKeys(Integer.toString(i));

        }

        ArrayList<String> names = new ArrayList<>();

        names.add("Someone");
        names.add("Qomeone");
        names.add("Romeone");
        names.add("Tomeone");
        names.add("Yomeone");
        names.add("Gomeone");
        names.add("Fomeone");
        names.add("Gomeone");
        names.add("Momeone");
        names.add("Xomeone");

        login.clear();
        for(String name : names) {

            for (int i = 0; i < name.length(); i++) {

                login.sendKeys(""+name.charAt(i));
                Thread.sleep(500);
            }
            login.clear();
        }






        Thread.sleep(10000);
        driver.quit();
    }


}
