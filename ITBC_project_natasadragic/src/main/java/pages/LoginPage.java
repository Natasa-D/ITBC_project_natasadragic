package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BasePage {

    private By userNameField = By.id("userName");
    private By passwordField = By.id("password");
    private By loginBtn = By.id("login");
    private By newUserBtn = By.id("newUser");


    public LoginPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public LoginPage open() {
        getDriver().get("https://demoqa.com/login");
        return this;
    }

    public LoginPage enterUsername(String username) {
        getDriver().findElement(userNameField).sendKeys(username);
        return this;
    }

    public LoginPage enterPassword(String password) {
        getDriver().findElement(passwordField).sendKeys(password);
        return this;
    }

    public LoginPage clickLoginButton() {
        try {
            JavascriptExecutor js = (JavascriptExecutor) getDriver();
            js.executeScript("window.scrollBy(0, 200)");
            getDriver().findElement(loginBtn).click();
            getWait().until(ExpectedConditions.urlContains("profile"));
        } catch (TimeoutException e) {
            System.out.println("Timeout while waiting for the profile page.");
        } catch (Exception e) {
            System.out.println("An error occurred.");
        }
        return this;
    }

    public LoginPage clickNewUserButton() {
        try {
            JavascriptExecutor js = (JavascriptExecutor) getDriver();
            js.executeScript("window.scrollBy(0, 200)");
            getDriver().findElement(newUserBtn).click();
            getWait().until(ExpectedConditions.urlContains("register"));
        } catch (TimeoutException e) {
            System.out.println("Timeout while waiting for the profile page.");
        } catch (Exception e) {
            System.out.println("An error occurred.");
        }
        return this;
    }
}