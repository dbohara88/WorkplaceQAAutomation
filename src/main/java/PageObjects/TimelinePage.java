package PageObjects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AbstractComponent.AbstractComponent;

public class TimelinePage extends AbstractComponent{
	
	WebDriver driver;

	public TimelinePage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	// Org chart "//a[text()='Org Chart']" //li/div //div/span/a[contains(@href, '/work/org/')]
	@FindBy(xpath = "//li/div //div/span/a[contains(@href, '/work/org/')]") 
	WebElement orgchart;
	
	@FindBy(xpath = "//a/h2/span[text()='About']")
	WebElement hover;
	
	@FindBy(xpath = "//a[@aria-label='Edit profile']")
	WebElement editprofilebutton;
	
	@FindBy(xpath = "//input[@aria-label=\"Search by name\"]")
	WebElement searchbyname;
	
	@FindBy(xpath = "(//a[@class=\"x1i10hfl xjbqb8w x1ejq31n xd10rxx x1sy0etr x17r0tee x972fbf xcfux6l x1qhh985 xm0m39n x9f619 x1ypdohk xt0psk2 xe8uvvx xdj266r x11i5rnm xat24cr x1mh8g0r xexx8yu x4uap5 x18d9i69 xkhd6sd x16tdsg8 x1hl2dhg xggy1nq x1a2a7pz x1sur9pj xkrqix3 xzsf02u x1s688f\"])[1]")
	WebElement userprofile;
	
	
	public DirectoryPage orgChart(String search)
	{
		Actions a = new Actions(driver);
		
		Timeline().click();
		a.moveToElement(hover).build().perform();
		windowScrollBy();
		orgchart.click();
		movingToElement(search, searchbyname);
		Timeline().click();
		a.moveToElement(hover).build().perform();
		windowScrollBy();
		orgchart.click();
		movingToElement("aaksjdkuashduiash", searchbyname);
		Timeline().click();
		a.moveToElement(hover).build().perform();
		windowScrollBy();
		orgchart.click();
		userprofile.click();
		Timeline().click();
		a.moveToElement(hover).build().perform();
		windowScrollBy();
		orgchart.click();
		editprofilebutton.click();
		DirectoryPage directory = new DirectoryPage(driver);
		return directory;
	}
	
}
