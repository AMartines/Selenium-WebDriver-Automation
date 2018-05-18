package com.lua.webbuyer.extent.reports;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.net.InetAddress;
import java.net.UnknownHostException;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.lua.webbuyer.utils.Driver;
import com.lua.webbuyer.utils.getScreenshot;

public class ReportExtent {

	public static ExtentHtmlReporter htmlReporter;
	public static ExtentReports reports;
	public static ExtentTest testInfo;
	public static ExtentTest parentTest;
	public static ExtentTest childTest;
	
	@BeforeSuite(alwaysRun = true)
	public void setup() throws UnknownHostException {
		
		htmlReporter = new ExtentHtmlReporter(new File(System.getProperty("user.dir") + "/test-output" +"/LuaReports.html"));
		htmlReporter.loadXMLConfig(new File(System.getProperty("user.dir") + "/extent-config.xml"));
		reports = new ExtentReports();
		reports.setSystemInfo("Environment", InetAddress.getLocalHost().getHostName());
		reports.setSystemInfo("Environment", System.getProperty("user.name"));
		reports.attachReporter(htmlReporter);
	}
 

	@Parameters({ "Browser"})
	@BeforeMethod(alwaysRun = true)
	public void register(Method method, String browser) {
		//method.assignAuthor("AuthorName");
		String testName = method.getName(); 
		
		Test test = method.getAnnotation(Test.class);
	    String desc = test.description();
	    String[] groupInfo = test.groups();
	    
	    
		testInfo = reports.createTest(testName, desc);
		testInfo.assignCategory(groupInfo);
		testInfo.assignAuthor("Author: André Martines");
		//testInfo.assignCategory("");
				
		testInfo.log(Status.INFO, "Iniciando " + testName);
		Driver.initialyzeTest(browser);
	}
	
	
	public void loggerInfo(String LOG) {
		testInfo.log(Status.INFO, LOG);
	}
	
	public void loggerFail(String LOG) {
		testInfo.log(Status.FAIL, LOG);
	}
	
	public void loggerPass(String LOG) {
		testInfo.log(Status.PASS, LOG);
	}

	@AfterMethod(alwaysRun = true)
	public void getResult(ITestResult result) throws IOException {
		String screenshotPath = getScreenshot.Capture(getScreenshot.generateFileName(result)) ; 
		
		if (result.getStatus() == ITestResult.SUCCESS) {
			//testInfo.log(Status.PASS, "Test: " + result.getName() + " PASS");
			testInfo.addScreenCaptureFromPath(screenshotPath);

			testInfo.log(Status.PASS, MarkupHelper.createLabel("Test: " + result.getName() + " PASS", ExtentColor.GREEN));
			Driver.finalyzeTest();
			
		} else if (result.getStatus() == ITestResult.FAILURE) {
			
			//String screenshotPath = getScreenshot.Capture("screenshotForExtentReport");
			testInfo.addScreenCaptureFromPath(screenshotPath);
			
			
			testInfo.log(Status.FAIL, MarkupHelper.createLabel("Test: " + result.getName() + " FAILED", ExtentColor.RED));
			testInfo.log(Status.FAIL, result.getThrowable()); 
			Driver.finalyzeTest();
			
		} else if (result.getStatus() == ITestResult.SKIP) {
			testInfo.log(Status.SKIP, MarkupHelper.createLabel("Test: " + result.getName() + " SKIPED", ExtentColor.YELLOW));
			testInfo.log(Status.SKIP, "Test Failure: " + result.getThrowable());
			Driver.finalyzeTest();
		}
	}

	@AfterSuite(alwaysRun = true)
	public void cleanUp() {
		reports.flush();
	}

}
