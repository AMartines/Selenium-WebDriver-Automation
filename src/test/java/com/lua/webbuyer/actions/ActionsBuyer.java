package com.lua.webbuyer.actions;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.lua.webbuyer.page.LoginPage;
import com.lua.webbuyer.page.PurchasePage;
import com.lua.webbuyer.page.ShippingPage;
import com.lua.webbuyer.utils.Common;
import com.lua.webbuyer.utils.Driver;
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

	public void productBuy(String Product) {

		try {
			login.performLogin();
			common.searchItem(Product);
			purchase.productSelect(Product);
			// purchase.productColorSelectByValue(colorCode);
			purchase.comprarBtn();
			// common.selectQuantity("3");
			purchase.finalizarCompraBtn();
			shipping.setCep();
			actions.loadingWait(driver);
			shipping.setNumero();
			shipping.setTelefone();
			shipping.continuarBtn();
			actions.loadingWait(driver);
		} catch (Exception e) {
			Driver.finalyzeTest();
			Assert.fail("Teste Failed: " + e.getMessage());
		}
	}
}
