package webPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import seleniumUtility.Seleniumutil;

public class VtigerLeadDelete extends Seleniumutil {

	// Initialize current class with WebDriver
	public VtigerLeadDelete(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="/html/body/div/div[4]/div/div[2]/div/div/div/div/div[2]/div/div/button[5]/i")
	private WebElement leads;
	@FindBy(xpath="//a[text()='Delete Lead']")
	private WebElement deletelead;
	@FindBy(xpath="//button[text()='Yes']")
	private WebElement deleteleadyes;
	public WebElement getLeads() {
		return leads;
	}
	public WebElement getDeletelead() {
		return deletelead;
	}
	public WebElement getDeleteleadyes() {
		return deleteleadyes;
	}
	public void VtigerleadDelete() {
		clickOnElement(leads);
		clickOnElement(deletelead);
		clickOnElement(deleteleadyes);
	}
}
