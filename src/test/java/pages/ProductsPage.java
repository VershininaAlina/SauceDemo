package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductsPage {
    WebDriver driver;

    String buttonAddAndRemove = "//div[text() = '%s']//ancestor::div[@class = 'inventory_item']//button";
    public By tittleFirst = By.xpath("(//div[@class = 'inventory_item_name '])[1]");
    public By tittleSecond = By.xpath("(//div[@class = 'inventory_item_name '])[2]");

    By cartItem = By.cssSelector(".shopping_cart_link");

    public ProductsPage(WebDriver driver) {
        this.driver = driver;
    }

    public void addProduct(String product) {
        driver.findElement(By.xpath(String.format(String.valueOf(buttonAddAndRemove), product))).click();

    }

    public void removeProductInCatalog(String product) {
        driver.findElement(By.xpath(String.format(buttonAddAndRemove, product))).click();
    }

    public void openCart() {
        driver.findElement(cartItem).click();
    }

    public String getTittleProductInCatalog(By tittle) {
        driver.get("https://www.saucedemo.com/inventory.html");
        return driver.findElement(tittle).getText();


    }

}
