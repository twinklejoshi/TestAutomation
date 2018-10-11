package com.base.realtor;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePageObject<T> {

	protected WebDriver driver;
	protected static WebDriverWait wait;
	protected static WebElement element;

	protected BasePageObject(WebDriver driver) {
		this.driver = driver;
	}

	public static void inputText(WebElement element, String input) {
		element.click();
		element.clear();
		element.sendKeys(input);
	}

	public void clickElement(WebElement element) {
		element.click();
	}

	public void moveToWebElement(WebElement element) {
		Actions actions = new Actions(driver);
		actions.moveToElement(element);
		actions.perform();
	}

	public void scrollToElement(WebElement element) throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript(String.format("window.scrollTo(0, %s)", element.getLocation().y - 100));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	public static WebElement GetElementAfterWait( WebDriver driver, By locator) {
		 wait = new WebDriverWait(driver, 10);
		 element=wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		return element;
	}
}