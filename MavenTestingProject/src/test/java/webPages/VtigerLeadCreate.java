package webPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import seleniumUtility.Seleniumutil;

public class VtigerLeadCreate extends Seleniumutil{

	//Initialize current class with WebDriver
	public VtigerLeadCreate(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="/html/body/div/div[5]/div/div[2]/div[2]/div/div/span[2]")
	private WebElement marketingselect;
	@FindBy(xpath="/html/body/div/div/div/div[2]/div[2]/ul/div/div/li[2]/a/span[2]")
	private WebElement leadselect;
	
	@FindBy(xpath="/html/body/div[1]/nav/div[2]/div/div[3]/div/div[2]/div/nav/div/div[2]/ul/li[1]/button")
	private WebElement leadcreate;
	@FindBy(xpath="//button[text()='Save']")
	private WebElement leadsave;
	
	public WebElement getMarketingselect() {
		return marketingselect;
	}

	public WebElement getLeadselect() {
		return leadselect;
	}

	public WebElement getLeadcreate() {
		return leadcreate;
	}

	public WebElement getLeadsave() {
		return leadsave;
	}

	public void VtigerleadCreate() {
		clickOnElement(marketingselect);
		clickOnElement(leadselect);
		clickOnElement(leadcreate);
		clickOnElement(leadsave);
	}
}
