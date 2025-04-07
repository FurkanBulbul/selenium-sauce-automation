package com.automation.tests;

import com.automation.pages.LoginPage;
import com.automation.pages.HomePage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class LoginTest {

    private WebDriver driver;
    private LoginPage loginPage;
    private WebDriverWait wait;

    @BeforeClass
    public void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--disable-web-security");
        options.addArguments("--disable-site-isolation-trials");
        options.addArguments("--no-sandbox");

        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");

        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("user-name")));

        loginPage = new LoginPage(driver);
    }

    @Test
    public void testValidLogin() {
        HomePage homePage = loginPage.enterCredentials("standard_user", "secret_sauce")
                                     .clickLoginButton();
    
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("inventory_list")));
    
        Assert.assertTrue(homePage.isShoppingCartVisible(), "Ana sayfa görüntülenemedi!");
    }
    

    @Test
    public void testInvalidLogin() {
        loginPage.enterCredentials("invalid_user", "invalid_password")
                 .clickLoginButton();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[data-test='error']")));

        Assert.assertTrue(loginPage.isErrorMessageDisplayed(), "Hata mesajı görüntülenmedi!");
    }

    @Test
    public void testEmptyUsername() {
        loginPage.enterCredentials("", "some_password")
                 .clickLoginButton();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[data-test='error']")));

        Assert.assertTrue(loginPage.isErrorMessageDisplayed(), "Boş kullanıcı adı için hata mesajı görüntülenmedi!");
    }

    @Test
    public void testEmptyPassword() {
        loginPage.enterCredentials("standard_user", "")
                 .clickLoginButton();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[data-test='error']")));

        Assert.assertTrue(loginPage.isErrorMessageDisplayed(), "Boş şifre için hata mesajı görüntülenmedi!");
    }

    @Test
    public void testEmptyCredentials() {
        loginPage.enterCredentials("", "")
                 .clickLoginButton();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[data-test='error']")));

        Assert.assertTrue(loginPage.isErrorMessageDisplayed(), "Boş bilgiler için hata mesajı görüntülenmedi!");
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
