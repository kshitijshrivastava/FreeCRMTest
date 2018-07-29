/***
Home page Test method
***/
package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class HomePageTest extends TestBase{
	
	LoginPage loginPage;
	HomePage homePage;
	ContactsPage contactsPage;
	TestUtil testUtil;
	
	public HomePageTest()
	{
		super();
	}
	
	@BeforeMethod
	public void setup()
	{
		initialization();
		testUtil = new TestUtil();
		loginPage = new LoginPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		contactsPage = new ContactsPage();
		
	}
	
	@Test(priority=1)
	public void validateUserNameLabelIsDisplayed()
	{
		testUtil.switchToFrame();
		Boolean flag =homePage.validateUserLabelIsDisplayed();
		String userNameLabel = homePage.validateUserLabel();
		System.out.println(userNameLabel);
		Assert.assertTrue(flag);
	}
	
	@Test(priority=2)
	public void validateUserNameLabelTest()
	{
		testUtil.switchToFrame();
		String userNameLabel = homePage.validateUserLabel();
		Assert.assertEquals(userNameLabel, "  User: Kshitij Shrivastava");
	}
	
	@Test(priority=3)
	public void verifyContactListTest()
	{
		testUtil.switchToFrame();
		contactsPage = homePage.clickOnContactsLink();
	}
	/*@Test(priority=4)
	public void clickOnNewContactLink()
	{
		testUtil.switchToFrame();
		homePage.clickOnNewContactsLink();
	}*/
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}

}
