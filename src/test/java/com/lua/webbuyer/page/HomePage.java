package com.lua.webbuyer.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.lua.webbuyer.utils.Selenium;

public class HomePage {
	
		private Selenium selenium;
		
		public HomePage(WebDriver driver) {
			this.selenium = new Selenium(driver);
		}
		
		public void searchItem(String text) throws Exception {
			try {
				selenium.setText(By.xpath(".//input[@name='search']"), text);
				selenium.click(By.xpath(".//button[text()[contains(.,'Buscar')]]"));
			}catch(Exception e) {
				throw new Exception("Não foi possivel pesquisar o item solicitado!");
			}
		}
		//*[contains(text(),'Pijama Adulto Spiderman')]
		
		public void productSelect(String itemToBeSelected) throws Exception {
			try {
				selenium.jsClick(By.xpath("//a[@class='source-components-ProductList-ProductListItem-___ProductListItem__link___1-CWH']//span[@class='source-components-ProductList-ProductListItem-___ProductListItem__text___SINqh']//*[contains(text(),'" +  itemToBeSelected + "')]"));
//				if (driver.findElement(By.xpath("//a[@class='source-components-ProductList-ProductListItem-___ProductListItem__link___1-CWH']//span[@class='source-components-ProductList-ProductListItem-___ProductListItem__text___SINqh']//*[contains(text(),'" +  itemToBeSelected + "')]")).isDisplayed()) {
//					selenium.jsClick(By.xpath("//a[@class='source-components-ProductList-ProductListItem-___ProductListItem__link___1-CWH']//span[@class='source-components-ProductList-ProductListItem-___ProductListItem__text___SINqh']//*[contains(text(),'" +  itemToBeSelected + "')]"));
//
//				}
			}catch(Exception e) {
				throw new Exception ("Produto não encontrado: " + itemToBeSelected);
			}
			
		}
		
}
