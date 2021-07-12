package com.webapp.test.external.screenshot;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

class TakeBrowserScreenShotTest {

	final String siteURL = "https://www.amazon.in/";
	final String driverPath = "drivers\\windows\\chromedriver.exe";
	WebDriver driver;

	@BeforeEach
	void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", driverPath);
		driver = new ChromeDriver();
		driver.get(siteURL);
	}

	@AfterEach
	void tearDown() throws Exception {
		driver.close();
	}
	
	@Test 
	void testHomepageScreenShot() throws IOException {
		this.takeScreenShot("amazon-homepage.png");
	}

	@Test
	@DisplayName("Amazon Test : Amazon custom browser popup")
	void testToVerifyAmazonLocationPopup() throws InterruptedException, IOException {
		// find address link
		WebElement addressLink = driver.findElement(By.id("nav-global-location-popover-link"));
		addressLink.click();
		Thread.sleep(5000);
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
			Thread.sleep(5000);
			
			
			Thread.sleep(5000);
			
			driver.findElement(By.cssSelector("#GLUXZipUpdate > span > input")).click();
			
			this.takeScreenShot("location-popup.png");
			
		}
		
		driver.switchTo().window(mainWindow);
		Thread.sleep(5000);
	}
	
	
	
	private void takeScreenShot(String filename) throws IOException {
		// type cast driver object into TakesScreenshot
		TakesScreenshot tsc = (TakesScreenshot) driver;
		
		// take screenshot as file
		File src = tsc.getScreenshotAs(OutputType.FILE);
		
		// save file
		FileHandler.copy(src, new File("output-screenshot\\"+filename));
	}
	

}
