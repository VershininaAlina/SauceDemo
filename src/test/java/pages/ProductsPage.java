package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductsPage {
    WebDriver driver;

    By buttomAddFirst = By.id("add-to-cart-sauce-labs-backpack");
    By buttomAddSecond = By.id("add-to-cart-sauce-labs-bike-light");
    By buttomRemoveFirst= By.id("remove-sauce-labs-backpack");
    By cartItem = By.className("shopping_cart_link");




    public  ProductsPage(WebDriver driver){
        this.driver = driver;
    }

    public void addProductFirst(){
        driver.findElement(buttomAddFirst).click();

    }
    public void addProductSecond(){
        driver.findElement(buttomAddSecond).click();

    }
    public void removeProductFirstInCatalog(){
        driver.findElement(buttomRemoveFirst).click();
    }
    public void openCart(){
        driver.findElement(cartItem).click();
    }

}
