package com.shop.frontend.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Collections;
import java.util.List;

public class ProductPage {
    WebDriver driver;
    // Author: Priyanka
    By btn_Shop = By.xpath("/html/body/header/div/div/ul/li[2]/a");
    By txt_SearchField = By.id("search");
    By productList = By.className("col");

    public ProductPage(WebDriver driver) {
        this.driver = driver;
    }

    // Author: Priyanka
    public void clickOnButtonShop() {
        WebElement element = driver.findElement(btn_Shop);
        element.click();

    }

    // Author: Priyanka
    public void clickOnSearchField(String value) {
        WebElement element = driver.findElement(txt_SearchField);
        element.sendKeys(value);
        element.sendKeys(Keys.ENTER);

    }

    // Author: Priyanka
    public List<WebElement> getProductList() {
        List<WebElement> products = Collections.singletonList(driver.findElement(productList));
        return products;

    }

}
