package com.test.orangehrm.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import utils.BrowserUtils;

public class PimPage {

    public PimPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    @FindBy(id = "btnAdd")
    WebElement addButton;

    @FindBy(name = "firstName")
    WebElement firstName;

    @FindBy(id = "lastName")
    WebElement lastName;

    @FindBy(id = "employeeId")
    WebElement employeeId;

    @FindBy(name = "photofile")
    WebElement uploadFile;

    @FindBy(xpath = "//input[@type='checkbox']")
    WebElement checkBox;

    @FindBy(id = "user_name")
    WebElement username;

    @FindBy(xpath = "//input[@id='user_password']")
    WebElement password;

    @FindBy(id = "re_password")
    WebElement confirmPassword;

    @FindBy(xpath = "//select[@id='status']")
    WebElement status;

    @FindBy(id = "btnSave")
    WebElement saveButton;

    @FindBy(id = "personal_txtEmpFirstName")
    WebElement validateNameBox;

    @FindBy(id = "personal_txtEmpLastName")
    WebElement validateLastNameBox;

    @FindBy(id = "personal_txtEmployeeId")
    WebElement validateEmployeeIdBox;

    @FindBy(xpath = "//input[@id='btnSave']")
    WebElement editButton;

    @FindBy(id = "personal_optGender_1")
    WebElement maleGender;

    @FindBy(id = "personal_cmbMarital")
    WebElement maritualStatus;

    @FindBy(id = "personal_cmbNation")
    WebElement nationality;

    @FindBy(name = "personal[DOB]")
    WebElement dob;


    public void sendPi(String firstName,String lastName,String employeeId,
                       String locationFile,String userName,String password,
                       String confirmPassword,String Status) throws InterruptedException {
        addButton.click();
        this.firstName.sendKeys(firstName);
        this.lastName.sendKeys(lastName);
        this.employeeId.sendKeys(employeeId);
        uploadFile.sendKeys(locationFile);
        checkBox.click();
        this.username.sendKeys(userName);
        this.password.sendKeys(password);
        this.confirmPassword.sendKeys(confirmPassword);
        BrowserUtils.selectBy(status,Status,"text");
        saveButton.click();
    }

    public void validationInformation(String name,String lastName,String employeeId){
        Assert.assertEquals(validateNameBox.getAttribute("value").trim(),name);
        Assert.assertEquals(validateLastNameBox.getAttribute("value").trim(),lastName);
        Assert.assertTrue(validateEmployeeIdBox.getAttribute("value").trim().endsWith(employeeId));
    }

    public void sendPersonalDetails(String status,String national,String dateOfbirth){
        editButton.click();
        maleGender.click();
        BrowserUtils.selectBy(maritualStatus,status,"value");
        BrowserUtils.selectBy(nationality,national,"text");
        dob.clear();
        dob.sendKeys(dateOfbirth);
        saveButton.click();
        }

        public void validateAfterEdit(String maritual,String national,String date){
        Select select = new Select(maritualStatus);
        Assert.assertEquals(select.getFirstSelectedOption().getText().trim(),maritual);
        Select select2=new Select(nationality);
        Assert.assertEquals(select2.getFirstSelectedOption().getText().trim(),national);
        Assert.assertEquals(dob.getAttribute("value").trim(),date);
        Assert.assertTrue(maleGender.isSelected());
        }
    }

