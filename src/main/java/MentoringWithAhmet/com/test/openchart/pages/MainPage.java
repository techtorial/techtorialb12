package MentoringWithAhmet.com.test.openchart.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage {

    public MainPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//button[@class='btn-close']")
    WebElement closeButton;


    public void clickCloseButton() throws InterruptedException {
        Thread.sleep(3000);
        closeButton.click();
    }
}
