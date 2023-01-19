package com.gammax.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

	@FindBy(xpath = "//div[text()='Connect Wallet']")
	private WebElement connectWallet;

	public HomePage(WebDriver driver) {
		super(driver);
	}

	public void clickConnectWallet() {
		click(connectWallet);
	}
}
