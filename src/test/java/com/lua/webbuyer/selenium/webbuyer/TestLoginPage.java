package com.lua.webbuyer.selenium.webbuyer;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.lua.webbuyer.PageObjects.LoginPage;
import com.lua.webbuyer.utils.Driver;





public class TestLoginPage {

	


	@Parameters({"Browser","URL"})
	@BeforeClass
	public void setupClass(String browser, String URL) {
		Driver.initializeTest(browser, URL);
	}
	
	@AfterClass
	public void endSession() {
		Driver.finalizeTest();
	}
	
	
	@Test//(description="Simula duas compras seguidas pelo WebBuyerBuyer.")
	@Parameters({"password", "user", "URL"})
	public void testingBuyer(String PasswordOK, String UserOK, String URL){
		LoginPage login = new LoginPage(Driver.driver);
		login.performLogin(PasswordOK, UserOK, URL);
		
		
	}
	
	
	
}
