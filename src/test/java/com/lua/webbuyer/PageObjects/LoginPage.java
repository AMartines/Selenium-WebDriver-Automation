package com.lua.webbuyer.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

import com.lua.webbuyer.utils.Common;
import com.lua.webbuyer.utils.Selenium;

public class LoginPage {

	
	public WebDriver driver;
	public Selenium actions;
	public Common common;
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		this.actions = new Selenium(driver);
		this.common = new Common(driver);
	}
	
	
	
		
	
	
		public void performLogin(String user, String password, String URL) throws NoSuchElementException{
		
			
			common.logIn();
			//Efetua Login no WebBuyer
			actions.setText(By.xpath(".//*[@id='page-wrap']/div[3]/div[2]/div[2]/div[1]/div/div/form/div[1]/div/input"), user);
			actions.setText(By.xpath(".//*[@id='page-wrap']/div[3]/div[2]/div[2]/div[1]/div/div/form/div[2]/div/input"), password);
			actions.click(By.xpath(".//button[text()[contains(.,'Entrar')]]"));
			actions.loadingWait(driver);
		}
}
