package com.lua.webbuyer.param;

public class BuyerParams {
	
	public static String cep;
	public static String numeroEndereço;
	public static String telefone;
	public static boolean ufTest;
		
	
	

	public static boolean getUfTest() {
		return ufTest;
	}

	public static void setUfTest(boolean setUF) {
		BuyerParams.ufTest = setUF;
	}

	public static String getTelefone() {
		return telefone;
	}

	public static void setTelefone(String telefone) {
		BuyerParams.telefone = telefone;
	}

	public static String getCep() {
		return cep;
	}

	public static void setCep(String cep) {
		BuyerParams.cep = cep;
	}

	public static String getNumeroEndereço() {
		return numeroEndereço;
	}

	public static void setNumeroEndereço(String numeroEndereço) {
		BuyerParams.numeroEndereço = numeroEndereço;
	}
	
	
	
	
	
}
