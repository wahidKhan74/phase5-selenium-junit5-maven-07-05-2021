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

public class RadioButtonTest {
	
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
	@DisplayName("Radio button 1 exist test")
	public void testToVerifyRadioButtonExist() {
		
		WebElement radio1 = driver.findElement(By.id("male"));
		assertEquals(true, radio1.isDisplayed());
		assertEquals(true, radio1.isEnabled());
		assertEquals(false, radio1.isSelected());
		
	}
	
	@Test
	@DisplayName("Radio button 2 exist test")
	public void testToVerifyRadioButton2Exist() {
		
		WebElement radio2 = driver.findElement(By.id("female"));
		assertEquals(true, radio2.isDisplayed());
		assertEquals(true, radio2.isEnabled());
		assertEquals(false, radio2.isSelected());
		
	}
	
	@Test
	@DisplayName("Radio button 1 is clicked ")
	public void testToVerifyRadioButton1Clicked() throws InterruptedException {
		
		WebElement radio1 = driver.findElement(By.id("male"));
		assertEquals(true, radio1.isDisplayed());
		assertEquals(true, radio1.isEnabled());
		
		// select a radio button
		radio1.click();
		Thread.sleep(3000);		
		assertEquals(true, radio1.isSelected());
		
	}
	
	@Test
	@DisplayName("Radio button 2 is clicked ")
	public void testToVerifyRadioButton2Clicked() throws InterruptedException {
		
		WebElement radio2 = driver.findElement(By.id("female"));
		assertEquals(true, radio2.isDisplayed());
		assertEquals(true, radio2.isEnabled());
		
		// select a radio button
		radio2.click();
		Thread.sleep(3000);		
		assertEquals(true, radio2.isSelected());
		
	}
}
