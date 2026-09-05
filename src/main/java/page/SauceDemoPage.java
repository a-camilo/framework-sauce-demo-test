package page;

import baseTest.BasePage;
import io.cucumber.datatable.DataTable;
import net.datafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ByIdOrName;
import org.openqa.selenium.support.pagefactory.ByAll;
import utils.SauceDemoExceptions;

import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class SauceDemoPage extends BasePage {

    Faker faker = new Faker();
    private WebElement webElement;

    private By fillInUserName = By.id("user-name");
    private By fillInPassword = By.id("password");
    private By btnLogin = By.id("login-button");
    private By msgError = By.xpath("//h3[@data-test='error']");
    private By btnBackToProduct = By.xpath("//*[contains(text(),'Back to products')]");
    private By btnContinueShopping = By.xpath("//button[contains(@id,'continue-shopping')]");
    private By btnAddCart = By.xpath("//button[contains(text(),'Add to cart')]");
    private By shopCart = By.xpath("//a[contains(@data-test,'shopping-cart-link')]");
    private By btnCheckout = By.xpath("//button[contains(@data-test,'checkout')]");
    private By fillInFirstName = ByIdOrName.id("first-name");
    private By fillInLastName = ByIdOrName.id("last-name");
    private By fillInPostalCode = ByIdOrName.id("postal-code");
    private By btnContinue = By.xpath("//input[contains(@data-test,'continue')]");
    private By btnFinish = By.xpath("//*[contains(@data-test,'finish')]");


    public static SauceDemoPage action() {
        return new SauceDemoPage();
    }

    public SauceDemoPage urlPage(String urlPage) {
        try {
            while (urlPage.isEmpty() || urlPage.endsWith("https://")) {
                Thread.sleep(2000);
            }
            url(urlPage);
        } catch (Exception e) {
            new SauceDemoExceptions("A url está vazia ou incompleta!");
        }
        return this;
    }

    public SauceDemoPage username(String username) {
        escrever(fillInUserName, username);
        return this;
    }

    public SauceDemoPage password(String password) {
        escrever(fillInPassword, password);
        return this;
    }

    public SauceDemoPage loginButton() {
        clicar(btnLogin);
        return this;
    }

    public SauceDemoPage produto(DataTable produto) {
        List<Map<String, String>> produtoMap = produto.asMaps();

        int contador_carrinho = 0;

        for (Map<String, String> p : produtoMap) {

            String dado = p.get("produto");
            By produtos = By.xpath("//*[contains(text(),'" + dado + "')]");

            switch (dado) {
                case "Sauce Labs Backpack",
                     "Sauce Labs Bike Light",
                     "Sauce Labs Bolt T-Shirt",
                     "Sauce Labs Fleece Jacket",
                     "Sauce Labs Onesie",
                     "Test.allTheThings() T-Shirt (Red)":
                    clicar(produtos);
                    assertTrue(dado, true);
                    addCartButton();
            }
            clicar(btnBackToProduct);
            for (int i = 1; i <= 1; i++) {
                contador_carrinho += i;
            }
        }
        webElement = driver.findElement(By.xpath("//a[@class='shopping_cart_link']/span[contains(text(),'" + contador_carrinho + "')]"));
        assertEquals("6", webElement.getText());
        return this;
    }

    public SauceDemoPage assertTitle(String string) {
        assertEquals(string, driver.getTitle());
        return this;
    }

    public SauceDemoPage assertError() {
        webElement = driver.findElement(msgError);

        switch (webElement.getText()) {
            case "Epic sadface: Sorry, this user has been locked out." -> {
                assertTrue(webElement.getText(), true);
            }
            case "Epic sadface: Username and password do not match any user in this service" -> {
                assertTrue(webElement.getText(), true);
            }
        }
        return this;
    }

    public SauceDemoPage loginEPassword(String login, String password) {
        By credenciais = new ByAll(fillInUserName, fillInPassword);
        List<WebElement> credencial_input = driver.findElements(credenciais);
        credencial_input.get(0).sendKeys(login);
        credencial_input.get(1).sendKeys(password);
        return this;
    }

    public SauceDemoPage addCartButton() {
        clicar(btnAddCart);
        return this;
    }

    public SauceDemoPage shoppingCart() {
        clicar(shopCart);
        clicar(btnCheckout);
        return this;
    }

    public SauceDemoPage checkoutInfo() {

        By checkOutInfo = new ByAll(fillInFirstName, fillInLastName, fillInPostalCode, btnContinue);
        List<WebElement> list = driver.findElements(checkOutInfo);
        list.get(0).sendKeys(faker.name().firstName());
        list.get(1).sendKeys(faker.name().lastName());
        list.get(2).sendKeys(faker.address().postcode());
        list.get(3).click();
        return this;
    }

    public SauceDemoPage summaryInfo() {
        String message = "Thank you for your order!";
        clicar(btnFinish);
        webElement = driver.findElement(By.xpath("//h2[contains(text(),'" + message + "')]"));
        assertTrue(webElement.getText(), true);
        return this;
    }
}
