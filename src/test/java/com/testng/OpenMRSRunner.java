package com.testng;


import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.base.Base_Class;
import com.listeners.ExtentReport_Test;
import com.listeners.ITestListenerClass;
import com.pageobjectmanager.PageObjectManagerMRS;


@Listeners(ITestListenerClass.class)
public class OpenMRSRunner extends Base_Class {

	PageObjectManagerMRS pageObjectManager = new PageObjectManagerMRS();

	@BeforeMethod  
	public void setUp() throws Throwable {
		launchBroswer(pageObjectManager.getFileReader().getDataProperty("browser"));
	}

	@Test
	public void validLogin() throws Throwable {
		
		ExtentReport_Test.extenttest = extentReports.createTest("Login Test" + " " + Thread.currentThread().getStackTrace()[1].getMethodName().toString()).info("ValidLogin");
		Assert.assertTrue(pageObjectManager.getLoginPage().validLogin(ExtentReport_Test.extenttest));
		
	}

	@AfterMethod 
	public void terminate() {
		terminateBrowser();

	}
	@BeforeSuite
	private void extendReportStartup() {
		extentReportStart("C:\\Users\\USER\\eclipse-workspace\\OctoberProject\\open mrs report");

	}
	
	@AfterSuite
	private void extentReportEnd() throws IOException {
		
		extentReportTearDown("C:\\Users\\USER\\eclipse-workspace\\OctoberProject\\open mrs report\\index.html");

	}
}
