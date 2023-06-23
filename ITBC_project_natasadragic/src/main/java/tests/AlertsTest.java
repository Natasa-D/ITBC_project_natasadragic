package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class AlertsTest extends BaseTest{

    @Test
    public void verifyButtonsAreDisplayed(){
        getAlertsPage().open();
        Assert.assertTrue(getAlertsPage().areButtonsDisplayed(),"Buttons are not displayed.");
    }

    @Test
    public void verifyButtonsAreClickable() {
        getAlertsPage().open()
            .clickAlertBtn()
            .acceptAlertMessage()
            .clickTimeAlertBtn()
            .acceptAlertMessage()
            .clickConfirmBtn()
            .acceptAlertMessage()
            .clickPromptBtn()
            .acceptAlertMessage();
        Assert.assertFalse(getAlertsPage().isAlertPresent(), "Alert still present.");
    }
}




