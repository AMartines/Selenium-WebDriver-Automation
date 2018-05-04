package com.lua.webbuyer.extent.reports;

import java.io.File;
import java.lang.reflect.Method;

import org.junit.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class DummyForExReport {

	public static ExtentHtmlReporter htmlReporter;
	public static ExtentReports reports;
	public static ExtentTest testInfo;
	

	@BeforeSuite(alwaysRun = true)
	public void setup() {
		htmlReporter = new ExtentHtmlReporter(new File(System.getProperty("user.dir") + "/LuaReports.html"));
		htmlReporter.loadXMLConfig(new File(System.getProperty("user.dir") + "/extent-config.xml"));
		reports = new ExtentReports();
		// SetEnvironment info
		reports.setSystemInfo("Environment", "QA");
		reports.attachReporter(htmlReporter);
	}
 
//	@Test
//	public void methodOne() {
//		Assert.assertTrue(true);
//		testInfo.log(Status.INFO, "Just Testing Reports log");
//	}
//
//	@Test
//	public void methodTwo() {
//		Assert.assertTrue(false);
//		testInfo.log(Status.INFO, "Just Testing Reports log");
//	}

	@BeforeMethod(alwaysRun = true)
	public void register(Method method) {
		String testName = method.getName();
		testInfo = reports.createTest(testName);
		testInfo.log(Status.INFO, "Starting ");
	}

	@AfterMethod(alwaysRun = true)
	public void getResult(ITestResult result) {
		if (result.getStatus() == ITestResult.SUCCESS) {
			//testInfo.log(Status.PASS, "Test: " + result.getName() + " PASS");
			testInfo.log(Status.PASS, MarkupHelper.createLabel("Test: " + result.getName() + " PASS", ExtentColor.GREEN));
			
		} else if (result.getStatus() == ITestResult.FAILURE) {
			testInfo.log(Status.FAIL, MarkupHelper.createLabel("Test: " + result.getName() + " FAIL" + " FAILED", ExtentColor.RED));
			testInfo.log(Status.FAIL, "Test Failure: " + result.getThrowable());
		} else if (result.getStatus() == ITestResult.SKIP) {
			testInfo.log(Status.SKIP, MarkupHelper.createLabel("Test: " + result.getName() + " FAIL" + " SKIPED", ExtentColor.YELLOW));
			testInfo.log(Status.SKIP, "Test Failure: " + result.getThrowable());
		}
	}

	@AfterSuite(alwaysRun = true)
	public void cleanUp() {
		reports.flush();
	}

}
