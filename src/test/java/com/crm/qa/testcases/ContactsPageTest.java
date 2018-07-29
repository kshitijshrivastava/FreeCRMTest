package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class ContactsPageTest extends TestBase {
	
	LoginPage loginPage;
	HomePage homePage;
	ContactsPage contactsPage;
	TestUtil testUtil;
	String sheetName = "Sheet1";
	
	public ContactsPageTest()
	{
		super();
	}
	
	@BeforeMethod
	public void setup()
	{
		initialization();
		loginPage = new LoginPage();
		testUtil = new TestUtil();
		contactsPage = new ContactsPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		testUtil.switchToFrame();
		//contactsPage = homePage.clickOnContactsLink();
	}
	
	@Test(priority=1)
	public void verifyContactPageLabel()
	{
		contactsPage = homePage.clickOnContactsLink();
		Assert.assertTrue(contactsPage.contactLabelIsDisplayed(), "Contact Page Label is not displayed");
	}
	
	@Test(priority=2, dataProvider="getCRMTestData")
	public void addNewContacts(String title, String firstName, String lastName, String company)
	{
		
		System.out.println("before clicking on new contact");
		homePage.clickOnNewContactsLink();
		System.out.println("after clicking on new contact");
		contactsPage.addNewContact(title, firstName, lastName, company);
		/*homePage.clickOnNewContactsLink();
		contactsPage.addNewContact("Mr.", "Henry", "Chris", "Amazon");*/
		
	}
	
	@DataProvider
	public Object[][] getCRMTestData(){
		Object data[][] = TestUtil.getTestData(sheetName);
		return data;
	}
	
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
	

}
