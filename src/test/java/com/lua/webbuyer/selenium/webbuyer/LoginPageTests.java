package com.lua.webbuyer.selenium.webbuyer;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.lua.webbuyer.utils.Driver;





public class LoginPageTests {

	private WebDriver driver;
	


	@Parameters({"URL"})
	@BeforeClass
	public void setupClass(String URL) {
		//Qual Browser à ser usado
		String browser ="Firefox";
		driver = Driver.getBrowser(browser);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(URL);
		System.out.println("driver 1 =" + driver);
		driver.manage().window().setSize(new Dimension(1920, 1080));
		
	}
	
	

//	@AfterClass
//	public void logoutAfterSTest() throws InterruptedException {
//		extent.flush();
//	}

	
	
	
	@Test//(description="Simula duas compras seguidas pelo WebBuyerBuyer.")
	@Parameters({"user", "password", "itemToSearch", "itemColorCode", "cep", "URL"})
	public void testingBuyer(String PasswordOK, String UserOK, String itemToSearch1, String colorCode, String cep, String URL){
		//ExtentTestManager.getTest().setDescription("Robô faz login no sistema com uma conta pré-existente e efetua duas compras consecutivas");
		TestBuyer buyer = new TestBuyer(driver);
		buyer.testCompra(PasswordOK, UserOK, itemToSearch1, colorCode, cep, URL);
		
		
	}
	
	
	
}
