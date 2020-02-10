package pom;

import static org.testng.Assert.fail;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class PhpTravelsHomePage {

	WebDriver driver;
	Actions action;
	Robot robot;

	public PhpTravelsHomePage(WebDriver driver, Actions action, Robot robot) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
		this.action = action;
		this.robot = robot;
	}

	@FindBy(xpath = "//button[@aria-describedby='Popover11']")
	WebElement serviceMenu;

	public void moveToServiceMenu() {
		action.moveToElement(serviceMenu).perform();
	}

	public void clickServiceMenu() {
		action.click(serviceMenu).perform();
	}

	@FindBys(@FindBy(xpath = "//div[@id='Popover11']/div/ul/li/a"))
	List<WebElement> serviceSubMenus;

	@FindBy(xpath = "//div[@id='Popover11']/div/ul/li[1]")
	WebElement serviceSubMenu;

	public void openSubmenuInDiffTabs() throws InterruptedException {
		/*
		 * action.contextClick(serviceSubMenu).perform(); Thread.sleep(4000);
		 * robot.keyPress(KeyEvent.VK_DOWN); Thread.sleep(4000);
		 * robot.keyPress(KeyEvent.VK_ENTER);
		 */
		for (WebElement element : serviceSubMenus) {
			action.contextClick(element).perform();
			robot.keyPress(KeyEvent.VK_DOWN);
			robot.keyPress(KeyEvent.VK_ENTER);
			Thread.sleep(2000);
			action.moveToElement(serviceMenu);
		}
		Thread.sleep(10000);

		Set<String> windows = driver.getWindowHandles();
		Iterator<String> itr = windows.iterator();
		String xpath = "//div[@id='PageContainer']//following::tbody/tr/td[text()='Attraction World']";
		while (itr.hasNext()) {
			driver.switchTo().window(itr.next());
			if (isElementPresent(xpath)) {
				System.out.println("Element present in " + driver.getTitle());
			} else
				
				System.out.println("Element not present in " + driver.getTitle());
		}		
	}	
	public boolean isElementPresent(String xpath) {
		try {
			driver.findElement(By.xpath(xpath));
		} catch (NoSuchElementException e) {
			return false;
		}
		return true;
	}

}
