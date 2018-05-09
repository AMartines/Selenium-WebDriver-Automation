package com.lua.webbuyer.utils;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class getScreenshot {
	private static String dest; 
	
	public static String Capture(String screenshotName) throws IOException{
		
			TakesScreenshot ts = (TakesScreenshot)Driver.driver;
			getScreenshot.dest = System.getProperty("user.dir")+ "/ErrorScreenshot/" + screenshotName + ".png";
			getScreenshot.cleanEvidences();
			File source = ts.getScreenshotAs(OutputType.FILE);
			
			File destination = new File(dest);
			FileUtils.copyFile(source, destination);
			
			return dest;
		
	}
	
	
	private static void cleanEvidences(){
		try {
			File shot = new File(getScreenshot.dest);
			FileUtils.cleanDirectory(shot);
		}catch(Exception e) {
			
		}
	}

}
