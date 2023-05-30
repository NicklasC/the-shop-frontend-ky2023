package com.shop.frontend.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MainPage {
    WebDriver driver;

    By img_backpack = By.xpath("/html/body/div[1]/div/div[2]/img");

    public MainPage(WebDriver driver) { this.driver = driver; }

    // Author: Jim
    public boolean checkBackPackImageIsDisplayed() {
        WebElement backPackImage = driver.findElement(img_backpack);
        return backPackImage.isDisplayed();
    }

}
