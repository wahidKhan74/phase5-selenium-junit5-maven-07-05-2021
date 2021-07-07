package com.webapp.test.amazon;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

class AmazonProductSearchTest {

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
	void testProductSearchForIphone() {
		// find a search bar
		WebElement searchBar = driver.findElement(By.id("twotabsearchtextbox"));
		// test search bar exist
		assertTrue(searchBar.isDisplayed());
		assertTrue(searchBar.isEnabled());
		// add search text
		searchBar.sendKeys("Iphone 12");
		searchBar.submit();
		assertEquals("Amazon.in : Iphone 12", driver.getTitle());
	}
	
	@Test
	void testProductSearchForLaptop() {
		// find a search bar
		WebElement searchBar = driver.findElement(By.id("twotabsearchtextbox"));
		// test search bar exist
		assertTrue(searchBar.isDisplayed());
		assertTrue(searchBar.isEnabled());
		// add search text
		searchBar.sendKeys("Dell Laptop");
		searchBar.submit();
		assertEquals("Amazon.in : Dell Laptop", driver.getTitle());
	}
	

}
