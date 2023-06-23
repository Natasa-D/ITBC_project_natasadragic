package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegistrationPage extends BasePage{

    private By firstName = By.id("firstname");
    private By lastName = By.id("lastname");
    private By userName = By.id("userName");
    private By password = By.id("password");
    private By registerButton = By.id("register");

    private By requiredCaptchaMessage = By.xpath("//p[contains(text(),'Please verify reCaptcha to register!')]");

    public RegistrationPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public RegistrationPage open(){
        getDriver().get("https://demoqa.com/register");
        return this;
    }

    public RegistrationPage enterFirstName(String name) {
        getDriver().findElement(firstName).sendKeys(name);
        return this;
    }

    public RegistrationPage enterLastName(String lastname) {
        getDriver().findElement(lastName).sendKeys(lastname);
        return this;
    }

    public RegistrationPage enterUserName(String username) {
        getDriver().findElement(userName).sendKeys(username);
        return this;
    }

    public RegistrationPage enterPassword(String pass) {
        getDriver().findElement(password).sendKeys(pass);
        return this;
    }

    public RegistrationPage clickRegister() {
        getWait().until(ExpectedConditions.elementToBeClickable(registerButton));
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("window.scrollBy(0, 300)");
        getDriver().findElement(registerButton).click();
        return this;
    }




}
