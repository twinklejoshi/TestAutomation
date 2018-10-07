package com.base.realtor;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePageObject<T> {

	protected WebDriver driver;
	protected WebDriverWait wait;
	//protected WebElement element;

	protected BasePageObject(WebDriver driver/* , WebElement element */ ) {
		this.driver = driver;
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		// wait = new WebDriverWait(driver, 40);
		// element=wait.until(ExpectedConditions.visibilityOf(element));
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
		Thread.sleep(2000);
	}
}