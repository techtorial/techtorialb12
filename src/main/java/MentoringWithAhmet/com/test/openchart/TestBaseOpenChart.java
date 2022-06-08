package MentoringWithAhmet.com.test.openchart;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utils.BrowserUtils;
import utils.ConfigReader;
import utils.DriverHelper;

public class TestBaseOpenChart {
    public WebDriver driver;
    @BeforeMethod
    public void setup(){
        driver= DriverHelper.getDriver();
        driver.get(ConfigReader.readProperty("urlopenchart"));//Please use ConfigReader for this part
    }

    @AfterMethod
    public void tearDown(ITestResult result){
        if(!result.isSuccess()){
            BrowserUtils.getScreenShot(driver,"OpenChartScreenShot");
        }
         driver.quit();

    }
}


/*
1-navigate to the website"https://demo.opencart.com/admin/index.php?route=common/login"
2-LoginPage--> login to the website username is "demo" and password is "demo"
3-Login to the openchartWebsite and validate the you are on the mainpage(url,title)
4-MainPage-->do these all validations:
     -Validate totalOrder is "7"
     -Validate totalSale is "1.4K"
     -Validate totalCustomer is "136"
     -Validate PeopleOnline  is "78

5-CustomerPage --> CLick customers from the side tab
6- fill these all boxes
7-click the switch button of news letter and make it on.

BONUS: Validate the message after you click save button ****


 */
