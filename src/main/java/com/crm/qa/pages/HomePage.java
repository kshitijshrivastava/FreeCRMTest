package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase {
	
	@FindBy(xpath="//td[contains(text(),'User: Kshitij Shrivastava')]")
	WebElement userLabel;
	
	@FindBy(xpath="//a[@title='Contacts']")
	WebElement contactsLink;
	
	@FindBy(xpath="//a[@title='New Contact']")
	WebElement newContactLink;
	
	@FindBy(xpath="//a[@title='Deals']")
	WebElement dealsLink;
	
	@FindBy(xpath="//a[@title='Tasks']")
	WebElement tasksLink;
	
	public HomePage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public String validateUserLabel()
	{
		return userLabel.getText();
	}
	
	public Boolean validateUserLabelIsDisplayed()
	{
		return userLabel.isDisplayed();
	}
	
	public ContactsPage clickOnContactsLink()
	{
		contactsLink.click();
		return new ContactsPage();
	}
	
	public DealsPage clickOnDealsLink()
	{
		dealsLink.click();
		return new DealsPage();
	}
	
	public TasksPage clickOnTasksLink()
	{
		tasksLink.click();
		return new TasksPage();
		
	}
	
	public void clickOnNewContactsLink()
	{
	    System.out.println("Executing click on new contacts link of home page");
		Actions a = new Actions(driver);
	   

	    WebDriverWait d = new WebDriverWait(driver,20);
	    //d.until(ExpectedConditions.elementToBeClickable(contactsLink));
	    

	    a.moveToElement(contactsLink).build().perform();
	    d.until(ExpectedConditions.elementToBeClickable(newContactLink));
		newContactLink.click();
		
	}
	
	

}
