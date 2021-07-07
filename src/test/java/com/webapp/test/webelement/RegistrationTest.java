package com.webapp.test.webelement;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class RegistrationTest {
	
	final String siteURL = "file:///home/wahidkhan74gmai/FS-Workspace/phase5-selenium-junit5-maven-07-05-2021/static/registration.html";
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
//		driver.close();
	}
	
	@Test
	void test() {
		// TODO : WAT for Registration 
	}
}
