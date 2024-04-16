package webPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import seleniumUtility.Seleniumutil;


public class VtigerCreateContactPage extends Seleniumutil{

	//Initialize current class with WebDriver
	public VtigerCreateContactPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="/html/body/div/nav/div/div/div/div/div/div/span")
	private WebElement dropdown;
	
	@FindBy(xpath="//span[text()=' MARKETING']")
	private WebElement marketingselect;
	
	@FindBy(xpath="/html/body/div/div/div/div[2]/div[2]/ul/div/div/li[3]/a/span[2]")
	private WebElement contactselect;
	
	@FindBy(xpath="/html/body/div/nav/div[2]/div/div[3]/div/div[2]/div/nav/div/div[2]/ul/li[1]/button[1]")
	private WebElement addcontact;
	
	@FindBy(xpath="//button[text()='Save']")
	private WebElement save;
	

	public WebElement getDropdown() {
		return dropdown;
	}


	public WebElement getMarketingselect() {
		return marketingselect;
	}


	public WebElement getContactselect() {
		return contactselect;
	}


	public WebElement getAddcontact() {
		return addcontact;
	}


	public WebElement getSave() {
		return save;
	}


	public void loginIntoVtigerContact() {
		clickOnElement(dropdown);
		clickOnElement(marketingselect);
		clickOnElement(contactselect);
		clickOnElement(addcontact);
		clickOnElement(save);
		
	}
	
}