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
	
	private static String dest; 
	private static final DateFormat dateFormat = new SimpleDateFormat("yyyy_MM_dd sss");
	
	public static String Capture(String screenshotName) throws IOException{
		
			TakesScreenshot ts = (TakesScreenshot)Driver.driver;
			getScreenshot.dest = System.getProperty("user.dir")+ "/Test-Screenshots/" + screenshotName + ".png";
			getScreenshot.cleanEvidences();
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
	
	
	private static void cleanEvidences(){
		try {
			File shot = new File(getScreenshot.dest);
			FileUtils.cleanDirectory(shot);
		}catch(Exception e) {
			
		}
	}

}
