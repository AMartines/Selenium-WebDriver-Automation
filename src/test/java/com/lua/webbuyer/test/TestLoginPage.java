package com.lua.webbuyer.test;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.lua.webbuyer.page.LoginPage;
import com.lua.webbuyer.utils.Driver;





public class TestLoginPage {

	


//	@Parameters({"Browser","URL"})
//	@BeforeClass
//	public void setupClass(String browser, String URL) {
//		Driver.initialyzeTest(browser, URL);
//	}
	
	@AfterClass
	public void endSession() {
		Driver.finalyzeTest();
	}
	
	
//	@Test//(description="Simula duas compras seguidas pelo WebBuyerBuyer.")
//	@Parameters({"Browser","URL", "password", "user"})
//	public void testingBuyer(String browser, String URL, String UserOK, String PasswordOK){
//		Driver.initialyzeTest(browser, URL);
//		LoginPage login = new LoginPage(Driver.driver);
//		login.performLogin(UserOK, PasswordOK);
//		
//		
//	}
	
	
	
}
