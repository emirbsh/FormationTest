package testsLogin;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageFactory.LoginFailFactory;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

public class LoginFailTest {

    private WebDriver driver;
    private LoginFailFactory loginFactory;

    @BeforeMethod
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\emir2\\Desktop\\DEV\\chromedriver.exe");
        driver = new ChromeDriver();
        loginFactory = PageFactory.initElements(driver, LoginFailFactory.class);
    }

    @Test
    public void testLoginFail() {
        // Se rendre sur la page de connexion
        driver.get("https://www.saucedemo.com");

        // Renseigner les identifiants de connexion
        loginFactory.usernameInput.sendKeys("John");
        loginFactory.passwordInput.sendKeys("invalid_password");

        // Cliquer sur le bouton de connexion
        loginFactory.loginButton.click();

        // Vérifier que l'erreur de connexion est affichée
        // Récupérer le texte du message d'erreur
        String actualErrorText = loginFactory.errorMessage.getText();

        // Texte d'erreur attendu
        String expectedErrorText = "Epic sadface: Username and password do not match any user in this service";

        // Vérifier que le texte du message d'erreur correspond au texte attendu
        Assert.assertEquals(actualErrorText, expectedErrorText, "Erreur de connexion non affichée");
    }

    @AfterMethod
    public void tearDown(ITestResult result) {
        // Prendre une capture d'écran si le test a échoué
        if (result.getStatus() == ITestResult.FAILURE) {
            captureScreenshot(result.getName());
        }

        // Fermer le navigateur
        driver.quit();
    }

    private void captureScreenshot(String testName) {
        try {
            TakesScreenshot screenshot = (TakesScreenshot) driver;
            File sourceFile = screenshot.getScreenshotAs(OutputType.FILE);
            File destinationFile = new File("screenshots/" + testName + ".png");
            Files.copy(sourceFile.toPath(), destinationFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
            System.out.println("Screenshot captured: " + destinationFile.getAbsolutePath());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
