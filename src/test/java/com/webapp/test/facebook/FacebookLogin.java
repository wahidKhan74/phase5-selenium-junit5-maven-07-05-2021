package com.webapp.test.facebook;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

class FacebookLogin {

	final String siteURL = "https://www.facebook.com/";
	final String driverPath = "drivers/chromedriver";
	WebDriver driver;
	WebDriverWait wait;

	@BeforeEach
	void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", driverPath);
		driver = new ChromeDriver();
		// explicit wait : explicit wait is used to tell the web driver to wait for a certain condition 
		// or maximum time to be exceeded before throwing " Element Not Visible exception"
		wait = new WebDriverWait(driver, 20);
		driver.get(siteURL);
	}

	@AfterEach
	void tearDown() throws Exception {
		driver.close();
	}

	@Test
	@DisplayName("Facebook Login Test")
	void testFacebookLoginFailure() {
		driver.findElement(By.cssSelector("#email")).sendKeys("abcd@gmail.com");
		driver.findElement(By.xpath("//*[@id=\"pass\"]")).sendKeys("abcd@123");
		driver.findElement(By.name("login")).submit();	
		
		WebElement errorMsg = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#error_box > div.fsl.fwb.fcb")));
		assertEquals("Wrong Credentials", errorMsg.getText());
		
		WebElement errorMsg2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"error_box\"]/div[2]")));
		assertEquals("Invalid username or password", errorMsg2.getText());
	}

}
