package webPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import seleniumUtility.Seleniumutil;

public class VtigerUpdateContact extends Seleniumutil{

	//Initialize current class with WebDriver
	public VtigerUpdateContact(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//button[text()='Edit']")
	private WebElement edit;
	@FindBy(xpath="//button[text()='Save']")
	private WebElement save;
	
	public WebElement getEdit() {
		return edit;
	}
	public WebElement getSave() {
		return save;
	}
	
	public void VtigerContactUpdate() {
		clickOnElement(edit);
		clickOnElement(save);
	}
}