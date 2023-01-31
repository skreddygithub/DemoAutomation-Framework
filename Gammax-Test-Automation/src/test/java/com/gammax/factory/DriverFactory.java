package com.gammax.factory;

import com.gammax.constants.FrameworkConstants;
import com.gammax.hooks.MyHooks;
import com.gammax.listeners.EventListener;
import com.gammax.utils.ConfigLoader;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.logging.Logs;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.events.WebDriverEventListener;
import org.testng.Assert;
import org.w3c.dom.events.Event;

import java.io.File;
import java.time.Duration;
import java.util.Set;

import static com.gammax.constants.FrameworkConstants.BROWSER_CHROME;
import static com.gammax.constants.FrameworkConstants.BROWSER_FIREFOX;
import static com.gammax.constants.FrameworkConstants.BROWSER_SAFARI;
import static com.gammax.constants.FrameworkConstants.BROWSER_EDGE;

public class DriverFactory {
	public static WebDriver driver;

	static Logger log= Logger.getLogger(DriverFactory.class);

	public static void initializeDriver(String browser) throws Exception{
		driver = null;
		log.info("************Initializing the browser "+browser+"********************");
		switch (browser) {
		case BROWSER_CHROME: {
			System.out.println(System.getProperty("user.dir"));
			ChromeOptions opt = new ChromeOptions();
			opt.addExtensions(new File(System.getProperty("user.dir")+"/src/test/resources/extension_10_24_1_0.crx"));
			driver = new ChromeDriver(opt);
			break;
		}
		case BROWSER_FIREFOX: {
			driver = new FirefoxDriver();
			break;
		}
		case BROWSER_SAFARI: {
			driver = new SafariDriver();
			break;
		}
		case BROWSER_EDGE: {
			driver = new EdgeDriver();
			break;
		}
		default:
			throw new IllegalStateException("INVALID BROWSER: " + browser);
		}
		EventFiringWebDriver eventDriver = new EventFiringWebDriver(driver);
		EventListener listen = new EventListener();
		driver = eventDriver.register(listen);
		driver.manage().window().maximize();
		driver.get(ConfigLoader.getInstance().getBaseUrl());
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(FrameworkConstants.IMPLICIT_WAIT));
		Assert.assertTrue(driver.getTitle().contains("Gammax"));
		Set<String> windows = driver.getWindowHandles();
		for(String window:windows){
			driver.switchTo().window(window);
			if(driver.getTitle().equals("MetaMask")){
				break;
			}
		}
		driver.findElement(By.xpath("//button[text()='Import an existing wallet']")).click();
		driver.findElement(By.xpath("//button[text()='I agree']")).click();

		String[] words = {"cat","tourist","inside","robot","blossom","provide"
				,"elephant","antenna","small","bonus","mesh","better"};
		for(int i = 0; i<words.length; i++)
			driver.findElement(By.xpath("//input[@id='import-srp__srp-word-"+i+"']")).sendKeys(words[i]);

		driver.findElement(By.xpath("//button[text()='Confirm Secret Recovery Phrase']")).click();
		driver.findElements(By.xpath("//input[@type='password']")).get(0).sendKeys("19961996s@K");
		driver.findElements(By.xpath("//input[@type='password']")).get(1).sendKeys("19961996s@K");
		driver.findElement(By.xpath("//input[@type='checkbox']")).click();
		driver.findElement(By.xpath("//button[text()='Import my wallet']")).click();
		while(true){
			if(driver.getPageSource().contains("spinner")){
				Thread.sleep(1000);
			}else{
				break;
			}
		}
		driver.findElement(By.xpath("//button[text()='Got it!']")).click();
		driver.findElement(By.xpath("//button[text()='Next']")).click();
		driver.findElement(By.xpath("//button[text()='Done']")).click();
		driver.findElement(By.xpath("//button[@class='home__subheader-link--tooltip-content-header-button']")).click();
		driver.findElement(By.xpath("//div[@data-testid='network-display']")).click();
		driver.findElement(By.xpath("//button[text()='Add network']")).click();
//		driver.findElement(By.xpath("//div[text()='Networks']")).click();
//		driver.findElement(By.xpath("//div[text()='Goerli test network']")).click();
//		driver.findElement(By.xpath("//button[text()='Add a network']")).click();
		driver.findElement(By.xpath("//div[text()='Advanced']")).click();
		driver.findElement(By.xpath("//span[text()='Show test networks']/../../div[2]/div/label/div[1]")).click();
		driver.findElement(By.xpath("//button[text()='Save']")).click();
		driver.findElement(By.xpath("//div[@data-testid='network-display']")).click();
		driver.findElement(By.xpath("//span[text()='Goerli test network']")).click();
		driver.findElement(By.xpath("//button[text()='Save']")).click();
		for(String window:windows){
			driver.switchTo().window(window);
			if(driver.getTitle().contains("Gammax")){
				break;
			}
		}
	}

	public static void quitDriver(){
		driver.quit();
	}
}
