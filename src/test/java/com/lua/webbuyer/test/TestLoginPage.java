package com.lua.webbuyer.test;

import org.fluttercode.datafactory.impl.DataFactory;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.lua.webbuyer.actions.LoginPageActions;
import com.lua.webbuyer.extent.reports.ReportExtent;
import com.lua.webbuyer.param.LoginParams;
import com.lua.webbuyer.utils.Driver;





public class TestLoginPage extends ReportExtent {

	
	private ReportExtent LOG = new ReportExtent();
	

	@Parameters({"Product" })
	@Test(description="Simula cadastro completo.", groups = "Fluxo Contínuo")
	public void Fluxo_de_Cadastro(String product) {
		
		DataFactory df = new DataFactory();
		System.out.println(df.getRandomText(20, 25));
		
		LoginParams.setSenha("123456");
		
		try {	
			LoginPageActions actions = new LoginPageActions(Driver.driver);
			actions.createAccount();
			LOG.loggerPass("Cadastro Concluido!");
		}catch(AssertionError e) {
			LOG.loggerFail("Test Failed: " + e.getMessage());
			org.testng.Assert.fail("Test Failed"); 
		}
		  
		//Driver.finalyzeTest();
	}
	
	
	
}
