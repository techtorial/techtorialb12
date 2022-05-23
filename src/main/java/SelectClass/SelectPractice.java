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
import java.util.List;

public class SelectPractice {

    @Test
    public void validationOfTripButton(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demo.guru99.com/test/newtours/reservation.php");
        WebElement oneWayButton=driver.findElement(By.xpath("//input[@value='oneway']"));
        oneWayButton.click();
        Assert.assertTrue(oneWayButton.isDisplayed());//onewaybutton.isDisplayed returns boolean
        //condition.It is coming from system which means your actual.
        //AssertTrue-->is your expectation from the condition.
       // Assert.assertEquals(oneWayButton.isDisplayed(),true);
        Assert.assertTrue(oneWayButton.isSelected());
    }

    @Test
    public void validationPassengerAndMessage(){
        /*
        1-Navigate to the website
        2-Validate the the round trip is selected
        3-Choose 3 passenger from the options
        4-validate departing from is "Acapulco"
        5-Choose the departure as "Paris'
        6-Choose the date August 13
        7-Choose Arriving in New York
        8-Choose returning September 28
        9-Choose First Class from option
        10-Get all the options and validate these options as expected.(You can use asList Method)
        11-Click Continue
        12-Validate the no seats available.(this one should fail). Take a screen shot and send
        it to the developer (Ahmet).
         */
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demo.guru99.com/test/newtours/reservation.php");
        WebElement roundTrip=driver.findElement(By.xpath("//input[@value='roundtrip']"));
        Assert.assertTrue(roundTrip.isSelected());
        WebElement passenger=driver.findElement(By.name("passCount"));
        Select passengerBox=new Select(passenger);
        passengerBox.selectByVisibleText("3");
        WebElement departFrom=driver.findElement(By.name("fromPort"));
        Select departFromBox=new Select(departFrom);
        String actualResult=departFromBox.getFirstSelectedOption().getText().trim();
        String expectedResult="Acapulco";
        Assert.assertEquals(actualResult,expectedResult);
        departFromBox.selectByValue("Paris");
        WebElement fromOn=driver.findElement(By.name("fromMonth"));
        Select fromOnBox=new Select(fromOn);
        fromOnBox.selectByVisibleText("August");
        WebElement fromDate=driver.findElement(By.name("fromDay"));
        Select fromDateBox=new Select(fromDate);
        fromDateBox.selectByIndex(12);
        WebElement toPort=driver.findElement(By.name("toPort"));
        Select toPortBox=new Select(toPort);
        toPortBox.selectByValue("New York");
        WebElement toPortDate=driver.findElement(By.name("toMonth"));
        Select toPortDateBox=new Select(toPortDate);
        toPortDateBox.selectByValue("9");
        WebElement toPortDay=driver.findElement(By.name("toDay"));
        Select toPortDayBox=new Select(toPortDay);
        toPortDayBox.selectByVisibleText("28");
        WebElement classForTrip=driver.findElement(By.xpath("//input[@value='First']"));
        classForTrip.click();
        WebElement option=driver.findElement(By.xpath("//select[@name='airline']"));
        Select airlineBox=new Select(option);
        List<WebElement> allOptions=airlineBox.getOptions();//I have all options
        List<String> actualOptions=new ArrayList<>();
        List<String> expectedOptions= Arrays.asList("No Preference","Blue Skies Airlines",
                "Unified Airlines","Pangea Airlines");//this one is coming from (acceptance cri)
        for(WebElement options:allOptions){//this one is coming from system
            actualOptions.add(options.getText().trim());
        }
        Assert.assertEquals(actualOptions,expectedOptions);
        WebElement continueButton=driver.findElement(By.name("findFlights"));
        continueButton.click();
        WebElement message=driver.findElement(By.xpath("//font[@face='Arial, Helvetica, sans-serif']//font[@size='4']"));
        System.out.println(message.getText().trim());
       // Assert.assertTrue(message.getText().trim().equals("After flight finder - No Seats Available"));
        String actualMessage=message.getText().trim();
        String expectedMessage="After flight finder - No Seats Available";
        Assert.assertEquals(actualMessage,expectedMessage);
    }

    @Test
    public void validationPassengerSecondWay(){

        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demo.guru99.com/test/newtours/reservation.php");
        WebElement roundTrip=driver.findElement(By.xpath("//input[@value='roundtrip']"));
        Assert.assertTrue(roundTrip.isSelected());
        WebElement passenger=driver.findElement(By.name("passCount"));
        BrowserUtils.selectBy(passenger,"3","text");
        WebElement departFrom=driver.findElement(By.name("fromPort"));
        Select departFromBox=new Select(departFrom);
        String actualResult=departFromBox.getFirstSelectedOption().getText().trim();
        String expectedResult="Acapulco";
        Assert.assertEquals(actualResult,expectedResult);
        departFromBox.selectByValue("Paris");
        WebElement fromOn=driver.findElement(By.name("fromMonth"));
        BrowserUtils.selectBy(fromOn,"August","text");
        WebElement fromDate=driver.findElement(By.name("fromDay"));
        BrowserUtils.selectBy(fromDate,"12","index");
        WebElement toPort=driver.findElement(By.name("toPort"));
       // Select toPortBox=new Select(toPort);
      //  toPortBox.selectByValue("New York");
        BrowserUtils.selectBy(toPort,"New York","value");
        WebElement toPortDate=driver.findElement(By.name("toMonth"));
      //  Select toPortDateBox=new Select(toPortDate);
      //  toPortDateBox.selectByValue("9");
        BrowserUtils.selectBy(toPortDate,"9","value");
        WebElement toPortDay=driver.findElement(By.name("toDay"));
       // Select toPortDayBox=new Select(toPortDay);
      //  toPortDayBox.selectByVisibleText("28");
        BrowserUtils.selectBy(toPortDay,"28","text");
        WebElement classForTrip=driver.findElement(By.xpath("//input[@value='First']"));
        classForTrip.click();
        WebElement option=driver.findElement(By.xpath("//select[@name='airline']"));
        Select airlineBox=new Select(option);
        List<WebElement> allOptions=airlineBox.getOptions();//I have all options
        List<String> actualOptions=new ArrayList<>();
        List<String> expectedOptions= Arrays.asList("No Preference","Blue Skies Airlines",
                "Unified Airlines","Pangea Airlines");//this one is coming from (acceptance cri)
        for(WebElement options:allOptions){//this one is coming from system
            actualOptions.add(options.getText().trim());
        }
        Assert.assertEquals(actualOptions,expectedOptions);
        WebElement continueButton=driver.findElement(By.name("findFlights"));
        continueButton.click();
        WebElement message=driver.findElement(By.xpath("//font[@face='Arial, Helvetica, sans-serif']//font[@size='4']"));
        System.out.println(message.getText().trim());
        // Assert.assertTrue(message.getText().trim().equals("After flight finder - No Seats Available"));
        String actualMessage=message.getText().trim();
        String expectedMessage="After flight finder - No Seats Available";
        Assert.assertEquals(actualMessage,expectedMessage);
    }
}
