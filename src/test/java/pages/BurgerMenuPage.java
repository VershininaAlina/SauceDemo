package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BurgerMenuPage {
    WebDriver driver;

    By BurgerMenu = By.xpath("(//div/button)[1]");

    public By ButtonAllItemsBurgerMenu = By.cssSelector("#inventory_sidebar_link");
    public By ButtonAboutBurgerMenu = By.cssSelector("#about_sidebar_link");
    public By ButtonLogoutBurgerMenu = By.cssSelector("#logout_sidebar_link");
    public By ButtonResetBurgerMenu = By.cssSelector("#reset_sidebar_link");

    public BurgerMenuPage(WebDriver driver) {
        this.driver = driver;
    }

    public void openBurgerMenu() {
        driver.findElement(BurgerMenu).click();
    }

    public boolean checkElementLogout() {
        return ButtonLogoutBurgerMenu != null;
    }

    public boolean checkElementsAll() {
        return (ButtonLogoutBurgerMenu != null) & (ButtonResetBurgerMenu != null) &&
                (ButtonAllItemsBurgerMenu != null) && (ButtonAboutBurgerMenu != null);


    }


}
