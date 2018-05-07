package com.lua.webbuyer.page;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;

import com.lua.webbuyer.param.LoginParams;
import com.lua.webbuyer.utils.Common;
import com.lua.webbuyer.utils.Driver;
import com.lua.webbuyer.utils.Selenium;

public class LoginPage {

	
	private WebDriver driver;
	private Selenium actions;
	private Common common;
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		this.actions = new Selenium(driver);
		this.common = new Common(driver);
	
	}
	
	
	
		
	 
	//Efetua login no webbuyer
		public void performLogin(String URL, String user, String password) throws Exception{
			
			
			
			Driver.getURL(URL);
			common.reachLoginPage();
			actions.setText(By.xpath(".//*[@id='page-wrap']/div[3]/div[2]/div[2]/div[1]/div/div/form/div[1]/div/input"), user);
			actions.setText(By.xpath(".//*[@id='page-wrap']/div[3]/div[2]/div[2]/div[1]/div/div/form/div[2]/div/input"), password);
			actions.click(By.xpath(".//button[text()[contains(.,'Entrar')]]"));
			actions.loadingWait(driver);
		}
}
