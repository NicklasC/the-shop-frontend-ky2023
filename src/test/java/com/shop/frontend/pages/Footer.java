package com.shop.frontend.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Footer {
    WebDriver driver;

    // Author: Daniel
    By link_Home = By.xpath("//a[@href=\"index.html\"]");
    By link_Shop = By.xpath("//a[@href=\"products.html\"]");
    By link_Checkout = By.xpath("//a[@href=\"checkout.html\"]");
    By link_About = By.linkText("About");
    By txt_Footer = By.xpath("/html/body/div[2]/footer/p");

    public Footer(WebDriver driver) {this.driver = driver;}

    // Author: Daniel
    public void clickOnTheHomeLink() {
        driver.findElement(link_Home).click();
    }

    // Author: Daniel
    public void clickOnTheShopLink() {
        driver.findElement(link_Shop).click();
    }

    // Author: Daniel
    public void clickOnTheCheckoutLink() {
        driver.findElement(link_Checkout).click();
    }

    // Author: Daniel
    public void clickOnTheAboutLink() {
        WebElement aboutLink = driver.findElement(link_About);
        aboutLink.click();
    }

    // Author: Daniel
    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    // Author: Daniel
    public String getFooterText() {
        WebElement footerText = driver.findElement(txt_Footer);
        return footerText.getText();
    }
}
