package PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import AbstractComponent.AbstractComponent;

public class DirectoryPage extends AbstractComponent{

	WebDriver driver;
	public DirectoryPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}
	
	@FindBy(xpath = "//div[@aria-label=\"Add filter\"]")
	WebElement addFilter;
	
	@FindBy(xpath = "//div[@class=\"x1i10hfl xjbqb8w x1ejq31n xd10rxx x1sy0etr x17r0tee x972fbf xcfux6l x1qhh985 xm0m39n xe8uvvx x1hl2dhg xggy1nq x1o1ewxj x3x9cwd x1e5q0jg x13rtm0m x87ps6o x1lku1pv x1a2a7pz xjyslct x9f619 x1ypdohk x78zum5 x1q0g3np x2lah0s x1i6fsjq xfvfia3 xnqzcj9 x1gh759c x10wwi4t x1x7e7qh x1344otq x1de53dj x1n2onr6 x16tdsg8 x1ja2u2z x6s0dn4\"]")
	List<WebElement> filterList;
	
	@FindBy(xpath = "//div[@class=\"x1i10hfl xjbqb8w x1ejq31n xd10rxx x1sy0etr x17r0tee x972fbf xcfux6l x1qhh985 xm0m39n xe8uvvx x1hl2dhg xggy1nq x1o1ewxj x3x9cwd x1e5q0jg x13rtm0m x87ps6o x1lku1pv x1a2a7pz xjyslct x9f619 x1ypdohk x78zum5 x1q0g3np x2lah0s x1i6fsjq xfvfia3 xnqzcj9 x1gh759c x10wwi4t x1x7e7qh x1344otq x1de53dj x1n2onr6 x16tdsg8 x1ja2u2z x6s0dn4\"]")
	List<WebElement> assignList;
	
	@FindBy(css = "input[placeholder='…']")
	WebElement placeholder;
	
	@FindBy(xpath = "//div[@class='x6s0dn4 x1vtvx1t xhk9q7s x1otrzb0 x1i1ezom x1o6z2jb x78zum5']")
	List<WebElement> deleteList;
	
	@FindBy(xpath = "//div[@class='x6s0dn4 x1vtvx1t xhk9q7s x1otrzb0 x1i1ezom x1o6z2jb x78zum5']")
	List<WebElement> deleteList1;
	
	public GroupPage searchDirectory(String search)
	{
		Actions a = new Actions(driver);
		Home().click();
		SeeMore().click();
		Directory().click();
		addFilter.click();
		int count  = filterList.size()-1;
		while(count >= 0)
		{
			filterList = assignList;
			a.moveToElement(filterList.get(count)).click().build().perform();
			placeholder.sendKeys(search);
			addFilter.click();
			count--;
		}
		
		int deleteCount = deleteList.size()-1;
		int i = 0;
		while(!deleteList.isEmpty())
		{
			deleteList = deleteList1;
			a.moveToElement(deleteList.get(deleteCount-i)).click().build().perform();
			a.moveToElement(placeholder).doubleClick().sendKeys(Keys.chord(Keys.DELETE), Keys.chord(Keys.ENTER)).build().perform();
			i++;
		}
		GroupPage groupPage = new GroupPage(driver);
		return groupPage;
	}

}
