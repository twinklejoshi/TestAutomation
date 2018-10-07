package com.base.realtor;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

	protected WebDriver driver;
	String webUrl = "https://www.realtor.com";

	@BeforeMethod
	public void initializeSettings() {
		System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get(webUrl);
		driver.manage().window().maximize();
	}

	@AfterMethod
	public void testCleanUp() {
		driver.quit();
	}
}