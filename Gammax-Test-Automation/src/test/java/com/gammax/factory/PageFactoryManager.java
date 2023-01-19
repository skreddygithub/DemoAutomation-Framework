package com.gammax.factory;

import com.gammax.pages.HomePage;
import org.openqa.selenium.WebDriver;

public class PageFactoryManager {

    private static HomePage homePage;

	public static HomePage getHomePage(WebDriver driver) {
		return homePage == null ? new HomePage(driver) : homePage;
	}
}
