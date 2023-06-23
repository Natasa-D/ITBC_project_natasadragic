package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import pages.*;

import java.time.Duration;

public class BaseTest {
    private WebDriver driver;
    private WebDriverWait wait;
    private LoginPage loginPage;
    private AlertsPage alertsPage;
    private RegistrationPage registrationPage;

    public WebDriver getDriver(){
        return this.driver;
    }
    public WebDriverWait getWait(){
        return this.wait;
    }
    public LoginPage getLoginPage (){ return this.loginPage;}
    public AlertsPage getAlertsPage() {
        return this.alertsPage;
    }
    public RegistrationPage getRegistrationPage(){
        return this.registrationPage;
        }
         

    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C://Users//Natasa//Desktop//chromedriver.exe");
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();
        loginPage = new LoginPage(driver, wait);
        alertsPage = new AlertsPage(driver, wait);
        registrationPage = new RegistrationPage(driver, wait);
    }

        @AfterClass
    public void close(){
      getDriver().quit();
    }


}
