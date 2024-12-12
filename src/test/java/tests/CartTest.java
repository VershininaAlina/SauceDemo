package tests;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static org.testng.Assert.*;

public class CartTest extends BaseTest {
    @Test
    //Проверка добавления одного товара в корзину
    public void addOneProduct() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.addProductFirst();
        productsPage.openCart();
        assertEquals(cartPage.getFirstTitleInCart(),
                "Sauce Labs Backpack",
                "Заголовок 1 не соответсвует ");
    }
    @Test
    //Проверка добавление несколько товаров   в корзину
    public void addSomeProduct() {
        SoftAssert softAssert = new SoftAssert();
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.addProductFirst();
        productsPage.addProductSecond();
        productsPage.openCart();
        softAssert.assertEquals(cartPage.getFirstTitleInCart(),
                "Sauce Labs Backpack",
                "Заголовок 1 не соответсвует ");
        softAssert.assertEquals(cartPage.getSecondtTitleInCart(),
                "Sauce Labs Bike Light",
                "Заголовок 2 не соответсвует ");
        softAssert.assertAll();
    }
    @Test
    //Проверка удаления товара из корзины
    public void removeProductInCart() {

        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.addProductFirst();
        productsPage.openCart();
        cartPage.removeProductFirstinCart();
        assertTrue(cartPage.checkItemFirst());


    }
    @Test
    //Проверка удаления товара из Категории
    public void removeProductInProducts() {
        SoftAssert softAssert = new SoftAssert();
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.addProductFirst();
        productsPage.removeProductFirstInCatalog();
        productsPage.openCart();
        //softAssert.assertEquals(cartPage.checkItemFirst(), true);
        softAssert.assertAll();

    }
}



