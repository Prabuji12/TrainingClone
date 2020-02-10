package pom;

import static org.testng.Assert.assertTrue;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class HomePage {

	Actions action;
	WebDriver chromeDriver;
	

	public HomePage(WebDriver chromeDriver, Actions action) {

		this.chromeDriver = chromeDriver;
		this.action = action;
		
		PageFactory.initElements(chromeDriver, this);

	}

	@FindBy(xpath = "//a[@id='navbtn_references']")
	WebElement referenceMenuLink;

	public void clickReferenceMenuLink() {
		referenceMenuLink.click();
	}

	public void rightClickReferenceMenuLink() {
		action.contextClick(referenceMenuLink).build().perform();
	}

	@FindBy(xpath = "//div[@class='w3-col l3 m6']/a[text()='Java Reference']")
	WebElement javaReferenceLink;

	public void rightClickJavaReferenceLink() {
		action.contextClick(javaReferenceLink);
	}

	@FindBy(xpath = "(//a[text()='LEARN SQL'])[1]")
	public WebElement learnSqlButtonLink;

	public void clickLearnSqlButtonLink() {
		learnSqlButtonLink.click();
		WebElement wait = (WebElement) new WebDriverWait(chromeDriver, 10)
				.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("")));
		chromeDriver.navigate().refresh();
		
	}

	public void moveToLearnSqlButtonLink() {
		action.moveToElement(learnSqlButtonLink);
	}
	
	
	

}
