package com.lua.webbuyer.utils;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestResult;

public class getScreenshot {
	
	private static String destino = System.getProperty("user.dir")+ "/Test-Screenshots/"; ; 
	private static final DateFormat dateFormat = new SimpleDateFormat("yyyy_MM_dd sss");
	
	public static String Capture(String screenshotName) throws IOException{
		
			TakesScreenshot ts = (TakesScreenshot)Driver.driver;
			String dest = System.getProperty("user.dir")+ "/Test-Screenshots/" + screenshotName + ".png";
			
			File source = ts.getScreenshotAs(OutputType.FILE);
			
			File destination = new File(dest);
			FileUtils.copyFile(source, destination);
			
			return dest;
		
	}
	
	public static String generateFileName(ITestResult result) {
		
		Date date = new Date();
		String fileName = result.getName()+ "-" + dateFormat.format(date);
		return fileName;
	}
	
	
	public static void cleanEvidences(){
		try {
			File shot = new File(getScreenshot.destino);
			FileUtils.cleanDirectory(shot);
		}catch(Exception e) {
			
		}
	}

}
