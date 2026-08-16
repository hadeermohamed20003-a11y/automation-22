package tests;

import base.BaseTest;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.DataDriven;

public class LoginTest extends BaseTest {

    @Test
    public void validLoginTest() {

        JSONObject testData = DataDriven.jsonReader();

        JSONObject validUser = testData.getJSONObject("validUser");

        String username = validUser.getString("username");
        String password = validUser.getString("password");

        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
        loginPage.clickLogin();

        Assert.assertEquals(
                inventoryPage.getPageTitle(),
                "Products"
        );
    }

    @Test
    public void invalidLoginTest() {

        JSONObject testData = DataDriven.jsonReader();

        JSONObject invalidUser = testData.getJSONObject("invalidUser");

        String username = invalidUser.getString("username");
        String password = invalidUser.getString("password");

        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
        loginPage.clickLogin();

        Assert.assertTrue(
                loginPage.getErrorMessage().contains("Username and password do not match")
        );
    }

    @Test
    public void emptyPasswordTest() {

        JSONObject testData = DataDriven.jsonReader();

        JSONObject emptyPassword = testData.getJSONObject("emptyPassword");

        String username = emptyPassword.getString("username");
        String password = emptyPassword.getString("password");

        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
        loginPage.clickLogin();

        Assert.assertTrue(
                loginPage.getErrorMessage().contains("Password is required")
        );
    }
}