package MentoringWithAhmet.com.test.openchart.tests;

import MentoringWithAhmet.com.test.openchart.TestBaseOpenChart;
import MentoringWithAhmet.com.test.openchart.pages.LoginPage;
import org.testng.annotations.Test;
import utils.ConfigReader;

public class LoginTest extends TestBaseOpenChart {

    @Test
    public void validationOfLoginFunctionality(){
        LoginPage loginPage=new LoginPage(driver);
        loginPage.loginOpenChart(ConfigReader.readProperty("openchartusername"),
                ConfigReader.readProperty("openchartpassword"));
    }
}
