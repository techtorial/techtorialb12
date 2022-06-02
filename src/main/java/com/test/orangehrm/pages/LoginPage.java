package com.test.orangehrm.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.BrowserUtils;

public class LoginPage {
    //I store all of my LoginPage elements and methods here
    public LoginPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    @FindBy(id ="txtUsername")
    WebElement username;

    @FindBy(name = "txtPassword")
    WebElement password;

    @FindBy(xpath = "//input[@id='btnLogin']")
    WebElement loginButton;

    @FindBy(id = "spanMessage")
    WebElement message;

    public void sendInformation(String username,String password) throws InterruptedException {
        this.username.sendKeys(username);
        this.password.sendKeys(password);
        Thread.sleep(3000);
        loginButton.click();
    }

    public String errorMessage(){
        return BrowserUtils.getText(message);
    }

    public String getColorOfMessage(){
        return message.getCssValue("color");
    }

}
