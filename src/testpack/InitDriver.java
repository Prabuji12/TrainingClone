package testpack;

import java.awt.AWTException;
import java.awt.Robot;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import pom.HomePage;
import pom.PhpTravelsHomePage;
import predefined.ConstantValues;
import report.TestNGCustomReportListener;

public class InitDriver  {

	public WebDriver chromeDriver;
	public Actions action;
	public JavascriptExecutor js;
	public Robot robot;
	HomePage homepage;
	PhpTravelsHomePage phpHomePage;

	@BeforeSuite
	public void beforeSuite() throws AWTException {
		/*System.setProperty(ConstantValues.chromeDriver, ConstantValues.chromePath);
		chromeDriver = new ChromeDriver();
		chromeDriver.manage().window().maximize();
		action = new Actions(chromeDriver);
		js = (JavascriptExecutor) chromeDriver;
		robot = new Robot();
		chromeDriver.get(ConstantValues.phpTravelsUrl);
		chromeDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		homepage = new HomePage(chromeDriver, action);
		phpHomePage = new PhpTravelsHomePage(chromeDriver,action,robot);*/
	}

	@BeforeTest
	public void beforeTest() {

	}
	
	@AfterMethod
	public void afterMethod(ITestResult result) {
		//.out.println(result.getTestName()+" "+result.getStatus());
	}
	
}
