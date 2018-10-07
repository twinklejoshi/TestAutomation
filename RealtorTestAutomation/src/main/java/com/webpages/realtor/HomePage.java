package com.webpages.realtor;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import com.base.realtor.*;

public class HomePage extends BasePageObject<HomePage> {

	public HomePage(WebDriver driver) {
		super(driver);
	}

	// region WebElements
	WebElement searchTxtBox = driver.findElement(By.id("searchBox"));
	WebElement searchBtn = driver
			.findElement(By.xpath("//button[@class='btn btn-primary js-searchButton ']/span[text()='Search']"));
	// endregion

	// region Methods
	public RealEstateAndHomesSearchPage enterAddressInHomeHeaderAndClickSearch(String address) {
		inputText(searchTxtBox, address);
		clickElement(searchBtn);
		return new RealEstateAndHomesSearchPage(driver);
	}
	// endregion
}