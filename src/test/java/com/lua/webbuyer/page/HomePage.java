package com.lua.webbuyer.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.lua.webbuyer.utils.Selenium;

public class HomePage {
	
		private Selenium selenium;
		private WebDriver driver;
		
		public HomePage(WebDriver driver) {
			this.selenium = new Selenium(driver);
			this.driver = driver;
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
		
		public String validateLogin() throws Exception {
			String email;
			try {
				email = driver.findElement(By.xpath("//span[@class = 'source-components-SideMenu-___SideMenu__side-menu__user-email___KLOhf']")).getText().toString();
				return email;
			}catch(Exception e) {
				throw new Exception("Nenhum usuário logado no momento!"); 
			}
			
		}
		
}
