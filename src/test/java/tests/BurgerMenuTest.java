package tests;

import io.qameta.allure.*;
import jdk.jfr.Description;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.ProductsPage;

import java.time.Duration;

public class BurgerMenuTest extends BaseTest {

    @Test (testName = "Проверка наличия элементов  бургер меню")
    @Description ("Проверка наличия элементов  бургер меню")
    @Severity(SeverityLevel.NORMAL)
    @Epic("SauceDemo - 1.0")
    @Feature("Burger Menu")
    @Story("Проверка наличия элементов  бургер меню")
    @TmsLink("www.Jira.com/web-124")

    public void checkItemBurgerMenu() {
        SoftAssert softAssert = new SoftAssert();
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        burgerMenuPage.openBurgerMenu();
        softAssert.assertEquals(burgerMenuPage.checkElementsAll(),
                true,
                "Отсутствует один из элементов ");
        softAssert.assertAll();
    }
    @Test (testName = "Проверка перехода по бургер меню")
    @Description ("Проверка перехода по бургер меню")
    @Severity(SeverityLevel.NORMAL)
    @Epic("SauceDemo - 1.0")
    @Feature("Burger Menu")
    @Story("Переходы по бургер меню")
    @TmsLink("www.Jira.com/web-123")
    @Flaky
    public void goToBurgerMenu(){
        SoftAssert softAssert = new SoftAssert();
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        burgerMenuPage.openBurgerMenu();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        burgerMenuPage.GoToElementBurgerMenu(burgerMenuPage.ButtonAllItemsBurgerMenu);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        burgerMenuPage.closeBurgerMenu();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
        softAssert.assertEquals(ProductsPage.getTittleInPage(burgerMenuPage.TittlePage),
                "Products",
                "Переход не произошел ");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        burgerMenuPage.GoToElementBurgerMenu(burgerMenuPage.ButtonLogoutBurgerMenu);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        softAssert.assertEquals(driver.findElements(loginPage.loginButton).isEmpty(),
                false,
                "Переход не произошел ");
        softAssert.assertAll();

    }
}
