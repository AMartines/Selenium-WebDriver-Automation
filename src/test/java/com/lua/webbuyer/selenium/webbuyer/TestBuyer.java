package com.lua.webbuyer.selenium.webbuyer;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.lua.webbuyer.selenium.actions.ActionsBuyer;
import com.lua.webbuyer.utils.Driver;


public class TestBuyer {
	


	@Parameters({"Browser","URL"})
	@BeforeClass
	public void setupClass(String browser, String URL) {
		Driver.initializeTest(browser, URL);
	}
	
	@AfterClass
	public void endSession() {
		Driver.finalizeTest();
	}
	
	
	@Test
	@Parameters({"user", "password", "Product", "itemColorCode", "cep", "URL"})
	public void testeCompraSequencial(String PasswordOK, String UserOK, String itemtoSearch, String colorCode, String cep, String URL){
		ActionsBuyer actions = new ActionsBuyer(Driver.driver);
		try {
			actions.productBuy(PasswordOK, UserOK, itemtoSearch, colorCode, cep, URL);
		}catch(Exception e) {
			Assert.fail("Teste Failed: " + e.getMessage());
			System.out.println("Teste Failed: " + e.getMessage());
		}			
	}
}
	
	
	


