package com.base;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.lang.annotation.ElementType;
import java.time.Duration;

import org.junit.*;
public abstract class Base_Class {
	
	public static WebDriver driver;

	public static ExtentReports extentReports;

	public static File file;

	static String Reset = "\u001b[0m";
	static String BrightWhite = "\u001b[37;1m";
	static String BackgroundBrightBlack = "\u001b[40;1m";
	static String Blue = "\u001b[34m";

	

	protected static WebDriver  launchBroswer(String broswerName) {
		
	try {
		if (broswerName.equalsIgnoreCase("chrome"))
		{
			driver=new ChromeDriver();
		}
		
		else if (broswerName.equalsIgnoreCase("firefox")) 
		{
			driver=new FirefoxDriver();
			}
		else if (broswerName.equalsIgnoreCase("edge")) {
			driver=new EdgeDriver();
		}
	} catch (Exception e) {
Assert.fail("ERROR:OCCUR DURING LAUNCH BROSWER");
	}	
	
		
		driver.manage().window().maximize();
		return driver;
		
		
	}
protected static WebDriver launchUrl(String url)
{
	try {
		driver.get(url);
		
	} catch (Exception e) {
		Assert.fail("ERROR:OCCUR DURING LAUNCH URL");
	}
	return driver;
	
}

protected static void closebroswer()
{
	try {
		driver.close();
	} catch (Exception e) {
		Assert.fail("ERROR:OCCUR DURING CLOSE BROSWER");
	}
}

protected static void validation(String actual, String excepected) {
	try {
		Assert.assertEquals(actual, excepected);
	} catch (Exception e) {

		Assert.fail("ERROR : OCCUR DURING VALIDATION");
	}
}
protected static void passInput(WebElement element,String input)
{
	try {
		element.sendKeys(input);
	} catch (Exception e) {
	Assert.fail("ERROR:OCCUR DURING  PASS INPUT");
	}
	}
protected static void pageNavigate(String Url)
{
try {
	driver.navigate().to(Url);
} 
catch (Exception e) {
	Assert.fail("ERROR:OCCUR DURING PAGENAVIGATE");
}
}

protected static void pageRefresh() {
	try {
		driver.navigate().refresh();
	} catch (Exception e) {
		Assert.fail("ERROR:OCCUR DURING  PAGE REFRESH");
	}
}
protected static void pageBack()
{
	try {
		driver.navigate().back();
	} catch ( Exception e) {
		Assert.fail("ERROR:OCCUR DURING  PAGE BACK");
		
	}
}

protected static void pageForward()
{
	try {
		driver.navigate().forward();
	} catch ( Exception e) {
		Assert.fail("ERROR:OCCUR DURING  PAGE FORWARD");
	}
}


protected static void getCurrentUrl()
{
	try {
		driver.getCurrentUrl();
	} catch (Exception e) {
		Assert.fail("ERROR:OCCUR DURING  CURRENT URL");
	}
}
protected static String getTitle()
{
	try {
		driver.getTitle();
	} catch (Exception e) {
		Assert.fail("ERROR:OCCUR DURING GET TITLE ");
	}
	return null;
}
protected static void get()
{
	try {
		driver.get(null);
	} catch (Exception e) {
		Assert.fail("ERROR:OCCUR DURING GET ");
	}
}
protected static Select DropDownObjet(WebElement element) {
	Select select =new Select(element);
	
	return select;
	
	
}
protected static void selectByVisibleText(WebElement  element ,String Text)
{
	try {
		DropDownObjet(element).selectByVisibleText(Text);
	} catch (Exception e) {
		Assert.fail("ERROR:OCCUR DURING  SELECT BY VISIBLE TEXT");
	}
}

protected static void selectByIndex(WebElement element,int num){
	try {
		DropDownObjet(element).selectByIndex(num);
	} catch (Exception e) {
		Assert.fail("ERROR:OCCUR DURING SELECT BY INDEX ");
	}
	
	
}
protected static void elementClick(WebElement element) 
{
	try {
		element.click();
	} catch (Exception e) {
		Assert.fail("ERROR:OCCUR DURING ELEMENT CLICK ");
	}
}

protected static String getText(WebElement driver)
{
	try {
	driver.getText();	
	} catch (Exception e) {
		Assert.fail("ERROR:OCCUR DURING GET TEXT  ");
	}
	return null;
}
protected static void scrollDown(int x,int y)
{try {
	JavascriptExecutor js=(JavascriptExecutor) driver;
	js.executeScript("window.scroll(" + "x + , "+ y +")");
	
} catch (Exception e) {
	Assert.fail("ERROR:OCCUR DURING  SCROLL DOWN");
	
}
}
protected static void scrollUp(int x,int y)
{
	try {
	JavascriptExecutor js=(JavascriptExecutor) driver;
	js.executeScript("window.scroll(" + "x + , "+ y +")");
}
	catch (Exception e) {
		Assert.fail("ERROR:OCCUR DURING  SCROLL UP");
			}
	}
protected static void getScreenShot(String valueby_png)

{
	TakesScreenshot screenshot = new ChromeDriver();
    File source=screenshot.getScreenshotAs(OutputType.FILE);
    File store=new File("C:\\Users\\USER\\eclipse-workspace\\MavenProject\\Screenshot");
    try {
		FileHandler.copy(source, store);
	} catch (Exception e) {
		Assert.fail("ERROR:OCCUR DURING SCREENSHOT");
	}
	

}

protected static String getAttribute(WebElement element, String input) {
	try {
		return element.getAttribute(input);
	} catch (Exception e) {
		Assert.fail("ERROR : OCCURED DURING WINDOWS HANDLES");
		return null;
	}
}

protected static void threadSleep(int seconds) {
	try {
		Thread.sleep(seconds);
	} catch (Exception e) {
		Assert.fail("ERROR : OCCURED DURING IMPLICIT WAIT");
	}
}

protected static void implicitlyWait(int seconds) {
	try {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(seconds));
	} catch (Exception e) {
		Assert.fail("ERROR : OCCURED DURING IMPLICIT WAIT");
	}
}

protected WebElement explicitlyWait(int second, String locator) {
	try {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(second));
		WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
	} catch (Exception e) {
		Assert.fail("ERROR : OCCURED DURING EXPLICIT WAIT");
	}
	return null;
}

protected static void clearElement(WebElement element) {
	try {
		element.clear();
	} catch (Exception e) {
		Assert.fail("ERROR : OCCURED ELEMENT CLEARED");
	}
}

protected static void closeBrowser() {
	try {
		driver.close();
	} catch (Exception e) {
		Assert.fail("ERROR : OCCURED DURING BROWSER CLOSE");
	}
}
public static void extentReportStart(String location) {
	extentReports = new ExtentReports();
	file = new File(location);
	ExtentSparkReporter sparkReporter = new ExtentSparkReporter(file);
	extentReports.attachReporter(sparkReporter);
	extentReports.setSystemInfo("OS", System.getProperty("os.name"));
	extentReports.setSystemInfo("Java Version", System.getProperty("java.version"));
}

public static void extentReportTearDown(String location) throws IOException {
	extentReports.flush();
	file = new File(location);
	Desktop.getDesktop().browse((file).toURI());
}


protected static void terminateBrowser() {
	try {
		driver.quit();
	} catch (Exception e) {
		Assert.fail("ERROR : OCCURED DURING BROWSER LAUNCH TERMINATED");
	}
}

}



