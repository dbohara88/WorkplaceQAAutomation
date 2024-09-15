package PageObjects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AbstractComponent.AbstractComponent;

public class SerpPage extends AbstractComponent{

	WebDriver driver;
	
	public SerpPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//h1/span/span[contains(text(),'Results for ')]")
	WebElement serpResult;
	
	@FindBy(xpath="//input[@aria-label=\"Most Recent First\"]")
	WebElement mostRecentButton;
	
	@FindBy(xpath="//input[@aria-label=\"Only Posts You've Seen\"]")
	WebElement onlyPostSeenButton;
	
	@FindBy(xpath="(//div[@class='xnfveip'])[1]")
	WebElement postedBy;
	
	@FindBy(xpath="//span[text()=\"You\"]")
	WebElement postedByYou;
	
	@FindBy(xpath="//div[@class='xnfveip'])[2]")
	WebElement postedInGroup;
	
	@FindBy(xpath="//*[text()='Your Groups']")
	WebElement postedInGroupYourGroups;
	
	@FindBy(xpath="//div[@class='xnfveip'])[3]")
	WebElement Date;
	
	@FindBy(xpath="//*[text()='2024']")
	WebElement DateSelect;
	
	@FindBy(xapth="//input[@aria-label='Hide Comments']")
	WebElement
	
	public void serpAllResult(String search)
	{
		Actions a = new Actions(driver);
		a.moveToElement(SearchBar()).click().sendKeys(search, Keys.chord(Keys.ENTER)).build().perform();
		mostRecentButton.click();
		onlyPostSeenButton.click();
		postedBy.click();
		postedByYou.click();
		postedInGroup.click();
		postedInGroupYourGroups.click();
		Date.click();
		DateSelect.click();
		
	}
	
	public String serpAllResultValue()
	{
		String[] r0 = serpResult.getText().split("\""); // (Results for "), (test")
		String[] r1 = r0[1].split("\""); // test " 
		return r1[0].trim(); // test
	}
	

}
