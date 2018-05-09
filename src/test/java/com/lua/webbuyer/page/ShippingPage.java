package com.lua.webbuyer.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.lua.webbuyer.utils.Selenium;

public class ShippingPage {

	private Selenium actions;
	private WebDriver driver;

	public ShippingPage(WebDriver driver) {

		this.driver = driver;
		this.actions = new Selenium(driver);
	}

	public void setCep(String cep) throws Exception {
		try {
			actions.setText(By.xpath(".//input[@name='cep']"), cep);
			actions.click(By.xpath(".//input[@name='address']"));
		} catch (Exception e) {
			throw new Exception("Não foi possivel preencher o campo CEP na página de 'Shipment'!");
		}
	}

	public void setRua(String nomeRua) throws Exception {

		try {
			actions.setText(By.xpath(".//input[@name='address']"), nomeRua);
		} catch (Exception e) {
			throw new Exception("Não foi possivel preencher o campo 'RUA' na página de 'Shipment'!");
		}
	}

	public void setNumero(String numero) throws Exception {

		try {
			actions.setText(By.xpath(".//input[@name='number']"), numero);
		} catch (Exception e) {
			throw new Exception("Não foi possivel preencher o campo 'Número' na página de 'Shipment'!");
		}
	}

	public void setComplemento(String complemento) throws Exception {

		try {
			actions.setText(By.xpath(".//input[@name='complement']"), complemento);
		} catch (Exception e) {
			throw new Exception("Não foi possivel preencher o campo 'Complemento' na página de 'Shipment'!");
		}

	}

	public void setBairro(String bairro) throws Exception {

		try {
			actions.setText(By.xpath(".//input[@name='neighborhood']"), bairro);
		} catch (Exception e) {
			throw new Exception("Não foi possivel preencher o campo 'Bairro' na página de 'Shipment'!");
		}
	}

	public void setCidade(String cidade) throws Exception {

		try {
			actions.setText(By.xpath(".//input[@name='city']"), cidade);
		} catch (Exception e) {
			throw new Exception("Não foi possivel preencher o campo 'Cidade' na página de 'Shipment'!");
		}
	}

	public void setTelefone(String telefone) throws Exception {

		try {
			actions.setText(By.xpath(".//input[@name='telephone']"), telefone);
		} catch (Exception e) {
			throw new Exception("Não foi possivel preencher o campo 'Telefone' na página de 'Shipment'!");
		}
	}

	public void naoSabeSeuCepBtn() throws Exception {
		
		try {
			actions.click(By.xpath(".//a[text()[contains(.,'Não sabe seu cep?')]]"));
		}catch(Exception e) {
			throw new Exception("Não foi possivel clicar no botão 'Não sabe o seu CEP'!");
		}
	}

	public void continuarBtn() throws Exception {

		try {
			actions.click(By.xpath(".//button[text()[contains(.,'Continuar')]]"));
			if (driver.findElement(By.xpath(".//button[text()[contains(.,'Continuar')]]")).isDisplayed()) {
				actions.click(By.xpath(".//button[text()[contains(.,'Continuar')]]"));
			}
		} catch (Exception e) {
			throw new Exception("Não foi possivel clicar no botão 'Continuar");
		}
	}

	public void efetuarPagamentoBtn() throws Exception {
		try {
			actions.click(By.xpath(".//button[text()[contains(.,'Efetuar pagamento')]]"));
		}catch(Exception e) {
			throw new Exception("Não foi possivel clicar no botão 'Efetuar pagamento'!");
		}
	}

}
