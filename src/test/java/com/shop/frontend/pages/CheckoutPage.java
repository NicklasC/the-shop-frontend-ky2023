package com.shop.frontend.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static com.shop.frontend.stepdefinitions.Stepdefs.sleep;

public class CheckoutPage {
    WebDriver driver;
    By txt_FirstName = By.id("firstName");

    public CheckoutPage(WebDriver driver){
        this.driver = driver;
    }

    // Author: Nicklas
    public void setFirstName(String value){
        driver.findElement(txt_FirstName).sendKeys(value);

    }

    // Author: Nicklas
    public String getFirstName() {
        return driver.findElement(txt_FirstName).getAttribute("value");
    }

}
