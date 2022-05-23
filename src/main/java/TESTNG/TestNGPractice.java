package TESTNG;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TestNGPractice {

    @Test(invocationCount = 1)
    public void urlValidation(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demo.opencart.com/admin/");
        String actualUrl=driver.getCurrentUrl();
        String expectedUrl="https://demo.opencart.com/admin/";
        Assert.assertEquals(actualUrl,expectedUrl);
        //NOTE: as a tester always do at least one negative scenario
    }
    /*
    0-Create another @Test annotation
    1-Navigate to the website
    2-Login to the website
    3-click catalog
    4-Validate(Assert) the "Products" is displayed.
     */
    @Test
    public void validateProductIsDisplayed() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demo.opencart.com/admin/");
        WebElement loginButton=driver.findElement(By.tagName("button"));
        loginButton.click();
        WebElement catalogButton=driver.findElement(By.xpath("//a[.=' Catalog']"));
        catalogButton.click();
        Thread.sleep(3000);
        WebElement products=driver.findElement(By.xpath("//a[contains(text(),'Products')]"));
        System.out.println(products.isDisplayed());
        boolean actualResult=products.isDisplayed();//
        boolean expectedResult=true;
        Assert.assertEquals(actualResult,expectedResult);
    }

    @Test
    public void validateTheBoxes() throws InterruptedException {
        /*
        1-Navigate to the website
        2-Click Catalog
        3-Click Product
        4-Find the all boxes and store them(List<WebElement>
        5-Validate all boxes are displayed(ASSERTION)
        6-Click the boxes one by one.(Please do not click the first one.it means use regular for loop)
        7-Validate the boxes are selected.(ASSERTION)

         */
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demo.opencart.com/admin/");
        WebElement loginButton=driver.findElement(By.tagName("button"));
        loginButton.click();
        WebElement catalogButton=driver.findElement(By.xpath("//a[.=' Catalog']"));
        catalogButton.click();
        WebElement productButton=driver.findElement(By.xpath("//a[contains(text(),'Products')]"));
        Thread.sleep(3000);
        productButton.click();
        List<WebElement> allCheckBoxes=driver.findElements(By.xpath("//input[@type='checkbox']"));//20

        for(int i=1;i<allCheckBoxes.size();i++){
            Assert.assertEquals(allCheckBoxes.get(i).isDisplayed(),true);
            allCheckBoxes.get(i).click();
            Thread.sleep(500);//this for me to see one by one it is clicking.(OPTIONAL)
            Assert.assertEquals(allCheckBoxes.get(i).isSelected(),true);
        }

    }
    @Test
    public void validationAscendingOrder() throws InterruptedException {
        /*
        1-Navigate to the website
        2-Click Catalog
        3-Click Product
        4-Find the all names and store them(List<WebElement>
        5-Validate the all items are ascending order.

         */
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demo.opencart.com/admin/");
        WebElement loginButton=driver.findElement(By.tagName("button"));
        loginButton.click();
        WebElement catalogButton=driver.findElement(By.xpath("//a[.=' Catalog']"));
        catalogButton.click();
        WebElement productButton=driver.findElement(By.xpath("//a[contains(text(),'Products')]"));
        Thread.sleep(3000);
        productButton.click();
        List<WebElement> allBrands=driver.findElements(By.xpath("//tr/td[3]"));

        List<String>actualBrands=new ArrayList<>();
        List<String>expectedBrands=new ArrayList<>();
        for(int i = 1;i<allBrands.size();i++){
            actualBrands.add(allBrands.get(i).getText().toLowerCase());
            expectedBrands.add(allBrands.get(i).getText().toLowerCase());
            Collections.sort(expectedBrands);
          //  Assert.assertEquals(actualBrands.get(i).trim(),expectedBrands.get(i).trim());
            Assert.assertEquals(actualBrands,expectedBrands);
        }
        System.out.println(actualBrands);
        System.out.println(expectedBrands);
    }
}
