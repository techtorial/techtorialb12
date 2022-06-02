package MentoringWithAhmet.com.test.sentrifugo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.BrowserUtils;

public class LoginPage {

    public LoginPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//input[@id='username']")
    WebElement username;

    @FindBy(xpath = "//input[@id='password']")
    WebElement password;

    @FindBy(id = "loginsubmit")
    WebElement loginButton;

    @FindBy(xpath = "//div[@id='usernameerror']")
    WebElement usernameError;

    @FindBy(xpath = "//div[@id='pwderror']")
    WebElement passwordError;

    public void login(String username,String password){
        this.username.sendKeys(username);
        this.password.sendKeys(password);
        loginButton.click();//div[@id='pwderror']
    }

    public String userNameError(){
        return BrowserUtils.getText(usernameError);
    }

    public String passwordError(){
        return BrowserUtils.getText(passwordError);
    }

    public String getColorOfMessage(){
        return usernameError.getCssValue("color");
    }





}
