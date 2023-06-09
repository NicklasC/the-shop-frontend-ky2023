package com.shop.frontend.stepdefinitions;

import com.shop.frontend.pages.*;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class Stepdefs {

    public static WebDriver driver;
    public static ProductPage productPage; // Author: Priyanka
    public static Header header; // Author: Camilla
    public static Footer footer; // Author: Daniel

    public static CheckoutPage checkoutPage;

    // Author: Nicklas
    @Before
    public static void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("incognito");
        options.addArguments("--headless");
        options.addArguments("--window-size=1920,1080");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        System.out.println("Setting up....");
        header = new Header(driver); // Author: Camilla
        productPage = new ProductPage(driver); // Author: Priyanka
        checkoutPage = new CheckoutPage(driver);// Author: Nicklas
        footer = new Footer(driver); // Author: Daniel
    }

    // Author: Nicklas
    @After
    public static void tearDown() {
        System.out.println("Closing down....");
        //Sometimes github think driver is null for some reason so only calling quit method if it is not.
        if (driver != null) {
            driver.quit();
        }
    }

    // Author: Camilla
    @Given("User is on the page https:\\/\\/webshop-team2.netlify.app\\/")
    public void user_is_on_the_page_https_webshop_team2_netlify_app() {
        driver.get("https://webshop-team2.netlify.app/");
    }

    // Author: Camilla
    @Then("The website logo should be visible")
    public void the_website_logo_should_be_visible() {
        assertTrue(header.verifyLogoIsDisplayed(), "The header logo is not displayed.");
    }

    // Author: Camilla
    @When("User clicks on Home link in the header")
    public void user_clicks_on_home_link_in_the_header() {
        header.clickHomeLink();
    }

    // Author: Camilla
    @Then("The user should be navigated to the main page")
    public void the_user_should_be_navigated_to_the_main_page() {
        String expectedUrl = "https://webshop-team2.netlify.app/index.html";
        String actualUrl = header.getCurrentURL();
        assertEquals(expectedUrl, actualUrl, "The Home link in the header does not navigate to the right location");
    }

    // Author: Camilla
    @When("User clicks on Shop link in the header")
    public void user_clicks_on_shop_link_in_the_header() {
        header.clickShopLink();
    }

    // Author: Camilla
    @Then("The user should be navigated to the products page")
    public void the_user_should_be_navigated_to_the_products_page() {
        String expectedUrl = "https://webshop-team2.netlify.app/products.html";
        String actualUrl = header.getCurrentURL();
        assertEquals(expectedUrl, actualUrl, "The Shop link in the header does not navigate to the right location");
    }

    // Author: Camilla
    @When("User clicks on the checkout button in the header")
    public void user_clicks_on_the_checkout_button_in_the_header() {
        header.clickCheckoutButton();
    }

    // Author: Camilla
    @Then("The user should be navigated to the checkout page")
    public void the_user_should_be_navigated_to_the_checkout_page() {
        String expectedUrl = "https://webshop-team2.netlify.app/checkout.html";
        String actualUrl = header.getCurrentURL();
        assertEquals(expectedUrl, actualUrl, "The checkout button in the header does not navigate to the right location");
    }

    // Author: Nicklas
    @Given("user visits The Shop main page")
    public void userVisitsTheShopMainpage() {
        driver.get("https://webshop-team2.netlify.app/");//Before each normally navigates to page, but doing it here as well for better test understandability.
    }

    // Author: Nicklas
    @Then("the browser title should be {string}")
    public void theBrowserTitleShouldBe(String expectedTitle) {
        assertEquals(expectedTitle, driver.getTitle(), "Page title is not as expected");
    }

    // Author: Nicklas
    // method below can be used for utility purposes during test creation, error searching and similar
    public static void sleep(int numberOfSeconds) {
        try {
            Thread.sleep(numberOfSeconds * 1000); // Sleep for number of seconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    // Author: Nicklas
    @Given("user set userName to {string}")
    public void setUserName(String userName) {
        driver.get("https://webshop-team2.netlify.app/checkout.html");

        CheckoutPage page = new CheckoutPage(driver);
        page.setFirstName(userName);
    }

    // Author: Nicklas
    @Then("userName should be {string}")
    public void usernameShouldBe(String expectedValue) {
        CheckoutPage page = new CheckoutPage(driver);
        Assert.assertEquals(expectedValue, page.getFirstName());
    }

    // Author: Jim
    @Given("User is on main page")
    public void user_is_on_main_page() {
        driver.get("https://webshop-team2.netlify.app/");
    }

    // Author: Jim
    @Then("Backpack image should be displayed")
    public void backpack_image_should_be_displayed() {
        MainPage mainPage = new MainPage(driver);
        assertTrue(mainPage.checkBackPackImageIsDisplayed(), "Backpack image is not displayed.");
    }

    // Author: Jim
    @Then("Heading should be {string}")
    public void heading_should_be(String headingText) {
        MainPage mainPage = new MainPage(driver);
        assertEquals(headingText, mainPage.getHeadingText(), "Heading is not correct.");
    }

    // Author: Jim
    @Given("User is still on main page")
    public void user_is_still_on_main_page() {
        driver.get("https://webshop-team2.netlify.app/");
    }

    // Author: Jim
    @When("User clicks on the All products button")
    public void user_clicks_on_the_all_products_button() {
        MainPage mainPage = new MainPage(driver);
        mainPage.clickOnAllProductsButton();
    }

    // Author: Jim
    @Then("User should be navigated to the products page")
    public void user_should_be_navigated_to_the_products_page() {
        MainPage mainPage = new MainPage(driver);
        String expectedUrl = "https://webshop-team2.netlify.app/products.html";
        String actualUrl = mainPage.getCurrentURL();
        assertEquals(expectedUrl, actualUrl, "All products button is not working.");
    }

    // Author: Priyanka
    @Given("Visit The Shop Website")
    public void visitTheShopWebsite() {
        driver.get("https://webshop-team2.netlify.app/");
    }

    // Author: Priyanka
    @When("Click on the Shop tab")
    public void clickOnTheShopTab() {
        productPage.clickOnButtonShop();
    }

    // Author: Priyanka
    @And("Search the product")
    public void searchTheProduct() {
        productPage.enterDataInSearchField("b");
    }

    // Author: Priyanka
    @Then("Product should be displayed")
    public void productShouldBeDisplayed() {
        List<WebElement> products = productPage.getProductList();
        Assertions.assertFalse(products.isEmpty());
    }

    // Author: Priyanka
    @And("Click on Men's Clothing tab")
    public void clickOnMensClothingTab() {
        productPage.clickOnMensClothingTab();
    }

    // Author: Priyanka
    @Then("Men's Product should be displayed")
    public void mensProductShouldBeDisplayed() {
        List<WebElement> mensProducts = productPage.getMensProductList();
        Assertions.assertFalse(mensProducts.isEmpty());
    }

    // Author: Priyanka
    @And("Click on All tab")
    public void clickOnAllTab() {
        productPage.clickOnTabAll();
    }

    // Author: Nicklas
    @And("adding product with heading {string}")
    public void addProductWithProductText(String productText) {
        String xpathExpression = "//h3[contains(text(), '" + productText + "')]/following-sibling::button[1]";
        WebElement addButton = driver.findElement(By.xpath(xpathExpression));
        addButton.click();
    }

    // Author: Nicklas
    @Then("checkout badge text should be empty or zero")
    public void checkoutBadgeTextIsEmptyOrZero() {
        Header header = new Header(driver);
        Assert.assertTrue(header.checkoutButtonTextIsZeroOrNull());
    }

    // Author: Nicklas
    @Then("checkout badge text should be {string}")
    public void checkoutBadgeTextShouldShow(String expectedNumber) {
        Header header = new Header(driver);
        Assert.assertEquals(expectedNumber, header.getCheckoutBadgeText());
    }

    // Author: Nicklas
    @And("click on checkout button")
    public void clickOnCheckoutButton() {
        header.clickOnCheckoutButton();
    }

    // Author: Nicklas
    @Then("checkout form should display")
    public void checkoutFormShouldDisplay() {
        Assert.assertTrue(checkoutPage.pageHeaderDisplays());
    }

    // Author: Nicklas
    @And("checkout total should be {string}")
    public void checkoutTotalShouldBe(String expectedSum) {
        Assert.assertEquals(expectedSum, checkoutPage.getOrderSum());
    }

    // Author: Nicklas
    @Then("click the top remove button")
    public void clickTheTopRemoveButton() {
        checkoutPage.clickFirstRemoveButton();
    }

    // Author: Nicklas
    @Then("cart size should be {string}")
    public void cartSizeShouldBe(String expectedString) {
        Assert.assertEquals("Cart size should be " + expectedString, expectedString, checkoutPage.getCartSize());
    }

    // Author: Daniel
    @Given("User is on the product page")
    public void user_is_on_the_product_page() {
        driver.get("https://webshop-team2.netlify.app/products.html");
    }
    // Author: Daniel
    @When("User clicks on the Home link in the footer")
    public void user_clicks_on_the_home_link_in_the_footer() {
        footer.clickOnTheHomeLink();
    }

    // Author: Daniel
    @Then("The headline on the page directed to should be {string}")
    public void the_headline_on_the_page_directed_to_should_be(String expectedHeading) {
        MainPage mainPage = new MainPage(driver);
        String actualHeading = mainPage.getHeadingText();
        assertEquals(expectedHeading, actualHeading, "The heading doesn't seem to be correct");
    }

    // Author: Daniel
    @When("When user clicks on the Shop link in the footer")
    public void when_user_clicks_on_the_shop_link_in_the_footer() {
        footer.clickOnTheShopLink();
    }

    // Author: Daniel
    @Then("The url for the Shop page should be {string}")
    public void the_url_for_the_shop_page_should_be(String expectedUrl) {
        String actualUrl = footer.getCurrentUrl();
        assertEquals(expectedUrl, actualUrl, "The url doesn't seem to be correct");
    }

    // Author: Daniel
    @When("User clicks on the Checkout link in the footer")
    public void user_clicks_on_the_checkout_link_in_the_footer() {
        footer.clickOnTheCheckoutLink();
    }

    // Author: Daniel
    @Then("The url for the Checkout page should be {string}")
    public void the_url_for_the_checkout_page_should_be(String expectedUrl) {
        String actualUrl = footer.getCurrentUrl();
        assertEquals(expectedUrl, actualUrl, "The url doesn't seem to be correct");
    }

    // Author: Daniel
    @Then("The text in the footer should be {string}")
    public void the_text_in_the_footer_should_be(String expectedText) {
        String actualText = footer.getFooterText();
        assertEquals(expectedText, actualText, "The text doesn't seem to be correct");
    }

}


