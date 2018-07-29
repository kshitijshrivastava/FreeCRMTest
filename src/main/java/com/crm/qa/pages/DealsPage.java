package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class DealsPage extends TestBase {
	
	@FindBy(xpath="//input[@value='New Deal']")
	WebElement newDealLink;
	
	@FindBy(id="title")
	WebElement title;
	
	@FindBy(name="client_lookup")
	WebElement company;
	
	@FindBy(name="contact_lookup")
	WebElement contact;
	
	@FindBy(id="amount")
	WebElement amount;
	
	@FindBy(xpath="//*[@id='prospectForm']/table/tbody/tr[1]/td/input[1]")
	WebElement saveButton;
	
	@FindBy(xpath="//a[text()='New Deal']")
	WebElement newDealDropDown;
	
	@FindBy(xpath="//a[@title='Deals']")
	WebElement dealsLink;
	
	public DealsPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public void clickOnNewDeal()
	{
		newDealLink.click();
	}
	
	public void createNewDeal(String dealTitle, String dealCompany, String dealContact, String dealAmount)
	{
		title.sendKeys(dealTitle);
		company.sendKeys(dealCompany);
		contact.sendKeys(dealContact);
		amount.sendKeys(dealAmount);
		saveButton.click();
	}
	
	public void clickOnNewDealDropDown()
	{
		Actions a = new Actions(driver);
		a.moveToElement(dealsLink).moveToElement(newDealDropDown).click().build().perform();
		
	}
	
	
	
	
	
	

}
