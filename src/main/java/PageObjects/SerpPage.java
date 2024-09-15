package PageObjects;

import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AbstractComponent.AbstractComponent;

public class SerpPage extends AbstractComponent {

	WebDriver driver;

	public SerpPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[contains(@href,'/search/posts/')]")
	WebElement Post;

	@FindBy(xpath = "//a[contains(@href,'/search/people/')]")
	WebElement People;

	@FindBy(xpath = "//h1/span/span[contains(text(),'Results for ')]")
	WebElement serpResult;

	@FindBy(xpath = "//input[@aria-label=\"Most Recent First\"]")
	WebElement mostRecentButton;

	@FindBy(xpath = "//input[@aria-label=\"Only Posts You've Seen\"]")
	WebElement onlyPostSeenButton;

	@FindBy(xpath = "(//div[@class='xnfveip'])[1]")
	WebElement postedBy;

	@FindBy(xpath = "//span[text()=\"You\"]")
	WebElement postedByYou;

	@FindBy(xpath = "(//div[@class='xnfveip'])[2]")
	WebElement postedInGroup;

	@FindBy(xpath = "//*[text()='Your Groups']")
	WebElement postedInGroupYourGroups;

	@FindBy(xpath = "(//div[@class='xnfveip'])[3]")
	WebElement date;

	@FindBy(xpath = "//*[text()='2024']")
	WebElement dateSelect;

	@FindBy(xpath = "//input[@aria-label='Hide Comments']")
	WebElement hideComment;

	@FindBy(xpath = "//*[text()='Clear filters']")
	WebElement clearFilters;
	
	//People SERP
	@FindBy(xpath = "//div[contains(@class, 'x1a8lsjc xn6708d x1ye3gou x889kno')]")
	List<WebElement> peopleMenu;

	@FindBy(xpath = "//div[@aria-checked='false']")
	WebElement peopleFilter;

	@FindBy(xpath = "//ul[@role=\"listbox\"]/li")
	List<WebElement> peopleListSelect;
	
	@FindBy(xpath = "//ul[@role=\"listbox\"]/div[@aria-selected=\"false\"]")
	List<WebElement> peopleDivSelect;

	@FindBy(xpath = "peopleFilter.click();")
	WebElement jobTitle;
	
	@FindBy(xpath= "//*[text()='Other department...']")
	WebElement otherDepartment;
	
	@FindBy(xpath = "//*[text()='Other group...']")
	WebElement otherGroup;
	
	@FindBy(xpath= "//*[text()='Other skill...']")
	WebElement otherSkill;
	
	public void serpAllResult(String search) {
		Actions a = new Actions(driver);
		a.moveToElement(SearchBar()).click().sendKeys(search, Keys.chord(Keys.ENTER)).build().perform();
		mostRecentButton.click();
		onlyPostSeenButton.click();
		postedBy.click();
		postedByYou.click();
		postedInGroup.click();
		postedInGroupYourGroups.click();
		date.click();
		dateSelect.click();
		hideComment.click();
		waitForWebElementToAppear(clearFilters);
		clearFilters.click();

	}

	public void serpPost(String search) {
		Actions a = new Actions(driver);
		a.moveToElement(SearchBar()).click().sendKeys(search, Keys.chord(Keys.ENTER)).build().perform();

		Post.click();
		mostRecentButton.click();
		onlyPostSeenButton.click();
		postedBy.click();
		postedByYou.click();
		postedInGroup.click();
		postedInGroupYourGroups.click();
		date.click();
		dateSelect.click();
		hideComment.click();
		waitForWebElementToAppear(clearFilters);
		clearFilters.click();
	}

	public void serpPeople(String search) {
		Actions a = new Actions(driver);
		a.moveToElement(SearchBar()).click().sendKeys(search, Keys.chord(Keys.ENTER)).build().perform();

		People.click();
		peopleMenu.get(0).click();
		try {
			peopleFilter.click();
		} catch (Exception e) {
			jobTitle.click();
			a.moveToElement(peopleListSelect.get(0)).click().build().perform();
			//peopleListSelect.get(0).click();
		}
		peopleMenu.get(1).click();
		try {
			peopleFilter.click();
		} catch (Exception e) {
			otherDepartment.click();
			a.moveToElement(peopleListSelect.get(0)).click().build().perform();
			//peopleListSelect.get(0).click();
		}

		peopleMenu.get(2).click();
		peopleFilter.click();
		
		peopleMenu.get(3).click();
		try {
			peopleFilter.click();
		}catch(Exception e) {
			otherGroup.click();
			a.moveToElement(peopleDivSelect.get(0)).click().build().perform();
			//peopleListSelect.get(0).click();
		}
		
		peopleMenu.get(4).click();
		try {
			peopleFilter.click();
		} catch(Exception e) {
			otherSkill.click();
			a.moveToElement(peopleListSelect.get(0)).click().build().perform();
			//peopleListSelect.get(0).click();
		}
		
		waitForWebElementToAppear(clearFilters);
		clearFilters.click();
	}

	public String serpAllResultValue() {
		String[] r0 = serpResult.getText().split("\""); // (Results for "), (test")
		String[] r1 = r0[1].split("\""); // test "
		return r1[0].trim(); // test
	}

}
