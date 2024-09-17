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
	
	@FindBy(xpath = "//div[contains(@class, 'x1a8lsjc xn6708d x1ye3gou x889kno')]")
	List<WebElement> dropDownMenu;

	@FindBy(xpath = "//*[text()='Today']")
	WebElement dateSelect;
	
	@FindBy(xpath = "//a[contains(@href,'/search/posts/')]")
	WebElement Post;

	@FindBy(xpath = "//a[contains(@href,'/search/people/')]")
	WebElement People;

	@FindBy(xpath = "//h1/span/span[contains(text(),'Results for ')]")
	WebElement serpResult;

	@FindBy(xpath = "//input[@aria-label='Most Recent First']")
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
	
	@FindBy(xpath = "//input[@aria-label='Hide Comments']")
	WebElement hideComment;

	@FindBy(xpath = "//*[text()='Clear filters']")
	WebElement clearFilters;
	
	//People SERP

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
	
	//KL SERP
	@FindBy(xpath= "//a[contains(@href,'/search/work_knowledge/?q')]")
	WebElement kl;
	
	//GROUPS SERP
	@FindBy(xpath = "//a[contains(@href,'/search/groups/?q')]")
	WebElement groups;
	
	@FindBy(xpath = "//*[text()='Open Groups']")
	WebElement groupPrivacy;
	
	@FindBy(xpath = "//*[text()='Your Team']")
	WebElement groupMembers;
	
	@FindBy(xpath = "//*[text()='Announcements']")
	WebElement groupType;
	
	//Files SERP
	@FindBy(xpath = "//a[contains(@href,'/search/files/?q')]")
	WebElement files;
	
	@FindBy(xpath = "//*[text()='Your Groups']")
	WebElement filesPostedInGroup;
	
	//Events SERP
	@FindBy(xpath = "//a[contains(@href,'/search/events/?q')]")
	WebElement events;
	
	//Teams SERP
	@FindBy(xpath = "//a[contains(@href,'/search/work_teams/?q')]")
	WebElement teams;
	
	public void serpAllResult(String search) {
		
		movingToElement(search, SearchBar());
		waitForWebElementToAppear(mostRecentButton);
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
		
		movingToElement(search, SearchBar());
		
		Post.click();
		waitForWebElementToAppear(mostRecentButton);
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
		
		movingToElement(search, SearchBar());

		People.click();
		dropDownMenu.get(0).click();
		try {
			peopleFilter.click();
		} catch (Exception e) {
			jobTitle.click();
			a.moveToElement(peopleListSelect.get(0)).click().build().perform();
			//peopleListSelect.get(0).click();
		}
		dropDownMenu.get(1).click();
		try {
			peopleFilter.click();
		} catch (Exception e) {
			otherDepartment.click();
			a.moveToElement(peopleListSelect.get(0)).click().build().perform();
			//peopleListSelect.get(0).click();
		}

		dropDownMenu.get(2).click();
		peopleFilter.click();
		
		dropDownMenu.get(3).click();
		try {
			peopleFilter.click();
		}catch(Exception e) {
			otherGroup.click();
			a.moveToElement(peopleDivSelect.get(0)).click().build().perform();
			//peopleListSelect.get(0).click();
		}
		
		dropDownMenu.get(4).click();
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
	
	public void serpKL(String search)
	{
		movingToElement(search, SearchBar());
		kl.click();
	}
	
	public void serpGroups(String search)
	{
		movingToElement(search, SearchBar());
		groups.click();
		
		dropDownMenu.get(0).click();
		groupPrivacy.click();
		
		dropDownMenu.get(1).click();
		groupMembers.click();
		
		dropDownMenu.get(2).click();
		groupType.click();
		clearFilters.click();
	}
	
	public TimelinePage serpFiles(String search)
	{
		movingToElement(search, SearchBar());
		files.click();
		
		dropDownMenu.get(0).click();
		filesPostedInGroup.click();
		clearFilters.click();
		TimelinePage timelinePage = new TimelinePage(driver);
		return timelinePage;
	}
	
	public void serpEvents(String search)
	{
		movingToElement(search, SearchBar());
		events.click();
		
		dropDownMenu.get(0).click();
		dateSelect.click();
		clearFilters.click();
	}
	
	public void serpTeams(String search)
	{
		movingToElement(search, SearchBar());
		teams.click();
	}
	public String serpAllResultValue() {
		String[] r0 = serpResult.getText().split("\""); // (Results for "), (test")
		String[] r1 = r0[1].split("\""); // test "
		return r1[0].trim(); // test
	}

}
