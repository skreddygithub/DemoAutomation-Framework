package com.gammax.stepdefinitions;

import com.gammax.factory.PageFactoryManager;
import com.gammax.hooks.MyHooks;
import com.gammax.pages.HomePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.testng.Assert;

import java.time.Duration;

public class addtocart {

    @Given("I'm on the Gammax Page")
    public void i_m_on_the_gammax_page() throws InterruptedException {
        Thread.sleep(10000);

    }
    @When("I add a {string} to the cart")
    public void i_add_a_to_the_cart(String string) {
        HomePage home = PageFactoryManager.getHomePage(MyHooks.driver);
        home.clickConnectWallet();
    }
    @Then("I should see {int} {string} in the cart")
    public void i_should_see_in_the_cart(Integer int1, String string) {
       MyHooks.driver.findElement(By.xpath("//div[text()=' Get started ']")).click();
    }
}
