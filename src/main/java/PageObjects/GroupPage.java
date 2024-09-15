package PageObjects;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AbstractComponent.AbstractComponent;

public class GroupPage extends AbstractComponent{

	WebDriver driver;
	public GroupPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//ul[@aria-label=\"Groups\"]/div")
	List<WebElement> groupPage;
	
	@FindBy(xpath = "//input[@aria-label=\"Search Group\"]")
	WebElement searchGroup;
	
	@FindBy(xpath = "//div[@aria-label=\"Cancel\"]")
	WebElement cancelSearch;
	
	@FindBy(xpath = "//div[@class=\"x150jy0e x1rdy4ex\"]")
	WebElement groupSearchMember;
	
	@FindBy(xpath = "//input[@placeholder=\"Find a member\"]")
	WebElement findGroupMember;
	
	@FindBy(xpath = "(//div[@aria-label=\"Add people\"])[2]")
	WebElement addGroupMemberButton;

	@FindBy(xpath = "//label[@aria-label=\"Add by name or email address\"]")
	WebElement addGroupMember;
	
	@FindBy(xpath = "//ul[@class=\"x1cy8zhl x9f619 xe8uvvx x2lwn1j xeuugli x78zum5 xdt5ytf x1qughib xahult9 x1mpkggp x1yc453h\"]")
	List<WebElement> memberDropDownList;
	
	public void groupSearch(String search)
	{
		Home().click();
		WebElement group = groupPage.stream().findFirst().orElse(null);
		group.click();
		
		searchGroup.sendKeys(search, Keys.chord(Keys.ENTER));
		cancelSearch.click();
		
	}
	
	public void searchGroupMember(String search)
	{
		Actions a = new Actions(driver);
		groupSearchMember.click();
		findGroupMember.sendKeys(search);
		a.moveToElement(findGroupMember).doubleClick().sendKeys(Keys.chord(Keys.DELETE)).build().perform();
		addGroupMemberButton.click();
		addGroupMember.sendKeys(search);
		
		for(WebElement w: memberDropDownList)
		{
			if(w.isEnabled())
			{
				a.moveToElement(w).click().build().perform();
				break;
			}
		}
	}

}
