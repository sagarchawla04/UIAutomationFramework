package Academy;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.LandingPage;

import java.io.IOException;

public class validateNavigationBar extends  base{
    public WebDriver driver;
    public static Logger log = LogManager.getLogger(base.class.getName());

    @BeforeTest
    public void initialize() throws IOException {
        driver=initializeDriver();
        driver.get(prop.getProperty("url"));
    }

    @Test
    public void validateNavigationBar() {
        LandingPage landingPage = new LandingPage(driver);
        Assert.assertTrue(landingPage.getNavigationBar().isDisplayed());
        log.info("Navigation bar is coming as expected");

    }

    @AfterTest
    public void tearDown(){
        driver.close();
    }
}
