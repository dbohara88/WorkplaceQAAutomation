package PageObjects;

import org.openqa.selenium.WebDriver;

import AbstractComponents.AbstractComponents;

public class DirectoryPage extends AbstractComponents{

	WebDriver driver;
	public DirectoryPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}
	
	

}
