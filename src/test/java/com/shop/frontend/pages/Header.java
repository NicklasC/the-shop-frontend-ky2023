package com.shop.frontend.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;

public class Header {
    WebDriver driver;

    By txt_checkoutButtonText = By.className("rounded-pill");

    public Header(WebDriver driver) {
        this.driver = driver;
    }

    public String getCheckoutButtonText() {
        return driver.findElement(txt_checkoutButtonText).getText();
    }

    public boolean checkoutButtonTextIsZeroOrNull() {
        if (driver.findElement(txt_checkoutButtonText).getText().equals("") || driver.findElement(txt_checkoutButtonText).getText().equals("0")) {
            return true;
        } else {
            return false;
        }
    }
}