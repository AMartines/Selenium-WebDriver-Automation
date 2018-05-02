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

public class Actions{
	
	private WebDriver driver;
	public FluentWait<WebDriver> wait;
	
	public Actions(WebDriver driver) {
		this.driver = driver;
		
		this.wait = new FluentWait<WebDriver>(driver)
				.withTimeout(30, TimeUnit.SECONDS)
				.pollingEvery(1, TimeUnit.SECONDS).ignoring(NoSuchElementException.class)
				.ignoring(StaleElementReferenceException.class);
	//homologation.click(By.xpath"")
		
	}

	public void click(By Locator) {
			try {
			wait.until(ExpectedConditions.presenceOfElementLocated(Locator));
			wait.until(ExpectedConditions.visibilityOfElementLocated(Locator));
			wait.until(ExpectedConditions.elementToBeClickable(Locator)).click();
			}catch(NoSuchElementException e) {
				System.out.println("O botão '"+ "' não foi encontrado" + e.getMessage());
			}catch(TimeoutException g) {
				System.out.println("Tempo limite estourado ao procurar o  botão '"+ "'" + g.getMessage());
			}
	}
	
	public void setText(By Locator, String text) {
		wait.until(ExpectedConditions.elementToBeClickable(Locator)).click();
		wait.until(ExpectedConditions.elementToBeClickable(Locator)).clear();
		wait.until(ExpectedConditions.elementToBeClickable(Locator)).sendKeys(text);
		
	}
	public void menuDropdown(By selector, String value) {
		final Select dropDown = new Select(driver.findElement(selector));
		dropDown.selectByValue(value);
	}

	public void waitForPageLoad() {
		wait.until(ExpectedConditions.invisibilityOfElementLocated
		(By.xpath(".//div[@class='sk-double-bounce sk-spinner source-components-Loading-___Loading__spinner___dEAFF']")));
	}
	
	public void loadingWait(WebDriver driver) {
		WebElement loader = driver.findElement(By.xpath(".//div[@class='sk-double-bounce sk-spinner source-components-Loading-___Loading__spinner___dEAFF']"));
	    WebDriverWait wait = new WebDriverWait(driver, 5000L);
	    //wait.until(ExpectedConditions.visibilityOf(loader)); // wait for loader to appear
	    wait.until(ExpectedConditions.invisibilityOf(loader)); // wait for loader to disappear
		}
	
	
	
	
}
