package com.shop.frontend.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckoutPage {
    WebDriver driver;
    By txt_FirstName = By.id("firstName");
    By lbl_header = By.xpath("//H2[text()='Checkout form']");
    By lbl_displayedSum = By.cssSelector("strong");
    By btn_firstRemoveButton = By.xpath("//li[1]//div[1]//button[1]");
    By lbl_cartSize = By.id("cartSize");

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
    }

    // Author: Nicklas
    public void setFirstName(String value) {
        driver.findElement(txt_FirstName).sendKeys(value);

    }

    // Author: Nicklas
    public String getFirstName() {
        return driver.findElement(txt_FirstName).getAttribute("value");
    }

    public boolean pageHeaderDisplays() {
        return driver.findElement(lbl_header).isDisplayed();
    }

    // Author: Nicklas
    public String getOrderSum() {
        WebElement displayedSum = driver.findElement(lbl_displayedSum);
        return displayedSum.getText();
    }

    // Author: Nicklas
    public void clickFirstRemoveButton() {
        WebElement firstRemoveButton = driver.findElement(btn_firstRemoveButton);
        firstRemoveButton.click();
    }

    // Author: Nicklas
    public String getCartSize() {
        WebElement cartSize = driver.findElement(lbl_cartSize);
        return cartSize.getText();
    }
}
