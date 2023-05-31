package com.shop.frontend.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Header {
    WebDriver driver;

    By link_home = By.xpath("/html/body/header/div/div/ul/li[1]/a");
    By link_shop = By.xpath("/html/body/header/div/div/ul/li[2]/a");


    public Header(WebDriver driver){
        this.driver = driver;
    }

    public WebElement clickHomeLink() {
        WebElement homeLink = driver.findElement(link_home);
        homeLink.click();
        return homeLink;
    }

    public WebElement clickShopLink() {
        WebElement shopLink = driver.findElement(link_shop);
        shopLink.click();
        return shopLink;
    }

    public String getCurrentURL() {
        return driver.getCurrentUrl();
    }
}