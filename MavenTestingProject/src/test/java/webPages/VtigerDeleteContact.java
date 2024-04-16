package webPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import seleniumUtility.Seleniumutil;

public class VtigerDeleteContact extends Seleniumutil{

	//Initialize current class with WebDriver
	public VtigerDeleteContact(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="/html/body/div/div[4]/div/div[2]/div/div/div[1]/div/div[2]/div/div/button[4]/i")
	private WebElement deletebutton;
	
	@FindBy(xpath="//a[text()='Delete Contact']")
	private WebElement deleteContact;
	
	@FindBy(xpath="//button[text()='Yes']")
	private WebElement contactdeleted;

	public WebElement getDelete() {
		return deletebutton;
	}

	public WebElement getDeleteContact() {
		return deleteContact;
	}

	public WebElement getYes() {
		return contactdeleted;
	}
	
	public void VtigerContactDelete() {
		clickOnElement(deletebutton);
		clickOnElement(deleteContact);
		clickOnElement(contactdeleted);
	}
	
}
