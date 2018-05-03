package com.lua.webbuyer.selenium.actions;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.lua.webbuyer.PageObjects.LoginPage;
import com.lua.webbuyer.PageObjects.PurchasePage;
import com.lua.webbuyer.PageObjects.ShippingPage;
import com.lua.webbuyer.utils.Common;
import com.lua.webbuyer.utils.Selenium;

public class ActionsBuyer {
	
	private WebDriver driver;
	private LoginPage login;
	private Common common;
	private Selenium actions;
	private ShippingPage shipping;
	private PurchasePage purchase;
	
	public ActionsBuyer(WebDriver driver) {
		this.driver = driver;
		this.common = new Common(driver);
		this.actions = new Selenium(driver);
		this.login = new LoginPage(driver);
		this.shipping = new ShippingPage(driver);
		this.purchase = new PurchasePage(driver);
	}
	
public void productBuy(String PasswordOK, String UserOK, String Product, String colorCode, String cep, String URL)throws NoSuchElementException, TimeoutException{
			login.performLogin(PasswordOK, UserOK, URL);
			common.searchItem(Product);
			purchase.productSelect(Product);
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
	}
}
