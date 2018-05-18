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

	// Efetua login no webbuyer
	public void performLogin(String URL, String user, String password) throws Exception {

		this.getURL(URL);
		common.reachLoginPage();
		this.userFieldSet(user);
		this.passwordFieldSet(password);
		this.submitButton();
		common.loadingWait(driver);
	}
	
	public void getURL(String URL){
		Driver.getURL(URL);
	}

	public void userFieldSet(String user) throws Exception {
		try {
			actions.setText(By.xpath(".//*[@id='page-wrap']/div[3]/div[2]/div[2]/div[1]/div/div/form/div[1]/div/input"),
					user);
		} catch (Exception e) {
			throw new Exception("Campo 'Usuário' não encontrado!");
		}
	}

	public void passwordFieldSet(String password) throws Exception {

		try {
			actions.setText(By.xpath(".//*[@id='page-wrap']/div[3]/div[2]/div[2]/div[1]/div/div/form/div[2]/div/input"),
					password);
		} catch (Exception e) {
			throw new Exception("Campo 'Password' não encontrado!");
		}
	}

	public void setFieldName(String nome) throws Exception {

		try {
			actions.setText(By.xpath("//input[@name='name']"),
					nome);
		} catch (Exception e) {
			throw new Exception("Campo 'Nome' não encontrado!");
		}
	}
	
	public void setFieldEmail(String email) throws Exception {

		try {
			actions.setText(By.xpath("//input[@name='email']"),
					email);
		} catch (Exception e) {
			throw new Exception("Campo 'Email' não encontrado!");
		}
	}
	public void setFieldEmailCadastro(String email) throws Exception {

		try {
			actions.setText(By.xpath("//input[@placeholder='E-mail*']"),
					email);
		} catch (Exception e) {
			throw new Exception("Campo 'Email' não encontrado!");
		}
	}
	public void setFieldCpf(String cpf) throws Exception {

		try {
			actions.setText(By.xpath("//input[@name='cpf']"),
					cpf);
		} catch (Exception e) {
			throw new Exception("Campo 'CPF' não encontrado!");
		}
	}
	
	public void setSenhaCadastroField(String senha) throws Exception {

		try {
			actions.setText(By.xpath("//input[@placeholder='Senha*']"),
					senha);
		} catch (Exception e) {
			throw new Exception("Campo 'Senha Cadastro' não encontrado!");
		}
	}
	
	
	
	public void submitButton() throws Exception {

		try {
			actions.click(By.xpath(".//button[text()[contains(.,'Entrar')]]"));
		} catch (Exception e) {
			throw new Exception("Campo 'Submit' não encontrado!");
		}
	}

}
