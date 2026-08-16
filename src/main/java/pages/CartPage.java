package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.List;

public class CartPage {

    WebDriver driver;

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    // Locators
    By cartItems = By.className("cart_item");
    By itemNames = By.className("inventory_item_name");
    By removeButtons = By.cssSelector("button[id^='remove-']");
    By checkoutButton = By.id("checkout");
    By itemTotal = By.className("summary_subtotal");

    // Methods

    public int getCartItemsCount() {
        List<?> items = driver.findElements(cartItems);
        return items.size();
    }

    public List<String> getCartItemNames() {
        List<String> names = new java.util.ArrayList<>();

        List<?> items = driver.findElements(itemNames);

        for (Object item : items) {
            names.add(((org.openqa.selenium.WebElement) item).getText());
        }

        return names;
    }

    public void removeProduct(String productName) {
        By removeButton = By.id(
                "remove-" + productName.toLowerCase().replace(" ", "-")
        );

        driver.findElement(removeButton).click();
    }

    public void clickCheckout() {
        driver.findElement(checkoutButton).click();
    }

    public String getItemTotal() {
        return driver.findElement(itemTotal).getText();
    }
}