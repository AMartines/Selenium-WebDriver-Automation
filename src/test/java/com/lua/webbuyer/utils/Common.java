package com.lua.webbuyer.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Common {
	WebDriver driver;
	private Selenium selenium;
	

	public Common(WebDriver driver) { 
		this.driver = driver;
		this.selenium = new Selenium(driver);
	}

	
	public void getURL(String URL) throws Exception{
		try {
			Driver.getURL(URL);
		}catch(Exception e) {
			throw new Exception("A página solicitada não retornou resposta: '"+ URL +"'");
		}
	}
	
	public boolean validateElementPresence(By locator) {
		
		boolean exist = false;
		try {
			WebElement object = driver.findElement(locator); 
			if (object.isDisplayed()) {
				exist = true;
			}
		}catch(Exception e) {
			return exist;
			
		}
		return exist;
	}
	 
	public void menuClick() throws Exception {
		Thread.sleep(500);
		selenium.click(By.xpath(".//button[@class='source-components-Header-___Header__menu-trigger___3rL3X']"));
	}
	
	public void reachLoginPage(String URL) throws Exception{
		this.getURL(URL);
		try {
			this.loadingWait(driver); 
			selenium.click(By.xpath(".//button[@class='source-components-Header-___Header__menu-trigger___3rL3X']"));
			selenium.click(By.xpath(".//*[@id='outer-container']/ul/li[2]/a"));
		}catch(Exception e) {
			throw new Exception("Botão 'Menu Hamburguer' não encontrado!");
				
			
		}
	} 

	 
	public void logoutMenu() throws Exception {
		selenium.click(By.xpath(".//button[@class='source-components-Header-___Header__menu-trigger___3rL3X']"));
		selenium.click(By.xpath(".//*[@id='outer-container']/ul/li[4]/button"));
	}

	
	public void loadingWait(WebDriver driver) {
		
		
		try {
		    //WebDriverWait wait = new WebDriverWait(driver, 5000L);
		    if (driver.findElement(By.xpath(".//div[@class='source-components-Loading-___Loading__wrapper___3RmgW']")).isDisplayed()) {
		    	selenium.wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.xpath(".//div[@class='source-components-Loading-___Loading__wrapper___3RmgW']"))));
		    	//Thread.sleep(500);
			}else if (driver.findElement(By.xpath(".//div[@class='sk-double-bounce sk-spinner source-components-Loading-___Loading__spinner___dEAFF']")).isDisplayed()) {
				selenium.wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.xpath(".//div[@class='sk-double-bounce sk-spinner source-components-Loading-___Loading__spinner___dEAFF']"))));
				//Thread.sleep(500);
			}
		}catch(Exception e) {
			
		}
	}
	
	

}
