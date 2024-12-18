package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage {

    WebDriver driver;
    By cartItem = By.cssSelector("#shopping_cart_container");
    public By tittleProduct = By.cssSelector(".inventory_item_name");
    By bottomRemoveInCart = By.cssSelector("#remove-sauce-labs-backpack");

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getTitleInCart() {
        return driver.findElements(tittleProduct).get(0).getText();
    }

    public String getFirstTitleInCart() {
        return driver.findElements(tittleProduct).get(0).getText();
    }

    public String getSecondTitleInCart() {
        return driver.findElements(tittleProduct).get(1).getText();
    }

    public boolean checkItemFirst() {
        return driver.findElements(tittleProduct).isEmpty();
    }

    public void removeProductionCart() {
        driver.findElement(bottomRemoveInCart).click();
    }


}
