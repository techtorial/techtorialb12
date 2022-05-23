package SeleniumLocators;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FacebookXpathPractice {

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "chromedriver1");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("");
    }
}
    /*
    Facebook Sign up:
Scenario:
Open a Chrome browser.
Navigate to "http://www.fb.com"
Verify that the page is redirected to "http://www.facebook.com", by getting the current URL.
Verify that there is a "Create an account" section on the page.
Make sure you use Thread.sleep after you click create account button.(since it needs little bit time to open window)
Fill in the text boxes: First Name, Surname, Mobile Number or email address, "Re-enter mobile number", new password.
Update the date of birth in the drop-down.
Select gender.
Click on "Create an account".
Verify that the account is not created.
*/

