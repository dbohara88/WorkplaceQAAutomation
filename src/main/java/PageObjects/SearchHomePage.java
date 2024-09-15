package PageObjects;

import java.util.List;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import AbstractComponent.AbstractComponent;

public class SearchHomePage extends AbstractComponent{

	WebDriver driver;
	public SearchHomePage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="(//div[@class='x1yztbdb'])[1]")
	List<WebElement> searchSuggestion;
	
	@FindBy(xpath="//input[@aria-label='Profile search']")
	WebElement searchProfile;
	
	public void userCanSearch(String search)
	{
		Actions a = new Actions(driver);
		waitForWebElementToAppear(SearchBar());
		a.moveToElement(SearchBar()).click().build().perform();
		
		
		List<WebElement> searchList;
		
		//search suggestion
		searchList = searchSuggestion;
		WebElement searchResult = searchList.stream().findFirst().orElse(null);
		searchResult.click();
	
		//self search
		Home().click();
		a.moveToElement(SearchBar()).click().sendKeys(search, Keys.chord(Keys.ENTER)).build().perform();
	
		
		Home().click();
		a.moveToElement(SearchBar()).click().sendKeys("asbdashdjasjdnaskjdnakj", Keys.chord(Keys.ENTER)).build().perform();
	}
	
	public void searchOnTimeline()
	{
		Timeline().click();
		Actions a = new Actions(driver);
		a.moveToElement(searchProfile).click().sendKeys("test", Keys.chord(Keys.ENTER)).build().perform();
	}
	
	public SerpPage searchOnTimelineInvalid()
	{
		Timeline().click();
		Actions a = new Actions(driver);
		a.moveToElement(searchProfile).click().sendKeys("asdasdhjdgyaishduha", Keys.chord(Keys.ENTER)).build().perform();
		SerpPage serpPage = new SerpPage(driver);
		return serpPage;
	}
}
