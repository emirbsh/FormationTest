package pageFactory;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

// ...

public class LoginSuccessFactory {
    private final WebDriver driver;
    private final WebDriverWait wait;

    @FindBy(xpath = "//span[@class='title' and text()='Products']")
    private WebElement productsTitle;

    @FindBy(xpath = "//div[@class='inventory_item_description']//div[@class='inventory_item_label']//a[@id='item_0_title_link']")
    private WebElement bikeLightLink;

    @FindBy(xpath = "//div[@class='inventory_details_price']")
    private WebElement priceElement;

    @FindBy(xpath = "//div[@class='inventory_details_desc large_size']")
    private WebElement descriptionElement;

    @FindBy(xpath = "//button[@id='add-to-cart-sauce-labs-bike-light']")
    private WebElement addToCartButton;

    @FindBy(xpath = "//div[@id='shopping_cart_container']//a[@class='shopping_cart_link']")
    private WebElement cartIcon;

    @FindBy(xpath = "//span[contains(@class,'title') and contains(text(),'Your Cart')]")
    private WebElement yourCartTitle;

    @FindBy(xpath = "//div[@class='cart_item']//div[@class='inventory_item_name' and text()='Sauce Labs Bike Light']")
    private WebElement addedProduct;

    @FindBy(xpath = "//button[@data-test='remove-sauce-labs-bike-light']")
    private WebElement removeButton;

    @FindBy(xpath = "//div[@class='removed_cart_item']")
    private WebElement removedCartItem;

    public LoginSuccessFactory(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    public void navigateToLoginPage() {
        driver.get("https://www.saucedemo.com");
    }

    public void login(String username, String password) {
        // Implementation du login
    }

    public void navigateToProductPage() {
        // Implementation pour aller à la page des produits
    }

    public void captureScreenshot(String fileName) throws IOException {
        File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenshotFile, new File(fileName));
    }

    // ... Ajoutez d'autres méthodes selon les actions sur la page
}
