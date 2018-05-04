package com.lua.webbuyer.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.lua.webbuyer.utils.Selenium;

public class PurchasePage {

	private WebDriver driver;
	private Selenium actions;

	public PurchasePage(WebDriver driver) {
		this.driver = driver;
		this.actions = new Selenium(driver);
	}

	public void comprarBtn() {
		actions.click(By.xpath(".//button[text()[contains(.,'Comprar')]]"));
	}

	public void finalizarCompraBtn() {
		actions.click(By.xpath(".//button[text()[contains(.,'Finalizar Compra')]]"));
		if (driver.findElement(By.xpath(".//button[text()[contains(.,'Finalizar Compra')]]")).isDisplayed()) {
			actions.click(By.xpath(".//button[text()[contains(.,'Finalizar Compra')]]"));
		}
	}
	
	public void productColorSelectByValue(String cor) {
		actions.menuDropdown(By.xpath(".//*[@id='page-wrap']/div[3]/div/article/div[2]/div[1]/div/div/div/select"),cor);    
	}
	
	public void productSelect(String itemToBeSelected) {
		
		actions.click(By.xpath("//*[@class='source-components-ProductList-ProductListItem-___ProductListItem__link___1-CWH']//*[text()='"+ itemToBeSelected +"']"));
	}

}