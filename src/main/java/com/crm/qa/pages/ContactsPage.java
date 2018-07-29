package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.crm.qa.base.TestBase;

public class ContactsPage extends TestBase{
	
	@FindBy(xpath="//td[contains(text(),'Contacts')]")
	WebElement contactLabel;
	
	@FindBy(name="title")
	WebElement titleDropdown;
	
	@FindBy(id="first_name")
	WebElement firstName;
	
	@FindBy(id="surname")
	WebElement surname;
	
	@FindBy(name="client_lookup")
	WebElement company;
	
	@FindBy(xpath="//input[@type='submit' and @value='Save']")
	WebElement submitButton;
	
	public ContactsPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public Boolean contactLabelIsDisplayed()
	{
		return contactLabel.isDisplayed();
	}
	
	public void addNewContact(String title,String firstName, String lastName, String company)
	{
		Select select = new Select(titleDropdown);
		select.selectByVisibleText(title);
		this.firstName.sendKeys(firstName);
		surname.sendKeys(lastName);
		this.company.sendKeys(company);
		submitButton.click();
		
	}

}
