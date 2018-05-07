package com.lua.webbuyer.actions;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.lua.webbuyer.extent.reports.DummyForExReport;
import com.lua.webbuyer.page.LoginPage;
import com.lua.webbuyer.page.PurchasePage;
import com.lua.webbuyer.page.ShippingPage;
import com.lua.webbuyer.param.BuyerParams;
import com.lua.webbuyer.param.LoginParams;
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
	private DummyForExReport LOG;
	
	
	public ActionsBuyer(WebDriver driver) {
		this.driver = driver;
		this.common = new Common(driver); 
		this.actions = new Selenium(driver);
		this.login = new LoginPage(driver);
		this.shipping = new ShippingPage(driver);
		this.purchase = new PurchasePage(driver);
		LOG = new DummyForExReport();
	}

	public void productBuy(String Product) { 

		String user = LoginParams.getUser();
		String password = LoginParams.getPassword();
		String URL = LoginParams.getURL();
		String cep = BuyerParams.getCep();
		String numero = BuyerParams.getNumeroEndereço();
		String telefone = BuyerParams.getTelefone();

		
		try {
			LOG.logger("Executando Login com o usuário: " + user + ", na loja '" + URL + "'");
			login.performLogin(URL, user, password);
			LOG.logger("Login executado com sucesso!");
			LOG.logger("Pesquisando o produto: " + Product);
			common.searchItem(Product);
			purchase.productSelect(Product);
			// purchase.productColorSelectByValue(colorCode);
			purchase.comprarBtn();
			// common.selectQuantity("3");
			purchase.finalizarCompraBtn();
			shipping.setCep(cep);
			actions.loadingWait(driver);
			shipping.setNumero(numero);
			shipping.setTelefone(telefone);
			shipping.continuarBtn();
			actions.loadingWait(driver);
		
			
		} catch (Exception e) {
			//Driver.finalyzeTest();
			Assert.fail("Test Failed: " + e.getMessage());
		}
	}
}
