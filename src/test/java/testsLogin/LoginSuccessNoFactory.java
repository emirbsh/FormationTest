//1er version sans factory

package testsLogin;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.NoSuchElementException;

import java.time.Duration;

public class LoginSuccessNoFactory {

    @Test
    public void testLoginSuccess() {
        // Ouvrir le navigateur
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\emir2\\Desktop\\DEV\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        try {
            // Se rendre sur la page de connexion
            driver.get("https://www.saucedemo.com");

            // Renseigner les identifiants de connexion
            WebElement usernameInput = driver.findElement(By.xpath("//input[@id='user-name']"));
            usernameInput.sendKeys("standard_user");
            WebElement passwordInput = driver.findElement(By.xpath("//input[@id='password']"));
            passwordInput.sendKeys("secret_sauce");

            // Cliquer sur le bouton de connexion
            WebElement loginButton = driver.findElement(By.xpath("//input[@data-test='login-button']"));
            loginButton.click();

            // Attendre la visibilité de l'élément contenant le texte "Products"
            WebElement productsTitle = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='title' and text()='Products']")));

            // Vérifier que l'élément est affiché
            Assert.assertTrue(productsTitle.isDisplayed());



            // XPath relatif pour le lien "Sauce Labs Bike Light"
            String xpath = "//div[@class='inventory_item_description']//div[@class='inventory_item_label']//a[@id='item_0_title_link']";

// Utilisation de Selenium pour cliquer sur le lien
            WebElement linkElement = driver.findElement(By.xpath(xpath));
            linkElement.click();


            // Récupérer le prix
            WebElement priceElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='inventory_details_price']")));
            String price = priceElement.getText();

            // Récupérer la description
            WebElement descriptionElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='inventory_details_desc large_size']")));
            String description = descriptionElement.getText();

            // Afficher le prix et la description
            System.out.println("Prix : " + price);
            System.out.println("Description : " + description);

            // Sélectionner et cliquer sur le bouton "Add to cart"
            WebElement addToCartButton = driver.findElement(By.xpath("//button[@id='add-to-cart-sauce-labs-bike-light']"));
            addToCartButton.click();

// Sélectionner et cliquer sur l'icône du panier
            WebElement cartIcon = driver.findElement(By.xpath("//div[@id='shopping_cart_container']//a[@class='shopping_cart_link']"));
            cartIcon.click();

            // Attendre la visibilité de l'élément contenant le texte "Your Cart"
            WebElement yourCartTitle = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(@class,'title') and contains(text(),'Your Cart')]")));

// Vérifier que l'élément est affiché
            Assert.assertTrue(yourCartTitle.isDisplayed());

// Attendre la visibilité de l'élément correspondant au produit ajouté au panier
            WebElement addedProduct = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='cart_item']//div[@class='inventory_item_name' and text()='Sauce Labs Bike Light']")));

// Vérifier que l'élément est affiché
            Assert.assertTrue(addedProduct.isDisplayed());

// Localiser le bouton "Remove" avec XPath relatif
            WebElement removeButton = driver.findElement(By.xpath("//button[@data-test='remove-sauce-labs-bike-light']"));

// Utiliser JavascriptExecutor pour cliquer sur le bouton en utilisant JavaScript
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", removeButton);


            try {
                // Attendez que l'élément "removed_cart_item" soit présent
                WebElement removedCartItem = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='removed_cart_item']")));

                // Affichez le message si l'élément est présent
                System.out.println("Produit absent du panier");
            } catch (NoSuchElementException e) {
                // Aucune exception, l'élément n'est pas présent
                System.out.println("Produit présent dans le panier");
            }




        } finally {
            // Fermer le navigateur
            // driver.quit();
        }
    }
}