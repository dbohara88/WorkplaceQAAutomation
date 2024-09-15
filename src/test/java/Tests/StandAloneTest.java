package Tests;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class StandAloneTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://qaprod.workplace.com/");
		
		
		driver.findElement(By.cssSelector(".inputtext")).sendKeys("bhaktadeepak+nahida@prod.wptst.com");
		driver.findElement(By.xpath("//div/button")).click();
		
		WebDriverWait wh = new WebDriverWait(driver, Duration.ofSeconds(5));
		Actions a = new Actions(driver);

		driver.findElement(By.xpath("//input[@type='password']")).sendKeys("lsspl#123");
		driver.findElement(By.xpath("//div/button")).click();
		
//		
//		driver.findElement(By.xpath("//ul[@aria-label=\"Groups\"]/div")).click();
//		driver.findElement(By.xpath("//span[@class=\"x193iq5w xeuugli x13faqbe x1vvkbs x1xmvt09 x1nxh6w3 x1sibtaa x1s688f xi81zsa\"]")).click();
//		driver.findElement(By.xpath("(//div[@aria-label=\"Add people\"])[2]")).click();
//		driver.findElement(By.xpath("//label[@aria-label=\"Add by name or email address\"]")).sendKeys("deepak");
//		
//		List<WebElement> memberList = driver.findElements(By.xpath("//ul[@class=\"x1cy8zhl x9f619 xe8uvvx x2lwn1j xeuugli x78zum5 xdt5ytf x1qughib xahult9 x1mpkggp x1yc453h\"]"));
//	
//		for(WebElement w: memberList)
//		{
//			if(w.isEnabled())
//			{
//				a.moveToElement(w).click().build().perform();
//			}
//		}
//		
//		
		
		
//		
//		// test case 1
//		Actions a = new Actions(driver, Duration.ofSeconds(5));
//		wh.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//input[@placeholder=\"Search Workplace\"]"))));
//		a.moveToElement(driver.findElement(By.xpath("//input[@placeholder=\"Search Workplace\"]"))).click().sendKeys("test", Keys.chord(Keys.ENTER)).build().perform();
//		
//		
//	
//		System.out.println(driver.findElement(By.xpath("//h1/span/span[contains(text(),'Results for ')]")).getText());
//		driver.quit();
		
		driver.findElement(By.xpath("//div[@aria-label=\"See more\"]/div/i")).click();
		driver.findElement(By.xpath("//a[@href='https://qaprod.workplace.com/work/orgsearch/']")).click();
		driver.findElement(By.xpath("//div[@aria-label='Add filter']")).click();
		//Actions a = new Actions(driver);
		List<WebElement> ss = driver.findElements(By.xpath("//div[@class=\"x1i10hfl xjbqb8w x1ejq31n xd10rxx x1sy0etr x17r0tee x972fbf xcfux6l x1qhh985 xm0m39n xe8uvvx x1hl2dhg xggy1nq x1o1ewxj x3x9cwd x1e5q0jg x13rtm0m x87ps6o x1lku1pv x1a2a7pz xjyslct x9f619 x1ypdohk x78zum5 x1q0g3np x2lah0s x1i6fsjq xfvfia3 xnqzcj9 x1gh759c x10wwi4t x1x7e7qh x1344otq x1de53dj x1n2onr6 x16tdsg8 x1ja2u2z x6s0dn4\"]"));
		int count = ss.size()-1;
		while(count >= 0)
		{
			ss = driver.findElements(By.xpath("//div[@class=\"x1i10hfl xjbqb8w x1ejq31n xd10rxx x1sy0etr x17r0tee x972fbf xcfux6l x1qhh985 xm0m39n xe8uvvx x1hl2dhg xggy1nq x1o1ewxj x3x9cwd x1e5q0jg x13rtm0m x87ps6o x1lku1pv x1a2a7pz xjyslct x9f619 x1ypdohk x78zum5 x1q0g3np x2lah0s x1i6fsjq xfvfia3 xnqzcj9 x1gh759c x10wwi4t x1x7e7qh x1344otq x1de53dj x1n2onr6 x16tdsg8 x1ja2u2z x6s0dn4\"]"));
			a.moveToElement(ss.get(count)).click().build().perform();
			driver.findElement(By.cssSelector("input[placeholder='…']")).sendKeys("test");
			driver.findElement(By.xpath("//div[@aria-label=\"Add filter\"]")).click();
			count--;
//			if(count  > 0)
//			{
//				driver.findElement(By.xpath("//div[@aria-label='Add filter']")).click();
//				ss.get(0).click();
//				driver.findElement(By.cssSelector("input[placeholder='…']")).sendKeys("test");
//				driver.findElement(By.xpath("//div[@aria-label=\"Add filter\"]")).click();
//			}
		}
		
		
		List<WebElement> deleteList = driver.findElements(By.xpath("//div[@class='x6s0dn4 x1vtvx1t xhk9q7s x1otrzb0 x1i1ezom x1o6z2jb x78zum5']"));
		int counts = deleteList.size()-1;
		
		int i = 0;
		while(!driver.findElements(By.xpath("//div[@class=\"x6s0dn4 x1vtvx1t xhk9q7s x1otrzb0 x1i1ezom x1o6z2jb x78zum5\"]")).isEmpty())
		{
			

			deleteList = driver.findElements(By.xpath("//div[@class=\"x6s0dn4 x1vtvx1t xhk9q7s x1otrzb0 x1i1ezom x1o6z2jb x78zum5\"]"));	
			a.moveToElement(deleteList.get(counts-i)).click().build().perform();
			a.moveToElement(driver.findElement(By.cssSelector("input[placeholder='…']"))).doubleClick().sendKeys(Keys.chord(Keys.DELETE), Keys.chord(Keys.ENTER)).build().perform();
			i++;
		}
		driver.close();
//		List<WebElement> searchList;
//		
//		//search suggestion
//		searchList = driver.findElements(By.xpath("(//div[@class='x1yztbdb'])[1]"));
//		WebElement searchSuggestion = searchList.stream().findFirst().orElse(null);
//		searchSuggestion.click();
//	
//		//self search
//		driver.findElement(By.id("home")).click();
//		a.moveToElement(driver.findElement(By.xpath("//input[@placeholder=\"Search Workplace\"]"))).click().sendKeys("test", Keys.chord(Keys.ENTER)).build().perform();
//	
//		
//		driver.findElement(By.id("home")).click();
//		a.moveToElement(driver.findElement(By.xpath("//input[@placeholder=\"Search Workplace\"]"))).click().sendKeys("asbdashdjasjdnaskjdnakj", Keys.chord(Keys.ENTER)).build().perform();
		
	}

}
