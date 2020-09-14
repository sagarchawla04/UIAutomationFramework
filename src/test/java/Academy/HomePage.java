package Academy;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import pageObjects.ForgotPassword;
import pageObjects.LandingPage;
import pageObjects.LoginPage;

import java.io.IOException;

public class HomePage extends base {
    public WebDriver driver;
    public static Logger log = LogManager.getLogger(base.class.getName());

    @BeforeMethod
    public void initialize() throws IOException {
        driver=initializeDriver();
        driver.get(prop.getProperty("url"));
    }

    @Test(dataProvider="getLoginData")
    public void basePageNavigation(String username, String password) throws IOException, InterruptedException {
        LandingPage landingPage = new LandingPage(driver);
        LoginPage loginPage  = landingPage.getLogin();
        loginPage.getEmail().sendKeys(username);
        log.info("Email entered in username");
        loginPage.getPassword().sendKeys(password);
        log.info("Password entered in password input field");
        loginPage.getLogin().click();
        log.info("Login button clicked");
        ForgotPassword fp = loginPage.clickForgotPassword();
        fp.getEmail().sendKeys("Abcd");
        fp.submit().click();
    }

    @AfterMethod
    public void tearDown(){
        driver.close();
    }

    @DataProvider
    public Object[] getLoginData(){
        Object[][] data = new Object[2][2];
        //first data
        data[0][0]="testusername1";
        data[0][1]="password";
        // second data
        data[1][0]="testusername2";
        data[1][1]="password";

        return data;
    }
}
