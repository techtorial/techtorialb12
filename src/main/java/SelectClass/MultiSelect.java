package SelectClass;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import utils.BrowserUtils;

public class MultiSelect {

    @Test
    public void practiceMultiSelect(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("file:///Users/techtorial/Downloads/Techtorialhtml.html");
        WebElement countryList=driver.findElement(By.xpath("//select[@class='select']"));
        BrowserUtils.selectBy(countryList,"1","value");
        BrowserUtils.selectBy(countryList,"Two","text");
        BrowserUtils.selectBy(countryList,"4","index");
        Select select =new Select(countryList);
        select.deselectByVisibleText("One");
        select.deselectAll();

    }
}
