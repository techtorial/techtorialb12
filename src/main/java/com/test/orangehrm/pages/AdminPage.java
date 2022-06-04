package com.test.orangehrm.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdminPage {

    public AdminPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    @FindBy(id = "btnAdd")
    WebElement addButton;

    public void clickAddButton(){
        addButton.click();
    }

}
