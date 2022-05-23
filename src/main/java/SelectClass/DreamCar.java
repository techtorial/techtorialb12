package SelectClass;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BrowserUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class DreamCar {

    @Test
    public void Practice() throws InterruptedException {
        /*
        NOTE: Please use browser utils for the select classes if it is needed.
        1-Navigate to the website
        2-Choose the "New Cars" from the New/used option
        3-Choose "Lexus" for Make part
        4-Choose "RX-350"
        5-Validate the Price is selected "No max price"-->getFirstSelectedOption
        6-Choose the distance 40 mil
        7-Put your Zip code-->Before that Clear it.
        8-Click Search Button
        9-Validate the header "New Lexus RX 350 for sale"
        10-Click Sort by and choose the Lowest Price
        11-Validate the all titles has Lexus RX-350
        12-Validate the prices are ascending order.
         NOTE:As you know the sorting is working differently for String values, so what I would
         do if I were you.
            1-I would consider substring method to remove dolar$ and , from the value
            2-I would consider Parsing to the Integer or double
            3-I would create 2 list and one of them will be coming from website(actual)
                  another will come from expected(with Collections.sort(expected).Remember
                  example we did in class.
            4-Then I would validate it.


         */
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.cars.com/");
        WebElement newUsed=driver.findElement(By.id("make-model-search-stocktype"));
        WebElement make=driver.findElement(By.xpath("//select[@id='makes']"));
        WebElement model=driver.findElement(By.xpath("//select[@id='models']"));
        WebElement price=driver.findElement(By.id("make-model-max-price"));
        WebElement distance=driver.findElement(By.id("make-model-maximum-distance"));
        WebElement zipCode=driver.findElement(By.id("make-model-zip"));
        WebElement searchButton=driver.findElement(By.xpath("//button[@data-linkname='search-all-make']"));
        BrowserUtils.selectBy(newUsed,"new","value");
        BrowserUtils.selectBy(make,"Lexus","text");
        BrowserUtils.selectBy(model,"RX 350","text");
        BrowserUtils.selectBy(distance,"40","value");
        Select select =new Select(price);
        String actualPrice=select.getFirstSelectedOption().getText().trim();
        String expectedPrice="No max price";
        Assert.assertEquals(actualPrice,expectedPrice);
        zipCode.clear();
        zipCode.sendKeys("60056");
        searchButton.click();

        WebElement header=driver.findElement(By.tagName("h1"));
        String actualHeader=header.getText().trim();
        String expectedHeader="New Lexus RX 350 for sale";
        Assert.assertEquals(actualHeader,expectedHeader);

        WebElement sortButton=driver.findElement(By.id("sort-dropdown"));
        BrowserUtils.selectBy(sortButton,"Lowest price","text");
        Thread.sleep(7000);
        List<WebElement> allTitles=driver.findElements(By.xpath("//h2[@class='title']"));//20 titles
        Thread.sleep(7000);
        for(WebElement title:allTitles){
            System.out.println(title.getText().trim());
            Assert.assertTrue(title.getText().trim().contains("Lexus RX 350"));
        }
        List<WebElement> allPrices=driver.findElements(By.xpath("//span[@class='primary-price']"));//20
        //The reason I have two list with Integer here because I will compare the prices.
        List<Integer> actualPrices=new ArrayList<>();
        List<Integer> expectedPrices=new ArrayList<>();

        for(WebElement cost:allPrices){
            actualPrices.add(Integer.parseInt(cost.getText().trim().substring(1).replace(",","")));
            expectedPrices.add(Integer.parseInt(cost.getText().trim().substring(1).replace(",","")));
        }
        Collections.sort(expectedPrices);//you have to manipulate your expected data to make sure it is accurate
        Assert.assertEquals(actualPrices,expectedPrices);

    }
    @Test
    public void asds(){
        List<String> numbers= Arrays.asList("1","2","11","3","22","13"); //1,2,3,11,13,22
        List<Integer> number2=Arrays.asList(1,2,11,3,22,13);//1,2,3,11,13,22
        Collections.sort(number2);
        Collections.sort(numbers);
        System.out.println(number2);
        System.out.println(numbers);
    }
}
