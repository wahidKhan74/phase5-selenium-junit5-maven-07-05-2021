package com.webapp.test.external.webelement;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

class AlertTest {

	final String siteURL = "file:///C:/Users/HOME/Desktop/Siimplilearn/FS-workpsace/phase5-selenium-junit5-maven-07-05-2021/static/external-web-element.html";
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
	@DisplayName("Alert Test :  simple  alert window ")
	void testSimpleAlertDailogWindow() throws InterruptedException {
		// find and open alert
		WebElement alertButton = driver.findElement(By.cssSelector("body > p:nth-child(2) > button"));
		alertButton.click();
		
		// switch to alert window
		Alert alert = driver.switchTo().alert();
		assertEquals("Are you sure !", alert.getText());
		Thread.sleep(3000);
		alert.accept();
	}
	
	@Test
	@DisplayName("Confirmation Test  OK:  confimation  alert window ")
	void testConfirmationAlertDailogWindow() throws InterruptedException {
		// find and open alert
		WebElement confirmButton = driver.findElement(By.cssSelector("body > p:nth-child(4) > button"));
		confirmButton.click();
		
		// switch to alert window
		Alert alert = driver.switchTo().alert();
		assertEquals("Press a button !", alert.getText());
		Thread.sleep(3000);
		// confirmation with ok button click
		alert.accept();
	}
	
	@Test
	@DisplayName("Confirmation Test  Cancel:  confimation  alert window ")
	void testConfirmationAlertDailogWindowWithCancel() throws InterruptedException {
		// find and open alert
		WebElement confirmButton = driver.findElement(By.cssSelector("body > p:nth-child(4) > button"));
		confirmButton.click();
		
		// switch to alert window
		Alert alert = driver.switchTo().alert();
		assertEquals("Press a button !", alert.getText());
		Thread.sleep(3000);
		// confirmation with cancel button click
		alert.dismiss();
	}
	
	
	@Test
	@DisplayName("Prompt Test  Ok:  prompt  alert window ")
	void testPromptAlertDailogWindowWithOK() throws InterruptedException {
		// find and open alert
		WebElement promptButton = driver.findElement(By.cssSelector("body > p:nth-child(6) > button"));
		promptButton.click();
		
		// switch to alert window
		Alert alert = driver.switchTo().alert();
		assertEquals("Please enter your name", alert.getText());
		alert.sendKeys("Iron Man");
		Thread.sleep(3000);
		// confirmation with cancel button click
		alert.accept();
	}
	

}
