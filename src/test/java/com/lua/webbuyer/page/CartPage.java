package com.lua.webbuyer.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.lua.webbuyer.utils.Common;
import com.lua.webbuyer.utils.Selenium;

public class CartPage {

	private WebDriver driver;  
	private Selenium selenium;
	private Common common;

//	 @FindBy(xpath = ".//i[@class='source-components-Header-___Header__cart-link-itens___zhLBi']") By fullCart;
//	 @FindBy(css = "input[name='confirmPassword']") WebElement confirmPassword;
//	 @FindBy(name = "register") WebElement register;
//	 @FindBy(linkText = "SIGN-OFF") WebElement signoff;
	
	public CartPage(WebDriver driver) {
		this.driver = driver;
		this.selenium = new Selenium(driver);
		this.common = new Common(driver);
	} 
	
	public void cleanCart() throws Exception {
		try {
			if (common.validateElementPresence(By.xpath(".//i[@class='source-components-Header-___Header__cart-link-itens___zhLBi']"))) {
				selenium.click(By.xpath(".//a[@class='source-components-Header-___Header__cart-link___10MHG']"));
				common.loadingWait(driver);
				selenium.click(By.xpath(".//button[@class='source-components-CartItem-___CartItem__close-button___18DMi']"));
				common.loadingWait(driver);
				
			}else {
				System.out.println("Carrinho vazio");
			}
		}catch(Exception e) {
			throw new Exception("Não foi possivel limpar o carrinho!");
		}
		
	}  
	 
	public void finalizarCompraBtn() throws Exception {
		
		
		try {
			selenium.click(By.xpath(".//button[text()[contains(.,'Finalizar Compra')]]"));
			if (driver.findElement(By.xpath(".//button[text()[contains(.,'Finalizar Compra')]]")).isDisplayed()) {
				selenium.click(By.xpath(".//button[text()[contains(.,'Finalizar Compra')]]"));
			}
		}catch(Exception e) {
			//throw new Exception("Não foi possivel clicar no botão 'Finalizar Compra'!" );
		}
	} 
	
	
	
	

}
