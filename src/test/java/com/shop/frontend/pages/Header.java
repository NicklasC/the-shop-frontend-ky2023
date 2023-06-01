package com.shop.frontend.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Header {
    WebDriver driver;

    // Author: Camilla
    By link_home = By.xpath("/html/body/header/div/div/ul/li[1]/a");
    // Author: Camilla
    By link_shop = By.xpath("/html/body/header/div/div/ul/li[2]/a");

    // Author: Camilla
    By webElement_headerLogo = By.xpath("/html/body/header/div/div/a/h1");

    // Author: Camilla
    By button_checkout = By.className("btn-warning");

    // Author: Nicklas
    By txt_checkoutButtonText = By.className("rounded-pill");


    // Author: Camilla
    public Header(WebDriver driver) {
        this.driver = driver;
    }

    // Author: Camilla
    public WebElement clickHomeLink() {
        WebElement homeLink = driver.findElement(link_home);
        homeLink.click();
        return homeLink;
    }

    // Author: Camilla
    public WebElement clickShopLink() {
        WebElement shopLink = driver.findElement(link_shop);
        shopLink.click();
        return shopLink;
    }

    // Author: Camilla
    public String getCurrentURL() {
        return driver.getCurrentUrl();
    }

    // Author: Camilla
    public boolean verifyLogoIsDisplayed() {
        WebElement headerLogo = driver.findElement(webElement_headerLogo);
        return headerLogo.isDisplayed();
    }

    // Author: Camilla
    public WebElement clickCheckoutButton() {
        WebElement checkoutButton = driver.findElement(button_checkout);
        checkoutButton.click();
        return checkoutButton;
    }

    // Author: Nicklas
    public String getCheckoutButtonText () {
        return driver.findElement(txt_checkoutButtonText).getText();
    }

    // Author: Nicklas
    public boolean checkoutButtonTextIsZeroOrNull() {
        if (driver.findElement(txt_checkoutButtonText).getText().equals("") || driver.findElement(txt_checkoutButtonText).getText().equals("0")) {
            return true;
        } else {
            return false;
        }
    }
}