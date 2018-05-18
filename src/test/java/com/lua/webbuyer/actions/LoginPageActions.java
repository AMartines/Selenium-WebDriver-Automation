package com.lua.webbuyer.actions;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import com.lua.webbuyer.extent.reports.ReportExtent;
import com.lua.webbuyer.page.HomePage;
import com.lua.webbuyer.page.LoginPage;
import com.lua.webbuyer.param.LoginParams;
import com.lua.webbuyer.utils.Common;
import com.lua.webbuyer.utils.Selenium;

public class LoginPageActions {

	private WebDriver driver;
	private Common common;
	private Selenium selenium;
	private HomePage homePage;
	private LoginPage loginPage;
	private ReportExtent LOG;

	public LoginPageActions(WebDriver driver) {
		this.driver = driver;
		this.common = new Common(driver);
		this.loginPage = new LoginPage(driver);
		this.homePage = new HomePage(driver);
		this.LOG = new ReportExtent();
		this.selenium = new Selenium(driver);
	}

	/**
	 * Inicio dos metodos de Fluxo Continuo
	 * 
	 * ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	 */
	public void createAccount() {

		try {
			String URL = LoginParams.getURL();
			String nome = LoginParams.getNome();
			String email = LoginParams.getEmail();
			String cpf = LoginParams.getCpf();
			String senha = LoginParams.getPassword();

			common.reachLoginPage(URL);
			LOG.loggerInfo("Iniciando preenchimento de dados necessários para o cadastro.");
			loginPage.setFieldName(nome);
			LOG.loggerInfo("Nome: " + nome);
			loginPage.setFieldEmailCadastro(email);
			LOG.loggerInfo("E-mail: " + email);
			loginPage.setFieldCpf(cpf);
			LOG.loggerInfo("CPF: " + cpf);
			loginPage.setSenhaCadastroField(senha);
			LOG.loggerInfo("Senha: " + senha);
			loginPage.setConfirmSenha(senha);
			LOG.loggerInfo("Campos preenchidos com sucesso. Submetendo...");
			loginPage.submitcadastro();
			LOG.loggerInfo("Validando cadastro...");
			common.loadingWait(driver);
			Thread.sleep(1000);
			common.menuClick();
			Assert.assertTrue(homePage.validateLogin().contains(email),
					"Problema na validação de cadastro de usuário: Usuário não logado com sucesso ou email preenchido nao confere com o email coletado do site.");
			Thread.sleep(1000);

		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}
	}

	/**
	 * FIM dos metodos de Fluxo Continuo
	 * 
	 * ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	 */

	/**
	 * Inicio dos metodos de teste Negativo
	 * 
	 * ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	 * @throws Exception 
	 * 
	 */
	
	public void validateEmptyFieldLogin(int node) throws Exception {
		
		String URL = LoginParams.getURL();
		common.reachLoginPage(URL);
		String expected = null;
		
		switch (node) {
		case 1:
			loginPage.fieldNameClick();
			expected = "O campo \"Nome\" é obrigatório.";
			break;
		case 2:
			loginPage.fieldEmailCadastroClick();
			expected = "O campo \"E-mail\" é obrigatório.";
			break;
		}
		
	}
	
	public void validateInvalidLogin() {
		
	}

	public void validateEmptyFieldSignup(int node) {

		try {
			String URL = LoginParams.getURL();
			common.reachLoginPage(URL);
			String expected = null;
			switch (node) {
			case 1:
				loginPage.fieldNameClick();
				expected = "O campo \"Nome\" é obrigatório.";
				break;
			case 2:
				loginPage.fieldEmailCadastroClick();
				expected = "O campo \"E-mail\" é obrigatório.";
				break;
			case 3:
				loginPage.fieldCpfClick();
				expected = "O campo \"CPF\" é obrigatório.";
				break;
			case 4:
				loginPage.fieldSenhaCadastroClick();
				expected = "O campo \"senha\" é obrigatório.";
				break;
			}
			loginPage.clickEmptyScpace();
			LOG.loggerInfo("Mensagem de aviso esperada: '" + expected + "'");
			String warning = selenium.wait
					.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//section[1]/child::div[" + node + "]/div/span[@class='source-components-RenderField-SignUp-___RenderFieldSignUp__errors___2FpmU']")))
					.getText();
			LOG.loggerInfo("Mensagem retornada pelo sistema: '" + warning + "'");
			Assert.assertTrue(warning.contains(expected),
					"Mensagem de aviso não exibida ou não confere com o esperado: '" + expected + "'");
		} catch (NoSuchElementException e) {
			Assert.fail("Não foi possivel localizar a mensagem de aviso do sistema!");
		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}
	}

	public void validateInvalidFieldSignup(int node) {

		try {
			String URL = LoginParams.getURL();
			common.reachLoginPage(URL);
			String expected = null;

			String invalidMessage = "as";
			switch (node) {
			case 1:
				loginPage.setFieldName(invalidMessage);
				expected = "Seu nome deve ter ao menos 3 caracteres.";
				break;
			case 2:
				loginPage.setFieldEmailCadastro(invalidMessage);
				expected = "E-mail inválido.";
				break;
			case 3:
				loginPage.setFieldCpf(invalidMessage);
				expected = "O campo CPF deve conter 11 caracteres.";
				break;
			}
			loginPage.clickEmptyScpace();
			LOG.loggerInfo("Mensagem de aviso esperada: '" + expected + "'");
			String warning = selenium.wait
					.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//section[1]/child::div[" + node
							+ "]/div/span[@class='source-components-RenderField-SignUp-___RenderFieldSignUp__errors___2FpmU']")))
					.getText();
			LOG.loggerInfo("Mensagem retornada pelo sistema: '" + warning + "'");
			Assert.assertTrue(warning.contains(expected),
					"Mensagem de aviso não exibida ou não confere com o esperado: '" + expected + "'");
		} catch (NoSuchElementException e) {
			Assert.fail("Não foi possivel localizar a mensagem de aviso do sistema!");
		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}
	}

	/**
	 * FIM dos metodos de teste Negativo
	 * 
	 * ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	 */
}
