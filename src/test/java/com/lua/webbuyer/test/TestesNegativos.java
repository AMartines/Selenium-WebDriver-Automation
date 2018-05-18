package com.lua.webbuyer.test;

import org.testng.annotations.Test;

import com.lua.webbuyer.actions.LoginPageActions;
import com.lua.webbuyer.extent.reports.ReportExtent;
import com.lua.webbuyer.utils.Driver;

import junit.framework.Assert;

public class TestesNegativos extends ReportExtent {
	

	private ReportExtent LOG = new ReportExtent();
	
	
	
	@Test(priority=2, testName = "Teste Negativo: Campo 'Nome' Invalido", description="Força a mensagem de warning no campo 'Nome' na tela de Login.", groups = "Teste Negativo")
	public void testeNomeInvalido() {
		
		try {	
			LoginPageActions actions = new LoginPageActions(Driver.driver);
			actions.verifyInvalidField(1);
			LOG.loggerPass("Warning do campo'Nome' exibido corretamente!");
		}catch(AssertionError e) {
			Assert.fail("Test Failed: " + e.getMessage());
			LOG.loggerFail("Test Failed: " + e.getMessage());
		}
	}
	
	@Test(priority=2, testName = "Teste Negativo: Campo 'E-Mail' Invalido", description="Força a mensagem de warning no campo 'E-Mail' na tela de Login.", groups = "Teste Negativo")
	public void testeEmailInvalido() {
		
		try {	
			LoginPageActions actions = new LoginPageActions(Driver.driver);
			actions.verifyInvalidField(2);
			LOG.loggerPass("Warning do campo 'E-mail' exibido corretamente!");
		}catch(AssertionError e) {
			Assert.fail("Test Failed: " + e.getMessage());
			LOG.loggerFail("Test Failed: " + e.getMessage());
		}
	}
	
	@Test(priority=2, testName = "Teste Negativo: Campo 'CPF' Invalido", description="Força a mensagem de warning no campo 'CPF' na tela de Login.", groups = "Teste Negativo")
	public void testeCpfInvalido() {
		
		try {	
			LoginPageActions actions = new LoginPageActions(Driver.driver);
			actions.verifyInvalidField(3);
			LOG.loggerPass("Warning do campo 'CPF' exibido corretamente!");
		}catch(AssertionError e) {
			Assert.fail("Test Failed: " + e.getMessage());
			LOG.loggerFail("Test Failed: " + e.getMessage());
		}
	}
	
	@Test(priority=2, testName = "Teste Negativo: Campo 'Nome' em branco", description="Força a mensagem de warning no campo 'Nome' na tela de Login.", groups = "Teste Negativo")
	public void testeNomeEmBranco() {
		
		try {	
			LoginPageActions actions = new LoginPageActions(Driver.driver);
			actions.verifyEmptyField(1);
			LOG.loggerPass("Warning do campo'Nome' exibido corretamente!");
		}catch(AssertionError e) {
			Assert.fail("Test Failed: " + e.getMessage());
			LOG.loggerFail("Test Failed: " + e.getMessage());
		}
	}
	
	@Test(priority=2, testName = "Teste Negativo: Campo 'E-Mail' em branco", description="Força a mensagem de warning no campo 'E-Mail' na tela de Login.", groups = "Teste Negativo")
	public void testeEmailEmBranco() {
		
		try {	
			LoginPageActions actions = new LoginPageActions(Driver.driver);
			actions.verifyEmptyField(2);
			LOG.loggerPass("Warning do campo 'E-mail' exibido corretamente!");
		}catch(AssertionError e) {
			Assert.fail("Test Failed: " + e.getMessage());
			LOG.loggerFail("Test Failed: " + e.getMessage());
		}
	}
	
	@Test(priority=2, testName = "Teste Negativo: Campo 'CPF' em branco", description="Força a mensagem de warning no campo 'CPF' na tela de Login.", groups = "Teste Negativo")
	public void testeCpfEmBranco() {
		
		try {	
			LoginPageActions actions = new LoginPageActions(Driver.driver);
			actions.verifyEmptyField(3);
			LOG.loggerPass("Warning do campo 'CPF' exibido corretamente!");
		}catch(AssertionError e) {
			Assert.fail("Test Failed: " + e.getMessage());
			LOG.loggerFail("Test Failed: " + e.getMessage());
		}
	}
	
	@Test(priority=2, testName = "Teste Negativo: Campo 'Senha de cadastro' em branco", description="Força a mensagem de warning no campo 'Senha de cadastro' na tela de Login.", groups = "Teste Negativo")
	public void testeSenhaCadastroEmBranco() {
		
		try {	
			LoginPageActions actions = new LoginPageActions(Driver.driver);
			actions.verifyEmptyField(4);
			LOG.loggerPass("Warning do campo 'Senha de cadastro' exibido corretamente!");
		}catch(AssertionError e) {
			Assert.fail("Test Failed: " + e.getMessage());
			LOG.loggerFail("Test Failed: " + e.getMessage());
		}
	}
}
