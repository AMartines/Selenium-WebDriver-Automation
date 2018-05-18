package com.lua.webbuyer.param;

import org.fluttercode.datafactory.impl.DataFactory;

import com.lua.webbuyer.utils.CpfCreator;

public class LoginParams {

	public static String URL = "http://musttest.hml.tenzen.com.br/";
	public static String user = "compradorteste@mailinator.com";
	public static String password = "123456";
	private static String senha;

	public static String getURL() {
		return URL;
	}

	public static String getUser() {
		return user;
	}

	public static String getPassword() {
		return password;
	}

	public static String getNome() {
		DataFactory df = new DataFactory();
		String nome = df.getFirstName() + " " + df.getLastName();
		return nome;
	}

	public static String getEmail() {
		DataFactory df = new DataFactory();
		String email = df.getEmailAddress();
		return email;
	}

	public static String getCpf() {
		CpfCreator gerador = new CpfCreator();
		String cpf = gerador.cpf();
		System.out.printf("CPF: %s, Valido: %s\n", cpf, gerador.isCPF(cpf));
		return cpf;
	}

	public static String getSenha() {
		return senha;
	}

	public static void setSenha(String senha) {
		LoginParams.senha = senha;
	}

}
