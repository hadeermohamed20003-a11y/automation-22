package tests;

import base.BaseTest;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.DataDriven;

public class InventoryTest extends BaseTest {

    @Test
    public void verifyInventoryPage() {

        JSONObject data = DataDriven.jsonReader();

        String username = data.getJSONObject("validUser").getString("username");
        String password = data.getJSONObject("validUser").getString("password");

        loginPage.login(username, password);

        // Verify page title
        Assert.assertEquals(inventoryPage.getPageTitle(), "Products");

        // Verify cart icon
        Assert.assertTrue(inventoryPage.isCartDisplayed());

        // Verify products count
        Assert.assertEquals(inventoryPage.getProductsCount(), 6);
    }
}