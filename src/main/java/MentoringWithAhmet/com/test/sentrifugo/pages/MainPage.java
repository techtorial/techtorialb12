package MentoringWithAhmet.com.test.sentrifugo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.BrowserUtils;

public class MainPage {

    public MainPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//div[@class='member_name']")
    WebElement role;

    @FindBy(xpath = "//div[@class='no_interview']")
    WebElement interview;

    @FindBy(xpath = "//a[@title='Departments']")
    WebElement department;

    public String getRoleName(){
         return role.getText().trim();//BrowserUtils.getText(role)
    }

    public String getInterviewMessage(){
        return BrowserUtils.getText(interview);
    }

    public void clickDepartment(){
        department.click();
    }


}
