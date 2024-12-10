import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.asserts.SoftAssert;

import javax.lang.model.element.Element;

import static org.testng.Assert.*;


public class LoginTests {
    WebDriver driver;
    String  ErrorMessage;

    @BeforeMethod
    public void setup() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        driver = new ChromeDriver(options);

    }

    //Позитивный тест логина
    @Test
    public void positiveLogin() {
        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
        driver.findElement(By.id("react-burger-menu-btn")).click();
        WebElement ElementLogout = driver.findElement(By.id("logout_sidebar_link"));
        assertNotNull(ElementLogout, "Нет элемента логаут");
    }

    //Негативный тест логина с пустыми значениями
    @Test
    public void emptyData() {
        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.id("login-button")).click();
        ErrorMessage = driver.findElement(By.xpath("//*[@id=\"login_button_container\"]/div/form/div[3]/h3")).getText();
        assertEquals(ErrorMessage, "Epic sadface: Username is required");
    }

    //Негативный тест логина с некорректным  паролем
    @Test
    public void invalidPassword() {
        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("");
        driver.findElement(By.id("login-button")).click();
        ErrorMessage = driver.findElement(By.xpath("//*[@id=\"login_button_container\"]/div/form/div[3]/h3")).getText();
        assertEquals(ErrorMessage, "Epic sadface: Password is required");
    }

    //Негативный тест логина с некорректным  username
    @Test
    public void invalidUsername() {
        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.id("user-name")).sendKeys("");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
        ErrorMessage = driver.findElement(By.xpath("//*[@id=\"login_button_container\"]/div/form/div[3]/h3")).getText();
        assertEquals(ErrorMessage, "Epic sadface: Username is required");
    }

    @Test
    public void notExistUser() {
        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.id("user-name")).sendKeys("test");
        driver.findElement(By.id("password")).sendKeys("test");
        driver.findElement(By.id("login-button")).click();
        ErrorMessage = driver.findElement(By.xpath("//*[@id=\"login_button_container\"]/div/form/div[3]/h3")).getText();
        assertEquals(ErrorMessage, "Epic sadface: Username and password do not match any user in this service");
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        driver.quit();
    }
}

