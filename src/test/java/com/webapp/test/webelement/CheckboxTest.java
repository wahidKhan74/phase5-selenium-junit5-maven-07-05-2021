package com.webapp.test.webelement;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

class CheckboxTest {

	final String siteURL = "file:///home/wahidkhan74gmai/FS-Workspace/phase5-selenium-junit5-maven-07-05-2021/static/web-elements.html";
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
	@DisplayName("Checkbox exist test")
	public void testToVerifyCheckBoxExist() {
		
		WebElement checkBox1 = driver.findElement(By.id("vehicle1"));
		assertEquals(true, checkBox1.isDisplayed());
		assertEquals(true, checkBox1.isEnabled());
		assertEquals(false, checkBox1.isSelected());
		
		WebElement checkBox2 = driver.findElement(By.id("vehicle2"));
		assertEquals(true, checkBox2.isDisplayed());
		assertEquals(true, checkBox2.isEnabled());
		//default select
		assertEquals(true, checkBox2.isSelected());
		
	}
	
	@Test
	@DisplayName("Checkbox 1 select test")
	public void testSelectCheckBox1() throws InterruptedException {
		
		WebElement checkBox1 = driver.findElement(By.id("vehicle1"));
		assertEquals(true, checkBox1.isDisplayed());
		assertEquals(true, checkBox1.isEnabled());
		assertEquals(false, checkBox1.isSelected());
		
		// select checkbox
		checkBox1.click();
		assertEquals(true, checkBox1.isSelected());
		Thread.sleep(3000);
	}
	
	@Test
	@DisplayName("Checkbox 2 deselect test")
	public void testDeSelectCheckBox2() throws InterruptedException {
		
		WebElement checkBox2 = driver.findElement(By.id("vehicle2"));
		assertEquals(true, checkBox2.isDisplayed());
		assertEquals(true, checkBox2.isEnabled());
		//default select
		assertEquals(true, checkBox2.isSelected());
		
		// select checkbox
		checkBox2.click();
		assertEquals(false, checkBox2.isSelected());
		Thread.sleep(3000);
	}

}
