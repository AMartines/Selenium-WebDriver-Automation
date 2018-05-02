package com.lua.webbuyer.selenium.webbuyer;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import com.lua.webbuyer.PageObjects.LoginPage;
import com.lua.webbuyer.PageObjects.PurchasePage;
import com.lua.webbuyer.PageObjects.ShippingPage;
import com.lua.webbuyer.utils.Actions;
import com.lua.webbuyer.utils.Common;


public class TestBuyer {
	WebDriver driver;
	public LoginPage login;
	public Common common;
	public Actions actions;
	private ShippingPage shipping;
	private PurchasePage purchase;
	
	
	public TestBuyer(WebDriver driver) {
		this.driver = driver;
		this.common = new Common(driver);
		this.actions = new Actions(driver);
		this.login = new LoginPage(driver);
		this.shipping = new ShippingPage(driver);
		this.purchase = new PurchasePage(driver);
	}
	
	
	//@Parameters({"user", "password", "itemToSearch1"})
	public void testCompra(String PasswordOK, String UserOK, String itemtoSearch, String colorCode, String cep, String URL){
		try {
			login.performLogin(PasswordOK, UserOK, URL);
			common.searchItem(itemtoSearch);
			purchase.productSelect(itemtoSearch);
			purchase.productColorSelectByValue(colorCode);
			purchase.comprarBtn();
			//common.selectQuantity("3");
			purchase.finalizarCompraBtn();
			shipping.setCep(cep);
			actions.loadingWait(driver);
			shipping.setNumero(58);
			shipping.setTelefone("11958696969");
			shipping.continuarBtn();
			actions.loadingWait(driver);
		}catch(AssertionError e) {
			System.out.println("Teste Fail " + e.getMessage());
			Assert.fail();
		}
			
		}
	}
	
	
	


