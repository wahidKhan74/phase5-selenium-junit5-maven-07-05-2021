package com.webapp.test.amazon;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

class AmazonHomePageTest {
	
	// 1. formulate test url
	final String siteURL = "https://www.amazon.in/";
	final String driverPath = "drivers/chromedriver";
	WebDriver driver;
	
	@BeforeEach
	void setUp() throws Exception {

		// 2. set selenium system property
		System.setProperty("webdriver.chrome.driver", driverPath);

		// 3. Instantiate selenium webdriver
		driver = new ChromeDriver();

		// 4. Launch browser window
		driver.get(siteURL);
	}

	@AfterEach
	void tearDown() throws Exception {
		// 6. close driver.
		driver.close();
	}

	@Test
	@DisplayName("Amazon Test Hompage")
	void testAmazonHomePage() {
		// 5. test evaluation
		String expectedTitle = "Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in";
		String actualTitle = driver.getTitle();

		if (actualTitle.equals(expectedTitle)) {
			System.out.println("Test is passed !");
		} else {
			System.out.println("Test is failed !");
		}
		System.out.println("Expected Title : " + expectedTitle);
		System.out.println("Actual Title : " + actualTitle);
	}

}
