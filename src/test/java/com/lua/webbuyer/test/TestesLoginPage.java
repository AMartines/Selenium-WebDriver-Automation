package com.lua.webbuyer.test;

import org.testng.annotations.Test;

import com.lua.webbuyer.actions.LoginPageActions;
import com.lua.webbuyer.extent.reports.ReportExtent;
import com.lua.webbuyer.utils.Driver;

import junit.framework.Assert;





public class TestesLoginPage extends ReportExtent {
	

	private ReportExtent LOG = new ReportExtent();
	

	
	@Test(enabled = false, priority=0, testName = "Fluxo de Cadastro",description="Simula fluxo de cadastro completo.", groups = "Fluxo Contínuo")
	public void Fluxo_de_Cadastro() {
		
		try {	
			LoginPageActions actions = new LoginPageActions(Driver.driver);
			actions.createAccount();
			LOG.loggerPass("Cadastro Concluido!");
		}catch(AssertionError e) {
			Assert.fail("Test Failed: " + e.getMessage());
			LOG.loggerFail("Test Failed: " + e.getMessage());
			
		}
	}
	
}
