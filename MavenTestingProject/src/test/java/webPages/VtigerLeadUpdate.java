package webPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import seleniumUtility.Seleniumutil;

public class VtigerLeadUpdate extends Seleniumutil {

	// Initialize current class with WebDriver
	public VtigerLeadUpdate(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//button[text()='Edit']")
	private WebElement leadedit;
	@FindBy(xpath="//button[text()='Save']")
	private WebElement leadupdatesave;
	public WebElement getLeadedit() {
		return leadedit;
	}
	public WebElement getLeadupdatesave() {
		return leadupdatesave;
	}
	public void VtigerleadUpdate() {
		clickOnElement(leadedit);
		clickOnElement(leadupdatesave);
	}
}