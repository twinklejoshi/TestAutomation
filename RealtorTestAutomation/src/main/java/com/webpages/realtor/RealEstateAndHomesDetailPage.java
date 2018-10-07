package com.webpages.realtor;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.base.realtor.BasePageObject;

public class RealEstateAndHomesDetailPage extends BasePageObject<RealEstateAndHomesDetailPage> {

	protected RealEstateAndHomesDetailPage(WebDriver driver) {
		super(driver);
	}

	// region WebElements
	WebElement propertyType = driver.findElement(By.xpath(
			"(//section[@id='aj-qv-property-indicators']//div//li//div[@data-toggle='tooltip']//span[@class='font-semibold value ellipsis'])[1]"));
	WebElement price = driver.findElement(By.xpath("//div[@itemid='#offer']//span"));

	WebElement propertyDetails(int i) {
		return driver.findElement(
				By.xpath(String.format("//ul[@class='property-meta list-horizontal list-unstyled']//li[%d]//span", i)));
	}

	WebElement address = driver.findElement(By.xpath("//h2[@class='address']"));
	WebElement locationTxt = driver.findElement(By.id("searchBox"));

	// endregion

	// region Methods

	public String getAddress() {
		String s = address.getText().toString();
		s = s.replaceAll(",", "");
		return s;

	}

	public enum propertyFeaturesDetail {
		PRICE, BEDS, FULLBATHS, SQFT, ADDRESS
	}

	public Map<propertyFeaturesDetail, String> getPropertyDetails(String number) {
		Map<propertyFeaturesDetail, String> result = new HashMap<propertyFeaturesDetail, String>();
		result.put(propertyFeaturesDetail.PRICE, price.getAttribute("content").toString());
		result.put(propertyFeaturesDetail.BEDS, propertyDetails(1).getText().toString());
		result.put(propertyFeaturesDetail.FULLBATHS, propertyDetails(2).getText().toString());
		result.put(propertyFeaturesDetail.SQFT, propertyDetails(3).getText().toString());
		result.put(propertyFeaturesDetail.ADDRESS, getAddress());
		System.out.println(result);
		return result;
	}

	public String getLocation() {
		return locationTxt.getAttribute("value").toString();
	}
}
// endregion