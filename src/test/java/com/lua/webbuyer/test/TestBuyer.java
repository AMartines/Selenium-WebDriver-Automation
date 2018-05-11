package com.lua.webbuyer.test;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.lua.webbuyer.actions.ActionsBuyer;
import com.lua.webbuyer.extent.reports.ReportsExtend;
import com.lua.webbuyer.param.BuyerParams;
import com.lua.webbuyer.utils.Driver;

public class TestBuyer extends ReportsExtend {

	private ReportsExtend LOG = new ReportsExtend();
	
	// @Parameters({"Browser"})
	// @BeforeClass//(alwaysRun = true)
	// public void setupClass(String browser) {
	// Driver.initializeTest(browser);
	// }
	//
	
	  
//	
//	@AfterTest // (alwaysRun = true)
//	public void endSession() {
//		Driver.finalyzeClass();
//	} 

	@Parameters({ "Browser", "Product" })
	@Test(description="Simula duas compras feitas na mesma loja e com o mesmo usuário em sequência.", groups = "Testes de compra")
	public void compraSequencial(String browser, String product) {
		BuyerParams.setCep("03279120");
		BuyerParams.setNumeroEndereço("52");
		BuyerParams.setTelefone("11958657895");
		ActionsBuyer actions = new ActionsBuyer(Driver.driver);
		try {	
			actions.productBuy(product);
			LOG.loggerPass("Compra executada com sucesso!");
		}catch(AssertionError e) {
			LOG.loggerFail("Test Failed: " + e.getMessage());
			org.testng.Assert.fail("Test Failed"); 
		}
		  
		//Driver.finalyzeTest();
	}
}
