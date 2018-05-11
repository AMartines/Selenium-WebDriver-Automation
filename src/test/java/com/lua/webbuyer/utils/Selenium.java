package com.lua.webbuyer.utils;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Selenium{
	
	private WebDriver driver;
	private JavascriptExecutor js;
	public FluentWait<WebDriver> wait;
	
	@SuppressWarnings("deprecation")
	public Selenium(WebDriver driver) {
		this.driver = driver; 
		this.js = (JavascriptExecutor)driver;
		this.wait = new FluentWait<WebDriver>(driver)
				.withTimeout(30, TimeUnit.SECONDS)
				.pollingEvery(1, TimeUnit.SECONDS).ignoring(NoSuchElementException.class)
				.ignoring(StaleElementReferenceException.class);
	}  
	
	public void jsClick(By locator) {
		WebElement button =driver.findElement(locator);
		
		wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		wait.until(ExpectedConditions.elementToBeClickable(locator));
		js.executeScript("arguments[0].click();", button);
	}
	
	public void jsAsyncClick(By locator) {
		WebElement button =driver.findElement(locator);
		
		wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		wait.until(ExpectedConditions.elementToBeClickable(locator));
		js.executeAsyncScript("arguments[0].click();", button);
	}
	 
	public void click(By Locator) throws Exception { 
		try {
			wait.until(ExpectedConditions.presenceOfElementLocated(Locator));
			wait.until(ExpectedConditions.visibilityOfElementLocated(Locator));
			wait.until(ExpectedConditions.elementToBeClickable(Locator)).click();
		}catch(Exception e ) {
			throw new Exception ("WebElement não encontrado: " + Locator );
		}

	}
	
	public void setText(By Locator, String text) throws Exception {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(Locator)).click();
			wait.until(ExpectedConditions.elementToBeClickable(Locator)).clear();
			wait.until(ExpectedConditions.elementToBeClickable(Locator)).sendKeys(text);
		}catch(Exception e ) {
			//LOG.logger("WebElement não encontrado: " + Locator );
			throw new Exception ("WebElement não encontrado: " + Locator );
		}
	}
	
	public void menuDropdown(By selector, String value) {
		try {
			final Select dropDown = new Select(driver.findElement(selector));
			dropDown.selectByValue(value); 
		}catch(Exception e ) {
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
	        return "";
	    }
	}
	
	
	
}
