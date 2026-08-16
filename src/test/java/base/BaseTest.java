package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.InventoryPage;
import pages.LoginPage;

public class BaseTest {

    protected WebDriver driver;

    protected LoginPage loginPage;
    protected InventoryPage inventoryPage;

    @BeforeMethod
    public void setUp() {

        // تجهيز ChromeDriver
        WebDriverManager.chromedriver().setup();

        // فتح متصفح Chrome
        driver = new ChromeDriver();

        // تكبير نافذة المتصفح
        driver.manage().window().maximize();

        // فتح موقع Swag Labs
        driver.get("https://www.saucedemo.com/");

        // إنشاء Page Objects
        loginPage = new LoginPage(driver);
        inventoryPage = new InventoryPage(driver);
    }

    @AfterMethod
    public void tearDown() {

        // إغلاق المتصفح بعد انتهاء كل Test
        if (driver != null) {
            driver.quit();
        }
    }
}