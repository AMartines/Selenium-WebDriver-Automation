package com.lua.webbuyer.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.lua.webbuyer.extent.reports.ReportsExtend;
import com.lua.webbuyer.utils.Selenium;

public class ProductsPage {
	private Selenium selenium;
	private WebDriver driver;
	private ReportsExtend LOG;

	public ProductsPage(WebDriver driver) {
		this.selenium = new Selenium(driver);
		this.LOG = new ReportsExtend();

	}

	public void comprarBtn() throws Exception {
		try {
			selenium.jsClick(By.xpath(".//button[text()[contains(.,'Comprar')]]"));
			if (this.itemOutOfStock() == true) {
				throw new Exception("Item fora de estoque!");
			}
		} catch (Exception e) {

		}
	}

	public boolean itemOutOfStock() {
		try {
			driver.findElement(By.xpath(".//p[text()[contains(.,'Oops! Este produto está fora do nosso estoque')]]"));
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	public void productColorSelectByValue(String cor) throws Exception {
		try {
			selenium.menuDropdown(By.xpath(".//*[@id='page-wrap']/div[3]/div/article/div[2]/div[1]/div/div/div/select"),
					cor);
		} catch (Exception e) {
			LOG.loggerFail("Cor/Tamanho selecionado não encontrado!");
		}
	}

	public void selectQuantity(String expectedNumber) {
		WebElement selector = driver
				.findElement(By.xpath(".//*[@id='page-wrap']/section/div[2]/div[2]/div/div[2]/div/div/div/input"));
		if (selector.getAttribute("value") != expectedNumber) {
			int count = 0;
			do {

				// Decidir entre uma ds tres abordagens ps que nenhuma funcionou
				// actions.wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//button[text()[contains(.,'+')]]")));
				// actions.retryingFindClick(By.xpath(".//button[text()[contains(.,'+')]]"));
				// actions.getWhenVisible(By.xpath(".//button[text()[contains(.,'+')]]"),
				// 5000).click();
				count++;

			} while (Integer.parseInt(selector.getAttribute("value")) < Integer.parseInt(expectedNumber)
					|| count > Integer.parseInt(expectedNumber));
		}

	}

}
