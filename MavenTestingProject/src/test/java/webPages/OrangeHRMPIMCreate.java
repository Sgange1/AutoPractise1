package webPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import seleniumUtility.Seleniumutil;

public class OrangeHRMPIMCreate extends Seleniumutil{

	//Initialize current class with WebDriver
	public OrangeHRMPIMCreate(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//span[text()='PIM']")
	private WebElement CreatePIM;
	@FindBy(xpath="/html/body/div/div/div[2]/div/div/div[2]/div/button")
	private WebElement buttonC;
	@FindBy(name="firstName")
	private WebElement firstnameInput;
	@FindBy(name="middleName")
	private WebElement middleNameInput;
	@FindBy(name="lastName")
	private WebElement lastNameInput;
	@FindBy(xpath="/html/body/div/div/div[2]/div/div/div/form/div[2]/button[2]")
	private WebElement PIMcreated;
	public WebElement getCreatePIM() {
		return CreatePIM;
	}
	public WebElement getButtonC() {
		return buttonC;
	}
	public WebElement getFirstname() {
		return firstnameInput;
	}
	public WebElement getMiddleName() {
		return middleNameInput;
	}
	public WebElement getLastName() {
		return lastNameInput;
	}
	public WebElement getPIMcreated() {
		return PIMcreated;
	}
	
	public void OrangePIMCreate(String firstname, String middlename, String lastname) {
		clickOnElement(CreatePIM);
		clickOnElement(buttonC);
		typeRequiredText(firstnameInput, firstname);
		typeRequiredText(middleNameInput, middlename);
		typeRequiredText(lastNameInput, lastname);
		clickOnElement(PIMcreated);
		
		
	}
}
