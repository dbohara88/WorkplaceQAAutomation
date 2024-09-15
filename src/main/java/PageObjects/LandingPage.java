package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AbstractComponent.AbstractComponent;

public class LandingPage extends AbstractComponent{
	
	WebDriver driver;
	public LandingPage(WebDriver driver)
	{
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css = ".inputtext")
	WebElement userEmail;
	
	@FindBy(xpath = "//div/button")
	WebElement continueButton;
	
	@FindBy(xpath = "//input[@type='password']")
	WebElement userPass;
	
	@FindBy(xpath = "//div/button")
	WebElement submitButton;
	
	public void url()
	{
		driver.get("https://qaprod.workplace.com/");
	}
	
	public SearchHomePage loginApp(String email, String pass)
	{
		userEmail.sendKeys(email);
		continueButton.click();
		userPass.sendKeys(pass);
		submitButton.click();
		SearchHomePage searchhomepage = new SearchHomePage(driver);
		return searchhomepage;
		
	}
}
