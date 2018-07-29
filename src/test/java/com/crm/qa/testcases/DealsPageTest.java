package com.crm.qa.testcases;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.DealsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class DealsPageTest extends TestBase {
	
	LoginPage loginPage;
	HomePage homePage;
	DealsPage dealsPage;
	TestUtil testUtil;
	String sheetName = "Deals Details";
	
	public DealsPageTest()
	{
		super();
	}
	
	@BeforeClass
	public void setup()
	{
		initialization();
		loginPage = new LoginPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		dealsPage = new DealsPage();
		testUtil = new TestUtil();
		testUtil.switchToFrame();
		
	}
	
	@Test(dataProvider="getDealsData")
	public void addNewDeal(String Title, String Company, String Contact, String Amount)
	{
		
		
		homePage.clickOnDealsLink();
		dealsPage.clickOnNewDeal();
		
		dealsPage.createNewDeal(Title, Company, Contact, Amount);
		dealsPage.clickOnNewDealDropDown();
		
		
	}
	
	@DataProvider
	public Object[][] getDealsData(){
		Object data[][] = TestUtil.getTestData(sheetName);
		return data;
	}
	
	
	@AfterClass
	public void tearDown()
	{
		driver.quit();
	}
	
	
	
	
	
}

