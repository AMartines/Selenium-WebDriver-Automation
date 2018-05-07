package com.lua.webbuyer.test;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.lua.webbuyer.actions.ActionsBuyer;
import com.lua.webbuyer.extent.reports.DummyForExReport;
import com.lua.webbuyer.page.LoginPage;
import com.lua.webbuyer.param.BuyerParams;
import com.lua.webbuyer.utils.Driver;





public class TestLoginPage extends DummyForExReport {

	// @Parameters({"Browser"})
	// @BeforeClass//(alwaysRun = true)
	// public void setupClass(String browser) {
	// Driver.initializeTest(browser);
	// }
	//
	
	 
	
	@AfterTest // (alwaysRun = true)
	public void endSession() {
		Driver.finalyzeClass();
	} 

	@Test
	@Parameters({ "Browser", "Product" })
	public void testeCompradois(String browser, String product) {
		
		BuyerParams.setCep("03279120");
		BuyerParams.setNumeroEndereço("52");
		BuyerParams.setTelefone("11958657895");

		ActionsBuyer actions = new ActionsBuyer(Driver.driver);
		actions.productBuy(product);

	}
	
	
	
}
