package com.lua.webbuyer.utils;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class getScreenshot {
	
	public static String Capture(String screenshotName) throws IOException {
		TakesScreenshot ts = (TakesScreenshot)Driver.driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		String dest = System.getProperty("user.dir")+ "/ErrorScreenshot/" + screenshotName + ".png";
		File destination = new File(dest);
		FileUtils.copyFile(source, destination);
		
		return dest;
		
	}

}
