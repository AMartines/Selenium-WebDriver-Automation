package com.lua.webbuyer.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Common {
	WebDriver driver;
	private Actions actions;
	

	public Common(WebDriver driver) {
		this.driver = driver;
		this.actions = new Actions(driver);
	}

	public void logIn() {
		actions = new Actions(driver);
		actions.loadingWait(driver);
		actions.click(By.xpath(".//button[@class='source-components-Header-___Header__menu-trigger___3rL3X']"));
		actions.click(By.xpath(".//*[@id='outer-container']/ul/li[2]/a"));
	}

	
	public void logoutMenu() {
		actions = new Actions(driver);
		actions.click(By.xpath(".//button[@class='source-components-Header-___Header__menu-trigger___3rL3X']"));
		actions.click(By.xpath(".//*[@id='outer-container']/ul/li[4]/button"));
	}

	public void searchItem(String text) {
		actions.setText(By.xpath(".//input[@name='search']"), text);
		actions.click(By.xpath(".//button[text()[contains(.,'Buscar')]]"));
	}
	
	public void selectQuantity(String expectedNumber) {
		WebElement selector = driver.findElement(By.xpath(".//*[@id='page-wrap']/section/div[2]/div[2]/div/div[2]/div/div/div/input"));
		if (selector.getAttribute("value") != expectedNumber) {
			int count = 0;
			do {
				
		//Decidir entre uma ds tres abordagens ps que nenhuma funcionou
				//actions.wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//button[text()[contains(.,'+')]]")));
				//actions.retryingFindClick(By.xpath(".//button[text()[contains(.,'+')]]"));
				//actions.getWhenVisible(By.xpath(".//button[text()[contains(.,'+')]]"), 5000).click();
				count++;

			} while (Integer.parseInt(selector.getAttribute("value")) < Integer.parseInt(expectedNumber)
					|| count > Integer.parseInt(expectedNumber));
		}

	}

}
