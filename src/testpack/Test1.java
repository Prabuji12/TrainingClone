package testpack;

import java.awt.event.KeyEvent;
import java.util.logging.Logger;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Test1 extends InitDriver{
	
	static Logger log = Logger.getLogger(Test1.class.getName());
	
	@Test(enabled=true)
	public void test1() {
		System.out.println("Hello");
		//homepage.clickReferenceMenuLink();
		homepage.rightClickReferenceMenuLink();
		robot.keyPress(KeyEvent.VK_DOWN);
		//robot.keyRelease(KeyEvent.VK_DOWN);		
		robot.keyPress(KeyEvent.VK_ENTER);		
		//robot.keyRelease(KeyEvent.VK_ENTER);
		System.out.println(homepage.learnSqlButtonLink.getText());
		//homepage.clickLearnSqlButtonLink();
		js.executeScript("arguments[0].scrollIntoView(true);",homepage.learnSqlButtonLink);
	}
	
	//@Bumblebee
	@Test
	public void phpTravels() throws InterruptedException {
		/*chromeDriver.manage().deleteAllCookies();
		phpHomePage.moveToServiceMenu();
		phpHomePage.clickServiceMenu();
		phpHomePage.openSubmenuInDiffTabs();*/
		Assert.assertTrue(true);
	}
	
	@Test
	public void test2() {
		try {
			Assert.assertTrue(true);
		}catch(Exception e) {
			log.info("Hello");
			Assert.assertTrue(false);
		}
	}
	
	@Test
	public void test3() {
		/*Actions action = new Actions(chromeDriver);
	    JavascriptExecutor js = (JavascriptExecutor) chromeDriver;
	    js.executeScript("", "");*/
		Assert.assertTrue(true);
	}
	
	@Test(dependsOnMethods= {"test3"})
	public void test4() {
		Assert.assertTrue(true);		
		
	}
	
}