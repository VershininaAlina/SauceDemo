package tests;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BurgerMenuPage;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;


public class LoginTest extends BaseTest {

    String ErrorMessage;

    //Позитивный тест логина
    @Test
    public void positiveLogin() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        burgerMenuPage.openBurgerMenu();
        Assert.assertTrue(
                burgerMenuPage.checkElementLogout(),
                "Нет элемента логаут");
    }

    //Негативный тест логина с пустыми значениями
    @Test
    public void emptyData() {
        loginPage.open();
        loginPage.login("", "");
        assertEquals(
                loginPage.getErrorMessage(),
                "Epic sadface: Username is required",
                "Сообщение отсутсвует");
    }

    //Негативный тест логина с некорректным  паролем
    @Test
    public void invalidPassword() {
        loginPage.open();
        loginPage.login("standard_user", "");
        assertEquals(
                loginPage.getErrorMessage(),
                "Epic sadface: Password is required",
                "Сообщение отсутсвует");
    }

    //Негативный тест логина с некорректным  username
    @Test
    public void invalidUsername() {
        loginPage.open();
        loginPage.login("", "secret_sauce");
        assertEquals(
                loginPage.getErrorMessage(),
                "Epic sadface: Username is required",
                "Сообщение отсутсвует");
    }
    //Негативный тест с несуществующими данными
    @Test
    public void notExistUser() {
        loginPage.open();
        loginPage.login("test", "test");
        assertEquals(
                loginPage.getErrorMessage(),
                "Epic sadface: Username and password do not match any user in this service",
                "Сообщение отсутсвует");
    }
}

