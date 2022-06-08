package MentoringWithAhmet.com.test.openchart.tests;

import MentoringWithAhmet.com.test.openchart.TestBaseOpenChart;
import MentoringWithAhmet.com.test.openchart.pages.LoginPage;
import MentoringWithAhmet.com.test.openchart.pages.MainPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.ConfigReader;

public class MainTest extends TestBaseOpenChart {

    @Test
    public void validateUrl() throws InterruptedException {
        LoginPage loginPage=new LoginPage(driver);
        loginPage.loginOpenChart(ConfigReader.readProperty("openchartusername"),
                ConfigReader.readProperty("openchartpassword"));
        MainPage mainPage=new MainPage(driver);
        mainPage.clickCloseButton();
        Assert.assertTrue(driver.getTitle().equals("Dashboard"));

    }
}
