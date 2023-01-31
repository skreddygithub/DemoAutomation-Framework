package com.gammax.stepdefinitions;

import com.gammax.factory.PageFactoryManager;
import com.gammax.hooks.MyHooks;
import com.gammax.pages.HomePage;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;

import java.time.Duration;
import java.util.Set;

import static com.gammax.factory.DriverFactory.driver;

public class addtocart {

    @Given("I'm on the Gammax Page")
    public void i_m_on_the_gammax_page() throws InterruptedException {
        Thread.sleep(10000);
        byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
        MyHooks.scenario.attach(screenshot, "image/png", MyHooks.scenario.getName()+"000");
    }
    @When("I add a {string} to the cart")
    public void i_add_a_to_the_cart(String string) {
        HomePage home = PageFactoryManager.getHomePage(driver);
        home.clickConnectWallet();
        byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
        MyHooks.scenario.attach(screenshot, "image/png", MyHooks.scenario.getName()+"123");
    }
    @Then("I should see {int} {string} in the cart")
    public void i_should_see_in_the_cart(Integer int1, String string) {
       driver.findElement(By.xpath("//div[text()=' Get started ']")).click();
        byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
        MyHooks.scenario.attach(screenshot, "image/png", MyHooks.scenario.getName()+"345");
//       driver.findElement(By.xpath("//div[text()='MetaMask']")).click();
//       while (true){
//           if(driver.getWindowHandles().size() == 3){
//               break;
//           }
//       }
//       Set<String> windows = driver.getWindowHandles();
//       for(String window:windows){
//            driver.switchTo().window(window);
//            if(driver.getTitle().contains("MetaMask Notification")){
//                break;
//            }
//        }
//       MyHooks.driver.findElement(By.xpath("//button[text()='Next']")).click();
//       MyHooks.driver.findElement(By.xpath("//button[text()='Connect']")).click();
//       MyHooks.driver.findElement(By.xpath("//button[text()='Sign']")).click();
//        for(String window:windows){
//            driver.switchTo().window(window);
//            if(driver.getTitle().contains("Gammax")){
//                break;
//            }
//        }
//        Assert.assertEquals(MyHooks.driver.findElement(By.xpath("//div[@role='alertdialog']")).getText().trim(),"Wallet connected successful!");
//        Assert.assertTrue(MyHooks.driver.findElement(By.className("btn-deposit ng-star-inserted")).isDisplayed());
//        Assert.assertTrue(MyHooks.driver.findElement(By.className("btn-withdrawl ng-star-inserted")).isDisplayed());
//
//        MyHooks.driver.findElement(By.xpath("//button[contains(@class,'notification-btn')]")).click();
//
//        Assert.assertTrue(MyHooks.driver.findElement(By.xpath("//div[@class='notification-badge']")).getText().trim().equals("Notifications"));
//        Assert.assertTrue(MyHooks.driver.findElement(By.xpath("//div[@class='badge']/span")).isDisplayed());
//
//        MyHooks.driver.findElement(By.xpath("//div[@class='notification-badge']/following-sibling::img[@class='pointer']")).click();
//
//        MyHooks.driver.findElement(By.xpath("//div[@class='settings-icon-container']/img")).click();
//        Assert.assertTrue(MyHooks.driver.findElement(By.className("dropd-menu dropd-menu-right language-drop-down ng-star-inserted")).isDisplayed());
//
//        int count = MyHooks.driver.findElements(By.xpath("//div[@class='dropd-menu dropd-menu-right language-drop-down ng-star-inserted']/div")).size();
//        String[] language = {"Para Yatırma","存款","예금","Einzahlung","Dépôt","डिपॉज़िट","Setor","Depósito","Depósito"};
//        for(int i = 1; i<count; i++){
//            MyHooks.driver.findElements(By.xpath("//div[@class='dropd-menu dropd-menu-right language-drop-down ng-star-inserted']/div/input")).get(i).click();
//            Assert.assertEquals(MyHooks.driver.findElement(By.className("btn-deposit ng-star-inserted")).getText(), language[i-1]);
//            MyHooks.driver.findElement(By.xpath("//div[@class='settings-icon-container']/img")).click();
//        }
//        MyHooks.driver.findElements(By.xpath("//div[@class='dropd-menu dropd-menu-right language-drop-down ng-star-inserted']/div/input")).get(0).click();



    }
}
