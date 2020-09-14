package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
    public WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    private By email = By.id("user_email");
    private By password = By.id("user_password");
    private By loginButton = By.cssSelector("input[value='Log In']");
    private By forgotPassword = By.cssSelector("a[href*='password']");

    public WebElement getEmail() {
        return driver.findElement(email);
    }

    public WebElement getPassword() {
        return driver.findElement(password);
    }

    public WebElement getLogin() {
        return driver.findElement(loginButton);
    }

    public ForgotPassword clickForgotPassword() {
        driver.findElement(forgotPassword).click();
        return new ForgotPassword(driver);
    }


}
