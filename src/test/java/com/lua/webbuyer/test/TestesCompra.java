package com.lua.webbuyer.test;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.lua.webbuyer.actions.BuyerActions;
import com.lua.webbuyer.param.BuyerParams;
import com.lua.webbuyer.resources.ReportExtent;
import com.lua.webbuyer.utils.Driver;

public class TestesCompra extends ReportExtent {

	private ReportExtent LOG = new ReportExtent();
	public String product = "Pijama Adulto Spiderman";
	

	@DataProvider(name = "test1")
    public Object[][] generateUF() {
     return new Object[][] {
       {product, "AC"}, {product, "AL"}, {product, "AM"}, {product, "AP"}, {product, "BA"}, 
       {product, "CE"}, {product, "DF"}, {product, "ES"}, {product, "GO"}, {product, "MA"}, 
       {product, "MG"}, {product, "MS"}, {product, "MT"}, {product, "PA"}, {product, "PB"}, 
       {product, "PE"}, {product, "PI"}, {product, "PR"}, {product, "RJ"}, {product, "RN"}, 
       {product, "RO"}, {product, "RR"}, {product, "RS"}, {product, "SC"}, {product, "SE"},
       {product, "SP"}, {product, "TO"},
     }; 
    }


	//@Parameters({"Product" })
	@Test(dataProvider = "test1", priority=0, testName = "Fluxo de compras", description="Simula uma compra em cada UF disponível.", groups = "Fluxo de Compras - Test")
	public void Fluxo_de_Compras(String product, String uf) {
		BuyerParams.setCep("03279120");
		BuyerParams.setNumeroEndereço("52");
		BuyerParams.setTelefone("11958657895");
		BuyerParams.setUfTest(true);
		BuyerActions actions = new BuyerActions(Driver.driver);
		try {	
			actions.productBuy(product, uf);
			LOG.loggerPass("Compra executada com sucesso!");
		}catch(AssertionError e) {
			LOG.loggerFail("Test Failed: " + e.getMessage());
			org.testng.Assert.fail("Test Failed"); 
		}
		  
		//Driver.finalyzeTest();
	}
}
