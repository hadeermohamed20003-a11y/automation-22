package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.List;

public class InventoryPage {

    WebDriver driver;

    public InventoryPage(WebDriver driver) {
        this.driver = driver;
    }

    // Locators
    By cartIcon = By.className("shopping_cart_link");
    By products = By.className("inventory_item");
    By pageTitle = By.className("title");

    // Methods
    public boolean isCartDisplayed() {
        return driver.findElement(cartIcon).isDisplayed();
    }

    public int getProductsCount() {
        List<?> productList = driver.findElements(products);
        return productList.size();
    }

    public String getPageTitle() {
        return driver.findElement(pageTitle).getText();
    }
}