package com.lua.webbuyer.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Driver {
	
	public static  WebDriver driver = null;
	 
	public static  WebDriver getBrowser(String browserType)
	 
		{
		if(driver == null)
		 
		{
		 
		if(browserType.equals("Firefox"))
		 
		{
			FirefoxOptions opts = new FirefoxOptions();
			opts.addArguments("-private");
		 
		WebDriverManager.firefoxdriver().setup();	
		driver = new FirefoxDriver(opts);
		 
		}
		 
		else if(browserType.equals("Chrome"))
		 
		{
			
		WebDriverManager.chromedriver().forceCache().setup();
	
		
		driver = new ChromeDriver();
		 
		}
		 
		else if(browserType.equals("IE"))
		 
		{
		 
		driver = new InternetExplorerDriver();
		 
		}
		 
		}
		return driver;
	 
	}
}
