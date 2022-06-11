package com.test.orangehrm.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.BrowserUtils;

import java.util.List;

public class AdminPage {

    public AdminPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    @FindBy(id = "btnAdd")
    WebElement addButton;

    @FindBy(id = "systemUser_userType")
    WebElement userRole;

    @FindBy(id = "systemUser_employeeName_empName")
    WebElement employeeName;

    @FindBy(id = "systemUser_userName")
    WebElement userName;

    @FindBy(name = "systemUser[status]")
    WebElement status;

    @FindBy(xpath = "//input[@name='systemUser[password]']")
    WebElement password;

    @FindBy(id = "systemUser_confirmPassword")
    WebElement confirmPassword;

    @FindBy(id = "btnSave")
    WebElement saveButton;

    @FindBy(xpath = "//a[contains(@href,'saveSystemUser')]")
    List<WebElement> allNames;

    public void clickAddButton(){
        addButton.click();
    }

    public void sendEmployeeInformation(String role,String name,String userName,String statusName
    ,String password,String confirmPassword) throws InterruptedException {
        BrowserUtils.selectBy(userRole,role,"text");
        employeeName.sendKeys(name);
        this.userName.sendKeys(userName);
        BrowserUtils.selectBy(status,statusName,"text");
        this.password.sendKeys(password);
        this.confirmPassword.sendKeys(confirmPassword);
        saveButton.click();

    }

    public boolean validationUserNameIsCreated(String userName){

        for(WebElement name:allNames){
            if(name.getText().trim().equals(userName)){
                return true;
            }
        }
        return false;
    }





}
