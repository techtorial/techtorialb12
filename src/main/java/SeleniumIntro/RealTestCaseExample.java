package SeleniumIntro;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class RealTestCaseExample {
    //  Test Case - Open Godaddy.com and validate it's Page title and the url.
//    Steps to Automate:
//            1. Launch browser of your choice say., Firefox, chrome etc.
//            2. Open this URL - https://www.godaddy.com/
//            3. Maximize or set size of browser window.
//4. Get Title of page and validate it.(if conditions)
//4. Get URL of current page and validate it.
//            5. Close browser.(driver.close().

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","chromedriver1");
        ChromeDriver driver=new ChromeDriver();
        //WebDriver driver=new WebDriver();
        driver.manage().window().maximize();
        driver.get("https://www.godaddy.com/");
        String actualTitle=driver.getTitle();
        String expectedTitle="Domain Names, Websites, Hosting & Online Marketing Tools - GoDaddy";
        if(actualTitle.equals(expectedTitle)){
            System.out.println("title is passed");
        }else{
            System.out.println("title is failed");
        }
        String actualUrl=driver.getCurrentUrl();
        String expectedUrl="https://www.godaddy.com/";
        if(actualUrl.equals(expectedUrl)){
            System.out.println("url is passed");
        }else{
            System.out.println("url is failed");
        }
        driver.quit();//closes all the open chromes during automation
        //driver.close();//closes only the last one open.


    }


}
