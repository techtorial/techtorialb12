package Actions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BrowserUtils;

public class DragAndDrop {

    @Test
    public void dragAndDropPractice(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demos.telerik.com/kendo-ui/dragdrop/area");
        WebElement draggable=driver.findElement(By.xpath("//div[@id='draggable']"));
        WebElement orangeBox=driver.findElement(By.xpath("//div[@class='test2']"));
        WebElement cookies=driver.findElement(By.id("onetrust-accept-btn-handler"));
        Actions actions = new Actions(driver);
        actions.click(cookies).perform();
        String actualMessage= BrowserUtils.getText(orangeBox);
        String expectedMessage="... Or here.";
        Assert.assertEquals(actualMessage,expectedMessage);
        actions.dragAndDrop(draggable,orangeBox).perform();
        orangeBox=driver.findElement(By.xpath("//div[@class='test2']"));
        String actualAfterDragAndDrop=BrowserUtils.getText(orangeBox);
        String expectedAfterDragAndDrop="You did great!";
        Assert.assertEquals(actualAfterDragAndDrop,expectedAfterDragAndDrop);

    }
    @Test
    public void clickAndHold(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demos.telerik.com/kendo-ui/dragdrop/area");
        WebElement draggable=driver.findElement(By.xpath("//div[@id='draggable']"));
        WebElement blueBox=driver.findElement(By.xpath("//div[@class='test1']"));
        WebElement cookies=driver.findElement(By.id("onetrust-accept-btn-handler"));
        Actions actions = new Actions(driver);
        actions.click(cookies).perform();
        String actualMessage= BrowserUtils.getText(blueBox);
        String expectedMessage="Drag the small circle here ...";
        Assert.assertEquals(actualMessage,expectedMessage);
        actions.clickAndHold(draggable).moveToElement(blueBox).release().perform();
       blueBox=driver.findElement(By.xpath("//div[@class='test1']"));
        String actualAfterDragAndDrop=BrowserUtils.getText(blueBox);
       String expectedAfterDragAndDrop="You did great!";
        Assert.assertEquals(actualAfterDragAndDrop,expectedAfterDragAndDrop);

    }

    @Test
    public void DragAndDropPractice(){
        /*
        1-Navigate to the website "https://demoqa.com/droppable"
        2-Validate the message inside of the Big box is "Drop here" -->first validation
        3-get the "Drop me" box and drop it into big box
        4-Validate the message turned to the "Dropped!"
         */
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.navigate().to("https://demoqa.com/droppable");
        WebElement dropBox=driver.findElement(By.xpath("//div[@id='simpleDropContainer']//div[@id='droppable']"));
        WebElement dragMe=driver.findElement(By.xpath("//div[@id='draggable']"));
        String actualMessage=BrowserUtils.getText(dropBox);
        String expectedMessage="Drop here";
        Assert.assertEquals(actualMessage,expectedMessage);
        Actions actions=new Actions(driver);
        actions.dragAndDrop(dragMe,dropBox).perform();
        String actualMessageAfterDrop=BrowserUtils.getText(dropBox);
        String expectedMessageAfterDrop="Dropped!";
        Assert.assertEquals(actualMessageAfterDrop,expectedMessageAfterDrop);
        String actualColor=dropBox.getCssValue("background-color");
        String expectedColor="rgba(70, 130, 180, 1)";
        Assert.assertEquals(actualColor,expectedColor);

    }

    @Test
    public void ClickAndHoldPractice(){
        /*
         1-Navigate to the website "https://demoqa.com/droppable"
         2-Click Accept
         3-Click and hold notAccepted box and release to the Drop box
         4-Validate message is still "Drop here"
         5-Click and hold acceptable box and release to Drop box
         6-Validate the message is "dropped"
         */
    }
}
