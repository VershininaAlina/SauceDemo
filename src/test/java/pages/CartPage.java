package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage {

    WebDriver driver;
    By cartItem = By.className("shopping_cart_link");
    public By tittleProduct = By.className("inventory_item_name");
    By buttomRemoveFirst = By.id("remove-sauce-labs-backpack");

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }


    public String getFirstTitleInCart() {
        return driver.findElements(tittleProduct).get(0).getText();
    }

    public String getSecondtTitleInCart() {
        return driver.findElements(tittleProduct).get(1).getText();
    }

    public boolean checkItemFirst() {
        return driver.findElements(tittleProduct).isEmpty();
    }

    public void removeProductFirstinCart() {
        driver.findElement(buttomRemoveFirst).click();
    }


}
