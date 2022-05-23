package Mentoring;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.List;

public class TestLink2 {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","chromedriver1");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/links");
       List<WebElement> list= driver.findElements(By.xpath("//a[@href=\"javascript:void(0)\"]"));
        String firstMessage= "Link has responded with staus 201 and status text Created";
        String secondMessage= "Link has responded with staus 204 and status text No Content";
        String thirdMessage = "Link has responded with staus 301 and status text Moved Permanently";
        String fourthMessage = "Link has responded with staus 400 and status text Bad Request";
        String fifthMessage= "Link has responded with staus 401 and status text Unauthorized";
        String mess = "Link has responded with staus 403 and status text Forbidden";
        String sixthMessage= "Link has responded with staus 404 and status text Not Found";
        List<String> expectedMessages= new ArrayList<>();
        expectedMessages.add(firstMessage);
        expectedMessages.add(secondMessage);
        expectedMessages.add(thirdMessage);
        expectedMessages.add(fourthMessage);
        expectedMessages.add(fifthMessage);
        expectedMessages.add(mess);
        expectedMessages.add(sixthMessage);

        for (int i = 0; i <list.size() ; i++) {
            list.get(i).click();
            WebElement messageElement = driver.findElement(By.xpath("//p[@id=\"linkResponse\"]"));
          if(  messageElement.getText().trim().equals(expectedMessages.get(i))){
              System.out.println("Expected message is displayed");
          }else {
              throw new RuntimeException();
          }

        }






    }
}
