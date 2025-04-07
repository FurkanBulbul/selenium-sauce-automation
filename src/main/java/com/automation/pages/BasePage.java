package com.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

/**
 * BasePage sınıfı, tüm page class'larının miras alacağı temel sınıftır.
 * WebDriver nesnesini taşır ve PageFactory ile elementlerin tanımlanmasını
 * sağlar.
 */
public class BasePage {
    protected WebDriver driver;

    /**
     * Constructor - WebDriver parametresi alır ve PageFactory ile elementleri
     * başlatır.
     * 
     * @param driver Selenium WebDriver nesnesi
     */
    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);  // PageFactory elementleri başlatır
    }

    /**
     * Ana sayfanın başarılı şekilde görüntülenip görüntülenmediğini kontrol eden
     * genel bir metod. Her page class'ı bu metodu override edebilir.
     */
    public boolean isBasePageDisplayed() {
        return driver.getTitle().contains("Ana Sayfa");  // Örneğin, sayfa başlığına göre kontrol yapılabilir
    }
}
