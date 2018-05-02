package com.lua.webbuyer.selenium.webbuyer;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.lua.webbuyer.PageObjects.LoginPage;
import com.lua.webbuyer.PageObjects.PurchasePage;
import com.lua.webbuyer.PageObjects.ShippingPage;
import com.lua.webbuyer.utils.Actions;
import com.lua.webbuyer.utils.Common;
import com.lua.webbuyer.utils.Driver;


public class TestBuyer {
	public LoginPage login;
	public Common common;
	public Actions actions;
	private ShippingPage shipping;
	private PurchasePage purchase;
	private WebDriver driver;
	


	@Parameters({"Browser","URL"})
	@BeforeClass
	public void setupClass(String browser, String URL) {
		driver = Driver.getBrowser(browser);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().setSize(new Dimension(1920, 1080));
		driver.get(URL);
		
		this.common = new Common(driver);
		this.actions = new Actions(driver);
		this.login = new LoginPage(driver);
		this.shipping = new ShippingPage(driver);
		this.purchase = new PurchasePage(driver);
	}
	
	public void endSession() {
		driver.quit();
	}
	
	
	@Test
	@Parameters({"user", "password", "itemToSearch", "itemColorCode", "cep", "URL"})
	public void testeCompra(String PasswordOK, String UserOK, String itemtoSearch, String colorCode, String cep, String URL){
		
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
	
	
	


