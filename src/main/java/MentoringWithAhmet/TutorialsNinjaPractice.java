package MentoringWithAhmet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.v85.network.model.DataReceived;

public class TutorialsNinjaPractice {
    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver","chromedriver1");
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://tutorialsninja.com/demo/index.php?route=account/register");
        WebElement firstName= driver.findElement(By.id("input-firstname"));
        firstName.sendKeys("Ahmet");
        WebElement lastName=driver.findElement(By.id("input-lastname"));
        lastName.sendKeys("Baldir");
        WebElement email=driver.findElement(By.id("input-email"));
        email.sendKeys("ahmet34656@gmail.com");
        WebElement phone=driver.findElement(By.id("input-telephone"));
        phone.sendKeys("312123432");
        WebElement password=driver.findElement(By.id("input-password"));
        password.sendKeys("1234567");
        WebElement confirmPassword=driver.findElement(By.id("input-confirm"));
        confirmPassword.sendKeys("1234567");
        WebElement subscription=driver.findElement(By.name("newsletter"));
        subscription.click();
        WebElement box=driver.findElement(By.name("agree"));
        box.click();
        WebElement continueButton=driver.findElement(By.className("btn-primary"));
        continueButton.click();
        WebElement message=driver.findElement(By.id("content"));
        System.out.println(message.getText());

    }
}
