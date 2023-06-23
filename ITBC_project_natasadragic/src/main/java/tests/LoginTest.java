package tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test
    public void verifyUserCanLoginToBookStore() {
        try {
            getLoginPage()
                    .open()
                    .enterUsername("Test")
                    .enterPassword("Test123!")
                    .clickLoginButton();
            Assert.assertTrue(getDriver().getCurrentUrl().contains("profile"));
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail("An exception occurred: " + e.getMessage());
        }
    }

    @Test
    public void verifyUserCannotLoginToBookStoreWithoutPassword() {
        try {
            getLoginPage()
                    .open()
                    .enterUsername("Test")
                    .enterPassword("")
                    .clickLoginButton();
            Assert.assertTrue(getDriver().getPageSource().contains("Login in Book Store"));
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail("An exception occurred: " + e.getMessage());
        }
    }


    @DataProvider(name = "loginData")
    public Object[][] getLoginData() {
        return new Object[][]{
                {"Test", "...."},
                {"Test1", "aaaa"}
        };
    }

    @Test(dataProvider = "loginData")
    public void verifyUserCannotLoginToBookStoreWithInvalidPassword(String username, String pass){

        try {
            getLoginPage()
                    .open()
                    .enterUsername(username)
                    .enterPassword(pass)
                    .clickLoginButton();
            Assert.assertTrue(getDriver().getPageSource().contains("Invalid username or password!"));
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail("An exception occurred: " + e.getMessage());
        }
    }

}

