package com.lua.webbuyer.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.lua.webbuyer.utils.Common;
import com.lua.webbuyer.utils.Selenium;

public class ShippingPage {

	private Selenium selenium;
	private WebDriver driver;
	private Common common;

	public ShippingPage(WebDriver driver) {

		this.driver = driver;
		this.selenium = new Selenium(driver);
		this.common = new Common(driver);
	}
	
	public void setEstadoUf(String value) throws Exception {
		try {
			selenium.menuDropdown(By.xpath(".//select[@placeholder = '-> Estado* <-']"), value);
		}catch(Exception e) {
			throw new Exception("Não foi possivel selecionar a UF");
		}
	}

	public void setCep(String cep) throws Exception {
		try {
			selenium.setText(By.xpath(".//input[@name='cep']"), cep);
			selenium.click(By.xpath(".//input[@name='address']"));
		} catch (Exception e) {
			throw new Exception("Não foi possivel preencher o campo CEP na página de 'Shipment'!");
		}
	}

	public void setRua(String nomeRua) throws Exception {

		try {
			selenium.setText(By.xpath(".//input[@name='address']"), nomeRua);
		} catch (Exception e) {
			throw new Exception("Não foi possivel preencher o campo 'RUA' na página de 'Shipment'!");
		}
	}

	public void setNumero(String numero) throws Exception {

		try {
			selenium.setText(By.xpath(".//input[@name='number']"), numero);
		} catch (Exception e) {
			throw new Exception("Não foi possivel preencher o campo 'Número' na página de 'Shipment'!");
		}
	}

	public void setComplemento(String complemento) throws Exception {

		try {
			selenium.setText(By.xpath(".//input[@name='complement']"), complemento);
		} catch (Exception e) {
			throw new Exception("Não foi possivel preencher o campo 'Complemento' na página de 'Shipment'!");
		}

	}

	public void setBairro(String bairro) throws Exception {

		try {
			selenium.setText(By.xpath(".//input[@name='neighborhood']"), bairro);
		} catch (Exception e) {
			throw new Exception("Não foi possivel preencher o campo 'Bairro' na página de 'Shipment'!");
		}
	}

	public void setCidade(String cidade) throws Exception {

		try {
			selenium.setText(By.xpath(".//input[@name='city']"), cidade);
		} catch (Exception e) {
			throw new Exception("Não foi possivel preencher o campo 'Cidade' na página de 'Shipment'!");
		}
	}

	public void setTelefone(String telefone) throws Exception {

		try {
			selenium.setText(By.xpath(".//input[@name='telephone']"), telefone);
		} catch (Exception e) {
			throw new Exception("Não foi possivel preencher o campo 'Telefone' na página de 'Shipment'!");
		}
	}

	public void naoSabeSeuCepBtn() throws Exception {

		try {
			selenium.click(By.xpath(".//a[text()[contains(.,'Não sabe seu cep?')]]"));
		} catch (Exception e) {
			throw new Exception("Não foi possivel clicar no botão 'Não sabe o seu CEP'!");
		}
	}

	public void continuarBtn() throws Exception {

		try {
			//Thread.sleep(50000);
			selenium.jsClick(By.xpath(".//button[text()[contains(.,'Continuar')]]"));
			common.loadingWait(driver);
			//actions.jsAsyncClick(By.xpath(".//button[text()[contains(.,'Continuar')]]"));
//			if (driver.findElement(By.xpath(".//button[text()[contains(.,'Continuar')]]")).isDisplayed()) {
//			actions.click(By.xpath(".//button[text()[contains(.,'Continuar')]]"));
//			}
		} catch (Exception e) {
			throw new Exception("Não foi possivel clicar no botão 'Continuar");
		}
	}

	public void efetuarPagamentoBtn() throws Exception {
		try {
			selenium.jsClick(By.xpath(".//button[text()[contains(.,'Efetuar pagamento')]]"));
		} catch (Exception e) {
			throw new Exception("Não foi possivel clicar no botão 'Efetuar pagamento'!");
		}
	}

	public void payTypeBoleto() throws Exception {

		try {
			
			driver.switchTo().frame(driver.findElement(By.xpath("/html/body/div[3]/iframe")));
			selenium.click(
					By.xpath("//div[@class='pagarme-checkout-step']//div[@id='pagarme-checkout-boleto-button']"));
			driver.switchTo().defaultContent();
		} catch (Exception e) {
			throw new Exception("Não foi possível selecionar o metodo de pagamento 'Boleto Bancário'! ");
		}
	}
	
	public String statusCompra() throws Exception {
		try {
			selenium.wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='source-containers-Shipping-ModalInvoice-___ModalInvoice__invoice-ready___3NOrQ']")));
			String statusCompra = driver.findElement(By.xpath("//div[@class='source-containers-Shipping-ModalInvoice-___ModalInvoice__invoice-ready___3NOrQ']")).getText();
		
			return statusCompra;
		}catch (Exception e) {
			throw new Exception("Não foi possivel precisar o status da compra!");
		}
		
	}

}
