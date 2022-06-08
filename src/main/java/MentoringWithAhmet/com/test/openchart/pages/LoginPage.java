package MentoringWithAhmet.com.test.openchart.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    public LoginPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    @FindBy(id = "input-username")
    WebElement username;

    @FindBy(id = "input-password")
    WebElement password;

    @FindBy(xpath = "//button")
    WebElement loginButton;

    public void loginOpenChart(String username,String password){
        this.username.sendKeys(username);
        this.password.sendKeys(password);
        loginButton.click();

    }
}
