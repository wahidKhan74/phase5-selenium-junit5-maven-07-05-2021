package com.webapp.test.external.webelement;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserWindowPopupTest {
	
	final String siteURL = "https://www.amazon.in/";
	final String driverPath = "drivers\\windows\\chromedriver.exe";
	WebDriver driver;

	@BeforeEach
	void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", driverPath);
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		driver.get(siteURL);
	}

	@AfterEach
	void tearDown() throws Exception {
		 driver.close();
	}
	
	@Test
	@DisplayName("Amazon Test : Amazon custom browser popup")
	void testToVerifyAmazonLocationPopup() throws InterruptedException {
		// find address link
		WebElement addressLink = driver.findElement(By.id("nav-global-location-popover-link"));
		addressLink.click();
		
		// swith from main window to popup
		String mainWindow = driver.getWindowHandle();
		// list of external popup
		Set<String> winodws = driver.getWindowHandles();
		Iterator<String> itr = winodws.iterator();
		
		while(itr.hasNext()) {
			String childWindow = itr.next();
			// switch to child window
			driver.switchTo().window(childWindow);
			
			driver.findElement(By.id("GLUXZipUpdateInput")).sendKeys("500038");
			Thread.sleep(2000);
			
			driver.findElement(By.cssSelector("#GLUXZipUpdate > span > input")).click();			
		}
		
		driver.switchTo().window(mainWindow);
		Thread.sleep(5000);
	}
}
