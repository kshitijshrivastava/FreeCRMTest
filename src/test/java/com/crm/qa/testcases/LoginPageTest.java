/***
Login page Test method
***/

package com.crm.qa.testcases;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class LoginPageTest extends TestBase {
	
	LoginPage loginPage; 
	HomePage homePage;
	//Logger log = Logger.getLogger("devpinoyLogger");
	Logger log = Logger.getLogger(LoginPageTest.class.getClass());
	
	/*@Test
	public void loggingCheck()
	{
		log.info("Information message");
		log.debug("Debugging info");
		log.error("This is error");
	}*/
	
	public LoginPageTest()
	{
		super();
	}
	
	@BeforeMethod
	public void setup()
	{
		initialization();
		loginPage= new LoginPage();
		
		
	}
	
	
	
	@Test(priority=1)
	public void logonPageTitleTest()
	{
		log.info("Asserting the login page title");
		String title = loginPage.validateLoginPageTitle();
		Assert.assertEquals(title, prop.getProperty("loginPageTitle"));
	}
	
	@Test(priority=2)
	public void crmLogoTest()
	{
		log.info("Asserting the logo");
		boolean flag = loginPage.validateCRMImage();
		Assert.assertTrue(flag);
	}
	
	@Test(priority=3)
	public void loginTest()
	{
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		/*String property1 = prop.getProperty("username");
		System.out.println(property1);
		System.out.println(prop.getProperty("password"));*/
		
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}

}
