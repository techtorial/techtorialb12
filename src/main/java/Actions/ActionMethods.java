package Actions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.checkerframework.checker.units.qual.A;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class ActionMethods {

    @Test
    public void ContextClick(){
        //contextClick-->Right Click
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/");
        WebElement contextLink=driver.findElement(By.partialLinkText("Context"));
        contextLink.click();
        WebElement box=driver.findElement(By.id("hot-spot"));
        Actions actions=new Actions(driver);
        actions.contextClick(box).perform();
    }

    @Test
    public void ContextClickPractice2(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demo.guru99.com/test/simple_context_menu.html");
        WebElement button=driver.findElement(By.xpath("//span[contains(text(),'right click me')]"));
        Actions actions=new Actions(driver);
        actions.contextClick(button).perform();
    }

    @Test
    public void DoubleClick(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demo.guru99.com/test/simple_context_menu.html");
        WebElement button=driver.findElement(By.xpath("//button[contains(text(),'Double-Click')]"));
        Actions actions=new Actions(driver);
        actions.doubleClick(button).perform();
//        actions.click(button).perform(); it will not work
//        actions.click(button).perform();
//        button.click(); it will not work
//        button.click();
    }
    @Test
    public void DoubleClickPractice(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://selenium08.blogspot.com/2019/11/double-click.html");
        WebElement button=driver.findElement(By.xpath("//button[.='Double-Click me to see Alert message']"));
        Actions actions=new Actions(driver);
        actions.doubleClick(button).perform();
    }
}
