package com.webapp.test.amazon;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

class AmazonNavigationLinkTest {

	final String siteURL = "https://www.amazon.in/";
	final String driverPath = "drivers/chromedriver";
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
	@DisplayName("Amazon Test : Mobile Link Verfication")
	void testAmazonMobileLinkNavigation() throws InterruptedException {	
		//find mobile link
		WebElement mobileLink = driver.findElement(By.cssSelector("#nav-xshop > a:nth-child(3)"));
		
		// test existence
		assertTrue(mobileLink.isDisplayed());
		assertTrue(mobileLink.isEnabled());
		
		// click on mobile
		mobileLink.click();
		String expected = "Mobile Phones: Buy New Mobiles Online at Best Prices in India | Buy Cell Phones Online - Amazon.in";
		assertEquals(expected, driver.getTitle());
		
		Thread.sleep(3000);		
	}
	
	@Test
	@DisplayName("Amazon Test : Fashion Link Verfication")
	void testAmazonFashionLinkNavigation() throws InterruptedException {	
		//find mobile link
		WebElement fashionLink = driver.findElement(By.cssSelector("#nav-xshop > a:nth-child(4)"));
		
		// test existence
		assertTrue(fashionLink.isDisplayed());
		assertTrue(fashionLink.isEnabled());
		
		// click on mobile
		fashionLink.click();
		String expected = "Amazon Fashion: Clothing, Footwear and Accessories online for Men, Women and Kids";
		assertEquals(expected, driver.getTitle());
		
		Thread.sleep(3000);		
	}
	
	// TODO : WAT for min 3 nav links from amazon.in
}
