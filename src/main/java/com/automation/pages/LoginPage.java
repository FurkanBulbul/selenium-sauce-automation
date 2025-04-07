package com.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * LoginPage sınıfı, giriş sayfasındaki tüm elementleri ve işlemleri içerir.
 * Kullanıcı adı, şifre girişi ve giriş butonu gibi öğeleri yönetir.
 */
public class LoginPage extends BasePage {

    @FindBy(id = "user-name") // Kullanıcı adı alanı
    private WebElement usernameField;

    @FindBy(id = "password") // Şifre alanı
    private WebElement passwordField;

    @FindBy(id = "login-button") // Giriş butonu
    private WebElement loginButton;

    @FindBy(css = "[data-test='error']")
    private WebElement errorMessage;

    public LoginPage(WebDriver driver) {
        super(driver); // BasePage constructor'ını çağırır
    }

    // Kullanıcı adı ve şifreyi girer
    public LoginPage enterCredentials(String username, String password) {
        usernameField.sendKeys(username);
        passwordField.sendKeys(password);
        return this;  // Method chaining için aynı sayfayı döndürür
    }

    // Giriş butonuna tıklar ve HomePage'i döndürür
    public HomePage clickLoginButton() {
        loginButton.click();
        return new HomePage(driver);  // HomePage'e yönlendirir
    }

    // Hata mesajının görüntülenip görüntülenmediğini kontrol eder
    public boolean isErrorMessageDisplayed() {
        return errorMessage.isDisplayed();
    }
}
