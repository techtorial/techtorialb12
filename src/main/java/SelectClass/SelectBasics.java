package SelectClass;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class SelectBasics {

    @Test
    public void practiceSelect(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/");
        WebElement dropDown=driver.findElement(By.linkText("Dropdown"));
        dropDown.click();
        WebElement dropBox=driver.findElement(By.xpath("//select[@id='dropdown']"));
        Select select =new Select(dropBox);
        List<WebElement> allOptions=select.getOptions();
        //GetOptions()-->it will give you all the options from dropDown.
        for(WebElement option:allOptions){
            System.out.println(option.getText());
        }
        WebElement firstOption=select.getFirstSelectedOption();
        String actualOption=firstOption.getText().trim();
        String expectedOption="Please select an option";
        Assert.assertEquals(actualOption,expectedOption);

        select.selectByValue("2");
        select.selectByValue("1");

        select.selectByIndex(0);

        select.selectByVisibleText("Option 2");


    }
}
