package AbstractComponent;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AbstractComponent {

	WebDriver driver;

	public AbstractComponent(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id = "home")
	WebElement HomeButton;
	
	@FindBy(id = "profile")
	WebElement profile;
	
	@FindBy(xpath = "//a[@role='menuitem']/div[@class='x1rg5ohu x1n2onr6 x3ajldb x1ja2u2z']")
	WebElement timeline;
	
	@FindBy(xpath="//input[@placeholder=\"Search Workplace\"]")
	WebElement searchBar;
	
	@FindBy(xpath = "//div[@aria-label=\"See more\"]/div/i")
	WebElement seeMore;
	
	@FindBy(xpath = "//a[@href=\"https://qaprod.workplace.com/work/orgsearch/\"]")
	WebElement directory;

	public void waitForWebElementToAppear(WebElement findBy)
	{
		WebDriverWait wh = new WebDriverWait(driver, Duration.ofSeconds(5));
		wh.until(ExpectedConditions.visibilityOf(findBy));
	}
	
	public void movingToElement(String search, WebElement findby)
	{
		Actions a = new Actions(driver);
		a.moveToElement(findby).click().sendKeys(search, Keys.chord(Keys.ENTER)).build().perform();
	}
	
	public void windowScrollBy()
	{
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0, 500)");
	}
	public WebElement Home()
	{
		return HomeButton;
	}
	
	public WebElement Timeline()
	{
		profile.click();
		return timeline;
	}
	
	public WebElement SearchBar()
	{
		return searchBar;
	}
	
	public WebElement SeeMore()
	{
		return seeMore;
	}
	
	public WebElement Directory()
	{
		return directory;
	}
	
}
