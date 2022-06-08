package Mentoring.com.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v85.page.Page;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import utils.BrowserUtils;

public class LoginSignPage {
    public LoginSignPage(WebDriver driver) {
        PageFactory.initElements(driver,this);
    }
    @FindBy(name = "name")
    private WebElement nameField;
    @FindBy(xpath = "//input[@data-qa=\"signup-email\"]")
    private WebElement signUpEmailField;
    @FindBy(xpath = "//*[@data-qa=\"signup-button\"]")
    private WebElement signUpButton;
    @FindBy(xpath = "//*[.=\"Enter Account Information\"]")
    private WebElement entAccInfoSign;


    @FindBy(xpath = "//input[@id=\"id_gender1\"]")
    private WebElement titleMr;
    @FindBy(xpath = "//input[@id=\"id_gender2\"]")
    private WebElement titleMrs;
    @FindBy(id="name")
    private WebElement nameFieldSignAcc;
    @FindBy(id = "email")
    private WebElement emailFielSignAcc;
    @FindBy(id="password")
    private WebElement passwordField;
    @FindBy(id="days")
    private WebElement selectBirthDay;
    @FindBy(id="months")
    private WebElement selectBirthMonth;
    @FindBy(id="years")
    private WebElement selectBirthYear;
     @FindBy(id="newsletter")
    private WebElement signNewsLetter;
     @FindBy(id="optin")
    private WebElement rcveOffers;
    @FindBy(id="first_name")
    private WebElement addressFirstName;
    @FindBy(id="last_name")
    private WebElement addressLastName;
    @FindBy(id="company")
    private WebElement companyName;
    @FindBy(id="address1")
    private WebElement address1Field;
    @FindBy(id="address2")
    private WebElement address2Field;
    @FindBy(id="country")
    private WebElement slectCountry;
    @FindBy(id="state")
    private WebElement stateField;
    @FindBy(id="city")
    private WebElement cityField;
    @FindBy(id="zipcode")
    private WebElement zipcodeField;
    @FindBy(id="mobile_number")
    private WebElement mobile_numberField;
    @FindBy(xpath = "//*[@data-qa=\"create-account\"]")
    private WebElement createAccButton;
public void createAcc(WebDriver driver) throws InterruptedException {
nameField.sendKeys("Yusuf");
signUpEmailField.sendKeys("any@gmail.com");
signUpButton.click();
    Assert.assertTrue(entAccInfoSign.isDisplayed());
    titleMr.click();
    nameFieldSignAcc.clear();
    nameFieldSignAcc.sendKeys("Yusuf ");
    Thread.sleep(1500);
    BrowserUtils.scrollWithJS(driver,passwordField);
    passwordField.sendKeys("1245689");
     Select s1 = new Select(selectBirthDay);
    s1.selectByValue("19");
    Select s2 = new Select(selectBirthMonth);
    s2.selectByValue("2");
    Select s3 = new Select(selectBirthYear);
    s3.selectByValue("1997");
    signNewsLetter.click();
    rcveOffers.click();
    BrowserUtils.scrollWithJS(driver,addressFirstName);
    addressFirstName.sendKeys("Yusuf");
    addressLastName.sendKeys("Trn");
    companyName.sendKeys("Techtorial");
    address1Field.sendKeys("Desp");
    address2Field.sendKeys("Chic");
    Select s = new Select(slectCountry);
    s.selectByValue("United States");
    stateField.sendKeys("IL");
    cityField.sendKeys("Des Plaines");
    BrowserUtils.scrollWithJS(driver,zipcodeField);

    zipcodeField.sendKeys("12344");
    mobile_numberField.sendKeys("2222222222");
    createAccButton.click();


}
}
