package com.shop.frontend.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MainPage {
    WebDriver driver;

    // Author: Jim
    By img_backpack = By.xpath("/html/body/div[1]/div/div[2]/img");
    By txt_heading = By.cssSelector(".display-4.fw-bold.lh-1");
    By btn_AllProducts = By.cssSelector(".btn.btn-primary.btn-lg.px-4.me-md-2.fw-bold");
    public MainPage(WebDriver driver) { this.driver = driver; }

    // Author: Jim
    public boolean checkBackPackImageIsDisplayed() {
        WebElement backPackImage = driver.findElement(img_backpack);
        return backPackImage.isDisplayed();
    }

    // Author: Jim
    public String getHeadingText() {
        WebElement headingText = driver.findElement(txt_heading);
        return headingText.getText();
    }

    // Author: Jim
    public void clickOnAllProductsButton() {
        WebElement allProducts = driver.findElement(btn_AllProducts);
        allProducts.click();

    }

    // Author: Jim
    public String getCurrentURL() {
        return driver.getCurrentUrl();
    }

}
