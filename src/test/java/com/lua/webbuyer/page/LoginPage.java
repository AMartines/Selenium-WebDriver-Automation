package com.lua.webbuyer.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

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
			this.userFieldSet(user);
			this.passwordFieldSet(password);
			this.submitButton();
			common.loadingWait(driver);
		} 
		
		
		
		public void userFieldSet(String user) throws Exception {
			try {
				actions.setText(By.xpath(".//*[@id='page-wrap']/div[3]/div[2]/div[2]/div[1]/div/div/form/div[1]/div/input"), user);
			}catch(Exception e) {
				throw new Exception("Campo 'Usuário' não encontrado!");
			}
		}
		
		public void passwordFieldSet(String password) throws Exception {
			
			try {
				actions.setText(By.xpath(".//*[@id='page-wrap']/div[3]/div[2]/div[2]/div[1]/div/div/form/div[2]/div/input"), password);
			}catch(Exception e) {
				throw new Exception("Campo 'Password' não encontrado!");
			}
		}
		
		public void submitButton() throws Exception {
			
			try {
				actions.click(By.xpath(".//button[text()[contains(.,'Entrar')]]"));
			}catch(Exception e) {
				throw new Exception("Campo 'Submit' não encontrado!");
			}
		}
		
		
}
