package com.shop.frontend.stepdefinitions;

import com.shop.frontend.pages.CheckoutPage;
import com.shop.frontend.pages.Header;
import com.shop.frontend.pages.MainPage;
import com.shop.frontend.pages.ProductPage;
import io.cucumber.java.AfterAll;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
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
    public static Header header; // Author: Camilla
    public static ProductPage productPage;

    // Author: Nicklas
    @BeforeAll
    public static void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("incognito");
        options.addArguments("--headless");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        System.out.println("Setting up....");
        header = new Header(driver); // Author: Camilla
        productPage = new ProductPage(driver); //Author: Priyanka
        // trigger pipeline text"
    }

    // Author: Nicklas
    @AfterAll
    public static void tearDown() {
        System.out.println("Closing down....");
        //Sometimes github think driver is null for some reason so only calling quit method if it is not.
        if (driver != null) {
            driver.quit();
        }
    }

    // Author: Camilla
    @Given("User is on the page https:\\/\\/webshop-agil-testautomatiserare.netlify.app\\/")
    public void user_is_on_the_page_https_webshop_agil_testautomatiserare_netlify_app() {
        driver.get("https://webshop-agil-testautomatiserare.netlify.app/");
    }

    // Author: Camilla
    @When("User clicks on a link in the header")
    public void user_clicks_on_a_link_in_the_header() {
        header.clickHomeLink();
        header.clickShopLink();
    }

    // Author: Camilla
    @When("User clicks on Home link in the header")
    public void user_clicks_on_home_link_in_the_header() {
        header.clickHomeLink();
    }

    // Author: Camilla
    @When("User clicks on Shop link in the header")
    public void user_clicks_on_shop_link_in_the_header() {
        header.clickShopLink();
    }

    // Author: Camilla
    @Then("The user should be navigated to the main page")
    public void the_user_should_be_navigated_to_the_main_page() {
        String expectedUrl = "https://webshop-agil-testautomatiserare.netlify.app/index.html";
        String actualUrl = header.getCurrentURL();
        assertEquals(expectedUrl, actualUrl, "The Home link in the header does not navigate to the right location");
    }

    // Author: Camilla
    @Then("The user should be navigated to the products page")
    public void the_user_should_be_navigated_to_the_products_page() {
        String expectedUrl = "https://webshop-agil-testautomatiserare.netlify.app/products.html";
        String actualUrl = header.getCurrentURL();
        assertEquals(expectedUrl, actualUrl, "The Shop link in the header does not navigate to the right location");
    }



    // Author: Nicklas
    @Given("user visits The Shop main page")
    public void userVisitsTheShopMainpage() {
        driver.get("https://webshop-agil-testautomatiserare.netlify.app/");//Before each normally navigates to page, but doing it here as well for better test understandability.
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
        //Navigating to checkoutpage for testing. TODO:Remove navigation below once navigation step is in place.
        driver.get("https://webshop-agil-testautomatiserare.netlify.app/checkout.html");

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
        driver.get("https://webshop-agil-testautomatiserare.netlify.app/");
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
        driver.get("https://webshop-agil-testautomatiserare.netlify.app/");
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
        String expectedUrl = "https://webshop-agil-testautomatiserare.netlify.app/products.html";
        String actualUrl = mainPage.getCurrentURL();
        assertEquals(expectedUrl, actualUrl, "All products button is not working.");
    }


    // Author: Priyanka
    @Given("Visit The Shop Website")
    public void visitTheShopWebsite() {
        driver.get("https://webshop-agil-testautomatiserare.netlify.app/");
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
    @And("Click on All tab")
    public void clickOnAllTab() {
        productPage.clickOnTabAll();
    }

}


