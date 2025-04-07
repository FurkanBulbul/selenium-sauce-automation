package com.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Shopping cart container öğesi
    @FindBy(id = "shopping_cart_container")
    private WebElement shoppingCartContainer;

    // Sepet görünür mü kontrolü
    public boolean isShoppingCartVisible() {
        return shoppingCartContainer.isDisplayed();
    }
}
