package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BurgerMenuPage {
    WebDriver driver;

    By BurgerMenu = By.id("react-burger-menu-btn");
    public By ButtonLogoutinBurgerMenu = By.id("logout_sidebar_link");

    public BurgerMenuPage(WebDriver driver) {
        this.driver = driver;
    }

    public void openBurgerMenu() {
        driver.findElement(BurgerMenu).click();
    }

    public boolean checkElementLogout() {
        return ButtonLogoutinBurgerMenu != null;
    }


}
