package Mentoringz;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.HashMap;
import java.util.List;

public class Music {


    public static void playNotes(String[] notes, HashMap<String,WebElement> instrument) throws InterruptedException {

        for(String note : notes) {

            if(note.equals("pause")) {


                Thread.sleep(500);
            }else {instrument.get(note).click();
                Thread.sleep(500);}

        }

    }



    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "chromedriver1");
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.musicca.com/piano");

        List<WebElement> keys = driver.findElements(By.xpath("//span[@data-key]"));

        HashMap<String,WebElement> keyboard = new HashMap<>();

        for( WebElement key : keys) {
            keyboard.put(key.getAttribute("data-note"),key);
        }

        String[] music = {"2g","2g","2g","2d","2e","2e","2d","pause","3b","3b","3a","3a","2g"};
       playNotes(music,keyboard);

        Thread.sleep(2000);

    }
}
