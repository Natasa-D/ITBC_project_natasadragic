package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class RegistrationTest extends BaseTest {

    @Test
    public void verifyAlertIsDisplayedIfCaptchaMissed() {
        try {
            getLoginPage().open().clickNewUserButton();
            getRegistrationPage()
                    .enterFirstName("Test")
                    .enterLastName("Testov")
                    .enterUserName("Test1")
                    .enterPassword("Test123!")
                    .clickRegister();
            Assert.assertTrue(getDriver().getPageSource().contains("Please verify reCaptcha to register!"));
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail("An exception occurred: " + e.getMessage());
        }
    }
}