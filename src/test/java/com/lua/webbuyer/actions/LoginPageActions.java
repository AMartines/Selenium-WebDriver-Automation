package com.lua.webbuyer.actions;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.lua.webbuyer.extent.reports.ReportExtent;
import com.lua.webbuyer.page.HomePage;
import com.lua.webbuyer.page.LoginPage;
import com.lua.webbuyer.param.LoginParams;
import com.lua.webbuyer.utils.Common;

public class LoginPageActions {

	private WebDriver driver;
	private Common common;
	private HomePage homePage;
	private LoginPage loginPage;
	private ReportExtent LOG;

	public LoginPageActions(WebDriver driver) {

		this.common = new Common(driver);
		this.loginPage = new LoginPage(driver);
		this.homePage = new HomePage(driver);
		this.LOG = new ReportExtent();
	}

	public void createAccount(){

		try {
			String URL = LoginParams.getURL();
			String nome = LoginParams.getNome();
			String email = LoginParams.getEmail();
			String cpf = LoginParams.getCpf();
			String senha = LoginParams.getPassword();

			loginPage.getURL(URL);
			common.reachLoginPage();
			loginPage.setFieldName(nome);
			loginPage.setFieldEmailCadastro(email);
			loginPage.setFieldCpf(cpf);
			loginPage.setSenhaCadastroField(senha);
		} catch (Exception e) {
			Assert.fail(e.getMessage());

		}

	}
}
