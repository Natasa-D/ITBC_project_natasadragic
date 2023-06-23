package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class AlertsPage extends BasePage {

    private By buttons = By.id("javascriptAlertsWrapper");
    private By alertBtn = By.id("alertButton");
    private By timeAlertBtn = By.id("timerAlertButton");
    private By confirmBtn = By.id("confirmButton");
    private By promptBtn = By.id("promtButton");

    public AlertsPage(WebDriver driver, WebDriverWait wait) {
        super(driver,wait);
    }
    public AlertsPage open() {
        getDriver().get("https://demoqa.com/alerts");
        return this;
    }
    public AlertsPage getButtons() {
        getDriver().findElement(buttons);
        return this;
    }
    public AlertsPage clickAlertBtn() {
      getDriver().findElement(alertBtn).click();
      getWait().until(ExpectedConditions.alertIsPresent());
       return this;
    }
    public AlertsPage clickTimeAlertBtn() {
        getDriver().findElement(timeAlertBtn).click();
        getWait().until(ExpectedConditions.alertIsPresent());
        return this;
    }
    public AlertsPage clickConfirmBtn() {
       getDriver().findElement(confirmBtn).click();
       getWait().until(ExpectedConditions.alertIsPresent());
       return this;
    }
    public AlertsPage clickPromptBtn() {
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("window.scrollBy(0, 200)");
        getWait().until(ExpectedConditions.elementToBeClickable(promptBtn));
        getDriver().findElement(promptBtn).click();
        getWait().until(ExpectedConditions.alertIsPresent());
        return this;
    }
    public AlertsPage acceptAlertMessage() {
        getDriver().switchTo().alert().accept();
        return this;
    }
    public boolean isAlertPresent() {
        try {
            getWait().until(ExpectedConditions.alertIsPresent());
            return true;
        } catch (TimeoutException e) {
            return false;
        }
    }

    public boolean areButtonsDisplayed() {
        WebElement buttonsElement = getDriver().findElement(buttons);
        return buttonsElement.isDisplayed();
    }
}