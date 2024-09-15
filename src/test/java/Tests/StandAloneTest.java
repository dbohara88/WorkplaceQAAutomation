package Tests;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
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
		
		
		driver.findElement(By.cssSelector(".inputtext")).sendKeys("bhaktadeepak+d1@prod.wptst.com");
		driver.findElement(By.xpath("//div/button")).click();
		
		WebDriverWait wh = new WebDriverWait(driver, Duration.ofSeconds(5));

		driver.findElement(By.xpath("//input[@type='password']")).sendKeys("lsspl#123");
		driver.findElement(By.xpath("//div/button")).click();
		
		// test case 1
		Actions a = new Actions(driver, Duration.ofSeconds(5));
		wh.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//input[@placeholder=\"Search Workplace\"]"))));
		a.moveToElement(driver.findElement(By.xpath("//input[@placeholder=\"Search Workplace\"]"))).click().sendKeys("test", Keys.chord(Keys.ENTER)).build().perform();
		
		
	
		System.out.println(driver.findElement(By.xpath("//h1/span/span[contains(text(),'Results for ')]")).getText());
		driver.quit();
		


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
