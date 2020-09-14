package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {
    public WebDriver driver;

    private By signin = By.cssSelector("a[href*='sign_in']");
    private By title = By.cssSelector(".text-center > h2");
    private By navBar = By.cssSelector(".nav.navbar-nav.navbar-right");
    private By header = By.cssSelector("div[class*='video-banner']");

    public LandingPage(WebDriver driver) {
        this.driver = driver;
    }

    public LoginPage getLogin() throws InterruptedException {
        Thread.sleep(2);
        driver.findElement(signin).click();
        LoginPage lp = new LoginPage(driver);
        return lp;
    }

    public WebElement getTitle() {
        return driver.findElement(title);
    }

    public WebElement getNavigationBar() {
        return driver.findElement(navBar);
    }

    public WebElement getHeader() {
        return driver.findElement(header);
    }

}
