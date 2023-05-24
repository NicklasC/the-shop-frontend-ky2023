package com.shop.frontend.stepdefinitions;

import com.shop.frontend.pages.CheckoutPage;
import io.cucumber.java.AfterAll;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class Stepdefs {

    public static WebDriver driver;

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
        // trigger pipeline text"
    }

    @AfterAll
    public static void tearDown() {
        System.out.println("Closing down....");
        //Sometimes github think driver is null for some reason so only calling quit method if it is not.
        if (driver != null){
            driver.quit();
        }
    }

    @Given("user visits The Shop main page")
    public void userVisitsTheShopMainpage() {
        driver.get("https://webshop-agil-testautomatiserare.netlify.app/");//Before each normally navigates to page, but doing it here as well for better test understandability.
    }

    @Then("the browser title should be {string}")
    public void theBrowserTitleShouldBe(String expectedTitle) {
        assertEquals(expectedTitle, driver.getTitle(), "Page title is not as expected");
    }


    // method below can be used for utility purposes during test creation, error searching and similar
    public static void sleep(int numberOfSeconds) {
        try {
            Thread.sleep(numberOfSeconds * 1000); // Sleep for number of seconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Given("user set userName to {string}")
    public void setUserName(String userName) {
        //Navigating to checkoutpage for testing. TODO:Remove navigation below once navigation step is in place.
        driver.get("https://webshop-agil-testautomatiserare.netlify.app/checkout.html");

        CheckoutPage page = new CheckoutPage(driver);
        page.setFirstName(userName);
    }

    @Then("userName should be {string}")
    public void usernameShouldBe(String expectedValue) {
        CheckoutPage page = new CheckoutPage(driver);
        Assert.assertEquals(expectedValue, page.getFirstName());
    }
}


