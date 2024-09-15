package Tests;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import PageObjects.SearchHomePage;
import PageObjects.SerpPage;
import TestComponents.BaseTest;

public class WorkplaceSearch extends BaseTest{
	
	@Test(dataProvider = "getData")
	public void search(HashMap<String, String> input)
	{
		SearchHomePage searchhomepage = landingpage.loginApp(input.get("email"), input.get("pass"));
		searchhomepage.userCanSearch(input.get("search"));
		searchhomepage.searchOnTimeline();
		searchhomepage.searchOnTimelineInvalid();
		
		SerpPage serpPage = new SerpPage(driver);
		serpPage.serpAllResult(input.get("search"));
		// serpAllResult validation
		Assert.assertEquals(serpPage.serpAllResultValue(), input.get("search"));
		serpPage.serpPost(input.get("search"));
		serpPage.serpPeople(input.get("search"));
	}
	
	
	
	@DataProvider
	public Object[][] getData() throws IOException
	{
		List<HashMap<String, String>> data = getJsonDataToMap(System.getProperty("user.dir") + "/src/test/java/Data/Search.json");
		return new Object[][]{{data.get(0)}, {data.get(1)}};
	}
}
