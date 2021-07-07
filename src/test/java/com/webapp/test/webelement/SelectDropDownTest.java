package com.webapp.test.webelement;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class SelectDropDownTest {
	
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
	@DisplayName("Test Select dropdown exist ")
	public void testToVerifyDropDownExist() {
		
		WebElement select = driver.findElement(By.id("vehicle"));
		assertEquals(true, select.isDisplayed());
		assertEquals(true, select.isEnabled());		
	}
	
	@Test
	@DisplayName("Test first selected option from dropdown")
	public void testToVerifyFirstSelectFromDropDown() throws InterruptedException {
		
		WebElement select = driver.findElement(By.id("vehicle"));
		
		Select vselected = new Select(select);
		
		// select bike as selected option
		vselected.selectByVisibleText("Bike");
		WebElement selectedValue = vselected.getFirstSelectedOption();
		assertEquals(" Bike ", selectedValue.getText());
		Thread.sleep(3000);
			
	}
	
	
	@Test
	@DisplayName("Test 3 index selected option from dropdown")
	public void testToVerifyThirdIndexFromDropDown() throws InterruptedException {
		
		WebElement select = driver.findElement(By.id("vehicle"));
		
		Select vselected = new Select(select);
		
		// select bike as selected option
		vselected.selectByIndex(3);
		WebElement selectedValue = vselected.getFirstSelectedOption();
		assertEquals(" Airplane ", selectedValue.getText());
		Thread.sleep(3000);
			
	}
	
	@Test
	@DisplayName("Test select option based on value from dropdown")
	public void testToVerifyValueSelectDropDown() throws InterruptedException {
		
		WebElement select = driver.findElement(By.id("vehicle"));
		
		Select vselected = new Select(select);
		
		// select bike as selected option
		vselected.selectByValue("car");
		WebElement selectedValue = vselected.getFirstSelectedOption();
		assertEquals(" Car ", selectedValue.getText());
		Thread.sleep(3000);
			
	}
}
