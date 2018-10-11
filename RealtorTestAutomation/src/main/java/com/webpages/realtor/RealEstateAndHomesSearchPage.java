package com.webpages.realtor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import com.base.realtor.*;

public class RealEstateAndHomesSearchPage extends BasePageObject<RealEstateAndHomesSearchPage> {

	public RealEstateAndHomesSearchPage(WebDriver driver) {
		super(driver);
	}

	// region WebElements
	WebElement searchResultCount = GetElementAfterWait(driver, By.id("search-result-count"));

	WebElement resultItem(String number) {
		return GetElementAfterWait(driver, By.xpath(String.format("//li[@id='%s']//img", number)));
	}

	WebElement price(String number) {
		return GetElementAfterWait(driver, By.xpath(String.format(
				"//li[@id='%s']//div[@class='card-box js-navigate-to js-record-user-activity']//div[@class='detail-wrap ']//div//div[@class='price']//span",
				number)));
	}

	WebElement numberOfBeds(String number) {
		return GetElementAfterWait(driver, By.xpath(String.format(
				"//li[@id='%s']//div[@class='card-box js-navigate-to js-record-user-activity']//div[@class='detail-wrap ']//ul[@class='prop-meta ellipsis']//li[@data-label='property-meta-beds']//span",
				number)));
	}

	WebElement numberOfBaths(String number) {
		return GetElementAfterWait(driver, By.xpath(String.format(
				"//li[@id='%s']//div[@class='card-box js-navigate-to js-record-user-activity']//div[@class='detail-wrap ']//ul[@class='prop-meta ellipsis']//li[@data-label='property-meta-baths']//span",
				number)));
	}

	WebElement numberOfSqft(String number) {
		return GetElementAfterWait(driver, By.xpath(String.format(
				"//li[@id='%s']//div[@class='card-box js-navigate-to js-record-user-activity']//div[@class='detail-wrap ']//ul[@class='prop-meta ellipsis']//li[@data-label='property-meta-sqft']//span",
				number)));
	}

	By address(String number) {
		return By.xpath(String.format(
				"//li[@id='%s']//div[@class='card-box js-navigate-to js-record-user-activity']//div[@class='detail-wrap ']//div[@class='address ellipsis']/a/span",
				number));
	}

	WebElement locationTxt = driver.findElement(By.id("searchBox"));
	// endregion

	// region Methods
	public int getSearchResultCount() {
		String str = searchResultCount.getText().toString();
		int value = Integer.parseInt(str.replaceAll("[^0-9]", ""));
		System.out.println(value);
		return value;
	}

	public RealEstateAndHomesDetailPage selectSearchResultItem(String number) throws InterruptedException {
		scrollToElement(resultItem(number));
		clickElement(resultItem(number));
		return new RealEstateAndHomesDetailPage(driver);
	}

	public String getAddress(String number) {
		String s = "";
		ArrayList<WebElement> addressElements = new ArrayList<WebElement>(driver.findElements(address(number)));

		for (WebElement a : addressElements) {

			s = s.concat(a.getText().toString()).concat(" ");
		}
		return s.trim();
	}

	public enum propertyFeatures {
		PRICE, BEDS, FULLBATHS, SQFT, ADDRESS
	}

	public Map<propertyFeatures, String> getPropertyDetails(String number) {
		Map<propertyFeatures, String> result = new HashMap<propertyFeatures, String>();
		result.put(propertyFeatures.PRICE, price(number).getText().toString().replaceAll("[^0-9]", ""));
		result.put(propertyFeatures.BEDS, numberOfBeds(number).getText().toString());
		result.put(propertyFeatures.FULLBATHS, numberOfBaths(number).getText().toString().replaceAll("[^0-9]", ""));
		result.put(propertyFeatures.SQFT, numberOfSqft(number).getText().toString());
		result.put(propertyFeatures.ADDRESS, getAddress(number));
		System.out.println(result);
		return result;
	}

	public String getLocation() {
		return locationTxt.getAttribute("value").toString();
	}
	// endregion
}