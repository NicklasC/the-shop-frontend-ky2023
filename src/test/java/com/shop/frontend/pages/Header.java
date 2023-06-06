package com.shop.frontend.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Header {
    WebDriver driver;

    // Author: Camilla
    By link_home = By.xpath("/html/body/header/div/div/ul/li[1]/a");
    By link_shop = By.xpath("/html/body/header/div/div/ul/li[2]/a");
    By webElement_headerLogo = By.xpath("/html/body/header/div/div/a/h1");
    By button_checkout = By.className("btn-warning");

    // Author: Nicklas
    By txt_checkoutBadgeText = By.className("rounded-pill");
    By btn_checkoutButton = By.cssSelector("a[type='button']");


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
    public String getCheckoutBadgeText() {
        return driver.findElement(txt_checkoutBadgeText).getText();
    }

    // Author: Nicklas
    public void clickOnCheckoutButton() {
        WebElement checkoutButton = driver.findElement(btn_checkoutButton);
        checkoutButton.click();
    }

    // Author: Nicklas
    public boolean checkoutButtonTextIsZeroOrNull() {
        if (driver.findElement(txt_checkoutBadgeText).getText().equals("") || driver.findElement(txt_checkoutBadgeText).getText().equals("0")) {
            return true;
        } else {
            return false;
        }
    }
}