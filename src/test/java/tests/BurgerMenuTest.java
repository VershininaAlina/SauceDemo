package tests;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class BurgerMenuTest extends BaseTest {

    @Test
    public void checkItemBurgerMenu() {
        SoftAssert softAssert = new SoftAssert();
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        burgerMenuPage.openBurgerMenu();
        softAssert.assertEquals(burgerMenuPage.checkElementsAll(),
                true,
                "Отсутсвует один из элементов ");
        softAssert.assertAll();

    }
}
