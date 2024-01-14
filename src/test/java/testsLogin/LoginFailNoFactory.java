package testsLogin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginFailNoFactory {

    @Test
    public void testLoginFail() {
        // Ouvrir le navigateur
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\emir2\\Desktop\\DEV\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        // Se rendre sur la page de connexion
        driver.get("https://www.saucedemo.com");

        // Renseigner les identifiants de connexion
        WebElement usernameInput = driver.findElement(By.xpath("//input[@id='user-name']"));
        usernameInput.sendKeys("John");

        WebElement passwordInput = driver.findElement(By.xpath("//input[@id='password']"));
        passwordInput.sendKeys("invalid_password");

        // Cliquer sur le bouton de connexion
        WebElement loginButton = driver.findElement(By.xpath("//input[@data-test='login-button']"));
        loginButton.click();


        // Vérifier que l'erreur de connexion est affichée
        // Sélectionner l'élément du message d'erreur
        WebElement errorMessage = driver.findElement(By.xpath("//h3[@data-test='error']"));

// Récupérer le texte du message d'erreur
        String actualErrorText = errorMessage.getText();

// Texte d'erreur attendu
        String expectedErrorText = "Epic sadface: Username and password do not match any user in this service";

// Vérifier que le texte du message d'erreur correspond au texte attendu
        Assert.assertEquals(actualErrorText, expectedErrorText, "Erreur de connexion non affichée");


        // Fermer le navigateur
        driver.quit();
    }
}