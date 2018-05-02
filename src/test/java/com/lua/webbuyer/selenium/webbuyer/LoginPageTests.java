package com.lua.webbuyer.selenium.webbuyer;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.lua.webbuyer.PageObjects.LoginPage;
import com.lua.webbuyer.utils.Driver;





public class LoginPageTests {

	private LoginPage login;
	private WebDriver driver;
	


	@Parameters({"Browser","URL"})
	@BeforeClass
	public void setupClass(String browser, String URL) {
		driver = Driver.getBrowser(browser);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().setSize(new Dimension(1920, 1080));
		driver.get(URL);
		
		this.login = new LoginPage(driver);
	}
	
	

	@AfterClass
	public void endSession() {
		driver.quit();
	}

	
	
	
	@Test//(description="Simula duas compras seguidas pelo WebBuyerBuyer.")
	@Parameters({"user", "password"})
	public void testingBuyer(String PasswordOK, String UserOK, String itemToSearch1, String colorCode, String cep, String URL){
		login.performLogin(PasswordOK, UserOK, URL);
		
		
	}
	
	
	
}
