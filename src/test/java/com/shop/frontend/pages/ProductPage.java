package com.shop.frontend.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProductPage {

    WebDriver driver;
    // Author: Priyanka
    By tabAll = By.xpath("/html/body/div[1]/div/ul/li[1]/a");

    public ProductPage(WebDriver driver) {
        this.driver = driver;
    }

    // Author: Priyanka
    public WebElement clickOnTabAll() {
        WebElement AllTab = driver.findElement(tabAll);
        AllTab.click();
        return AllTab;
    }

}
