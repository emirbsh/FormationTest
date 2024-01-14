package testsLogin;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageFactory.LoginSuccessFactory;

import java.io.IOException;

// ...

public class LoginSuccessTest {
    private WebDriver driver;
    private LoginSuccessFactory productsPage;

    @BeforeMethod
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\emir2\\Desktop\\DEV\\chromedriver.exe");
        driver = new ChromeDriver();
        productsPage = new LoginSuccessFactory(driver);
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void testLoginSuccess() throws IOException {
        try {
            productsPage.navigateToLoginPage();
            productsPage.login("standard_user", "secret_sauce");

            // D'autres actions, par exemple, naviguer vers la page des produits, ajouter au panier, etc.

            // Capture d'écran en cas d'échec du test
            productsPage.captureScreenshot("testFailureScreenshot.png");
        } finally {
            // Fermer le navigateur
             driver.quit();
        }
    }
}
