package com.lua.webbuyer.utils;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Selenium{
	
	private WebDriver driver;
	public FluentWait<WebDriver> wait;
	
	public Selenium(WebDriver driver) {
		this.driver = driver;
		
		this.wait = new FluentWait<WebDriver>(driver)
				.withTimeout(30, TimeUnit.SECONDS)
				.pollingEvery(1, TimeUnit.SECONDS).ignoring(NoSuchElementException.class)
				.ignoring(StaleElementReferenceException.class);
	//homologation.click(By.xpath"")
		
	}

	public void click(By Locator) throws NoSuchElementException, TimeoutException{
			wait.until(ExpectedConditions.presenceOfElementLocated(Locator));
			wait.until(ExpectedConditions.visibilityOfElementLocated(Locator));
			wait.until(ExpectedConditions.elementToBeClickable(Locator)).click();
	}
	
	public void setText(By Locator, String text) throws NoSuchElementException, TimeoutException{
		wait.until(ExpectedConditions.elementToBeClickable(Locator)).click();
		wait.until(ExpectedConditions.elementToBeClickable(Locator)).clear();
		wait.until(ExpectedConditions.elementToBeClickable(Locator)).sendKeys(text);
		
	}
	public void menuDropdown(By selector, String value) throws NoSuchElementException, TimeoutException, NullPointerException{
		final Select dropDown = new Select(driver.findElement(selector));
		dropDown.selectByValue(value);
	}
	
	public void loadingWait(WebDriver driver) {
		try {
			WebElement loader = driver.findElement(By.xpath(".//div[@class='sk-double-bounce sk-spinner source-components-Loading-___Loading__spinner___dEAFF']"));
		    WebDriverWait wait = new WebDriverWait(driver, 5000L);
		    //wait.until(ExpectedConditions.visibilityOf(loader)); // wait for loader to appear
		    wait.until(ExpectedConditions.invisibilityOf(loader)); // wait for loader to disappear
		}catch(Exception e) {
			
		}
		}
	
	
	public  String waitForElementNotVisible(int timeOutInSeconds, WebDriver driver) {
	    if ((driver == null)) {

	        return "Wrong usage of WaitforElementNotVisible()";
	    }
	    try {
	        (new WebDriverWait(driver, timeOutInSeconds)).until(ExpectedConditions.invisibilityOfElementLocated(By
	                .xpath(".//div[@class='sk-double-bounce sk-spinner source-components-Loading-___Loading__spinner___dEAFF']")));
	        return null;
	    } catch (TimeoutException e) {
	        return "Build your own errormessage...";
	    }
	}
	
	
	
}
