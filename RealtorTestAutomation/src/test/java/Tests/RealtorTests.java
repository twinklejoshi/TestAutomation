package Tests;

import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.base.realtor.BaseTest;
import com.webpages.realtor.*;
import com.webpages.realtor.RealEstateAndHomesDetailPage.propertyFeaturesDetail;
import com.webpages.realtor.RealEstateAndHomesSearchPage.propertyFeatures;

public class RealtorTests extends BaseTest {

	@Test
	public void realtorTest() throws InterruptedException {
		// Arrange
		// Enter location {city, state} Eg: San Francisco, CA
		String location = "Morgantown, WV";
		/*
		 * Note: There are 48 items in first search result page, so enter any item
		 * number from 1 to 48 Also, make sure to select the item that has Price,
		 * Address, Beds, Baths and SQFT shown as this test will assert those properties
		 * Eg: Item 47 will fail as it doesn't have sqft shown
		 */
		String itemNumber = "4";
		int homesCount;
		HomePage homePage = new HomePage(driver);
		RealEstateAndHomesSearchPage realEstateAndHomesSearchPage;
		RealEstateAndHomesDetailPage realEstateAndHomesDetailPage;
		Map<propertyFeatures, String> propertyFromSearchPage;
		Map<propertyFeaturesDetail, String> propertyFromDetailPage;

		// Act
		// Enter address and click search
		realEstateAndHomesSearchPage = homePage.enterAddressInHomeHeaderAndClickSearch(location);
		// Determine number of items on search page
		homesCount = realEstateAndHomesSearchPage.getSearchResultCount();
		// Determine the property's features on search page
		propertyFromSearchPage = realEstateAndHomesSearchPage.getPropertyDetails(itemNumber);
		// Navigate to detail page of particular item by specifying the item number to
		// be selected
		realEstateAndHomesDetailPage = realEstateAndHomesSearchPage.selectSearchResultItem(itemNumber);
		// Determine the property's features on search page
		propertyFromDetailPage = realEstateAndHomesDetailPage.getPropertyDetails(itemNumber);

		// Assert the location shown on search box on search page and detail page is
		// same as location we specified
		Assert.assertEquals(realEstateAndHomesSearchPage.getLocation(), location);
		Assert.assertEquals(realEstateAndHomesDetailPage.getLocation(), location);
		// Assert that number of items in "[N] Homes" > 0
		Assert.assertTrue(homesCount > 0, "No results found");
		// Assert that all the property's features on search page are equal to
		// property's features on detail page
		Assert.assertEquals(propertyFromSearchPage.get(propertyFeatures.PRICE),
				propertyFromDetailPage.get(propertyFeaturesDetail.PRICE));
		Assert.assertEquals(propertyFromSearchPage.get(propertyFeatures.BEDS),
				propertyFromDetailPage.get(propertyFeaturesDetail.BEDS));
		Assert.assertEquals(propertyFromSearchPage.get(propertyFeatures.FULLBATHS),
				propertyFromDetailPage.get(propertyFeaturesDetail.FULLBATHS));
		Assert.assertEquals(propertyFromSearchPage.get(propertyFeatures.SQFT),
				propertyFromDetailPage.get(propertyFeaturesDetail.SQFT));
		Assert.assertEquals(propertyFromSearchPage.get(propertyFeatures.ADDRESS),
				propertyFromDetailPage.get(propertyFeaturesDetail.ADDRESS));
	}
}