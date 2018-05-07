package com.lua.webbuyer.page;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.lua.webbuyer.extent.reports.DummyForExReport;
import com.lua.webbuyer.utils.Selenium;

import junit.framework.Assert;

public class PurchasePage {

	private WebDriver driver;
	private Selenium actions;
	private DummyForExReport LOG;

	public PurchasePage(WebDriver driver) {
		LOG = new DummyForExReport();
		this.driver = driver;
		this.actions = new Selenium(driver);
	} 

	public void comprarBtn() throws Exception {  
		actions.click(By.xpath(".//button[text()[contains(.,'Comprar')]]"));
		//if (actions.validateElementPresence(selector))
	} 

	public void finalizarCompraBtn() throws Exception {
		actions.click(By.xpath(".//button[text()[contains(.,'Finalizar Compra')]]"));
		if (driver.findElement(By.xpath(".//button[text()[contains(.,'Finalizar Compra')]]")).isDisplayed()) {
			actions.click(By.xpath(".//button[text()[contains(.,'Finalizar Compra')]]"));
		}
	}
	
	public void productColorSelectByValue(String cor) {
		actions.menuDropdown(By.xpath(".//*[@id='page-wrap']/div[3]/div/article/div[2]/div[1]/div/div/div/select"),cor);    
	}
	
	public void productSelect(String itemToBeSelected) throws Exception {
		try {
			actions.click(By.xpath("//*[@class='source-components-ProductList-ProductListItem-___ProductListItem__link___1-CWH']//*[text()='"+ itemToBeSelected +"']"));
			
		}catch(Exception e) {
			LOG.logger("Produto não encontrado: " + itemToBeSelected);
			throw new Exception ("Produto não encontrado: " + itemToBeSelected);
		}
		
	}

}
