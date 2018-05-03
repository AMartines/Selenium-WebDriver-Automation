package com.lua.webbuyer.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.lua.webbuyer.utils.Selenium;

public class ShippingPage {
	
	private WebDriver driver;
	private Selenium actions;
	
	public ShippingPage(WebDriver driver) {
		this.driver = driver;
		this.actions = new Selenium(driver);
	}
	
	
	
	public void setCep(String cep) {
		actions.setText(By.xpath(".//input[@name='cep']"), cep);
		actions.click(By.xpath(".//input[@name='address']"));
	}
	
	public void setRua(String nomeRua) {
		actions.setText(By.xpath(".//input[@name='address']"), nomeRua);
	}
	
	public void setNumero(int numero) {
		String text = Integer.toString(numero);
		actions.setText(By.xpath(".//input[@name='number']"),text);
	}
	
	public void setComplemento(String complemento) {
		actions.setText(By.xpath(".//input[@name='complement']"), complemento);
	}
	
	public void setBairro(String bairro) {
		actions.setText(By.xpath(".//input[@name='neighborhood']"), bairro);
	}
	
	public void setCidade(String cidade) {
		actions.setText(By.xpath(".//input[@name='city']"), cidade);
	}
	
	public void setTelefone(String telefone) {
		actions.setText(By.xpath(".//input[@name='telephone']"), telefone);
	}
	
	public void naoSabeSeuCep(){
		actions.click(By.xpath(".//a[text()[contains(.,'Não sabe seu cep?')]]"));
	}
	
	public void continuarBtn() {
		actions.click(By.xpath(".//button[text()[contains(.,'Continuar')]]"));
		if (driver.findElement(By.xpath(".//button[text()[contains(.,'Continuar')]]")).isDisplayed()) {
			actions.click(By.xpath(".//button[text()[contains(.,'Continuar')]]"));
		}
	}
	
	
	
	
}
